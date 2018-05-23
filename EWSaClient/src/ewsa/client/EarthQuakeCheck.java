/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewsa.client;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
/**
 *
 * @author nicholas
 */
public class EarthQuakeCheck implements Runnable{
    
    private int limit;
    private String lastEqId= "";
    private String defaultURL="http://localhost:3000/quake?limit=";
    private JLabel labelMagn;
    private JLabel labelLoc;
    private JLabel labelDate;
    private JLabel labelTime;
    private JLabel labelCoo;
    private JLabel labelDist;
    private JTable tableInfo;
    private LinkedList<String> getInfoList;
    private String pass2= "labiopalatoschisi";    //password to add
    private String clientPass= "";
    private Settings settings;
    private JButton btnStart;
    private JButton btnStop;
    private DistCoord distCoo;
    private Warning warning;
    private String distance;
    private JButton btnLogout;
    private JButton btnSettings;
    private JButton btnGetInfo;
    private JLabel labelWarning;
    
    public EarthQuakeCheck(JLabel labelMagn, JLabel labelLoc, JLabel labelDate, JLabel labelTime, JLabel labelCoo, JLabel labelDist, JButton btnStart, JButton btnStop, JButton btnLogout, JButton btnSettings, JButton btnGetInfo, JLabel labelWarning){
        //polling
        this.limit=1;
        this.labelMagn= labelMagn;
        this.labelLoc= labelLoc;
        this.labelDate= labelDate;
        this.labelTime= labelTime;
        this.labelCoo= labelCoo;
        this.labelDist= labelDist;
        this.settings= new Settings();
        this.btnStart= btnStart;
        this.btnStop= btnStop;
        clientPass+=settings.getStingValue("clientPass")+pass2;
        this.distCoo= new DistCoord();
        this.warning= new Warning(labelWarning, labelMagn, labelLoc);
        this.btnLogout= btnLogout;
        this.btnSettings= btnSettings;
        this.btnGetInfo= btnGetInfo;
        this.labelWarning= labelWarning;
    }
    
    public EarthQuakeCheck(JTable tableInfo){
        //getInfo
        this.settings= new Settings();
        this.limit=settings.getIntValue("usrLimit");
        this.tableInfo=tableInfo;
        this.settings= new Settings();
        clientPass+=settings.getStingValue("clientPass")+pass2;
        this.distCoo= new DistCoord();
    }
        
    @Override
    public void run() {
        int limitInt= limit;
        if(limitInt==1){
            startGUI();
            while(true){
                try {
                    polling();
                    Thread.sleep(1000);    //sleep Thread 1 sec
                    if(settings.getBoolValue("stopServer")){
                        stopGUI();
                        return;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(EarthQuakeCheck.class.getName()).log(Level.SEVERE, null, ex);
                    stopGUI();
                }
            }
        }
        else{
            getInfoList= new LinkedList<String>();
            getInfo();
        }
    }
    
    private void startGUI(){
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        btnLogout.setEnabled(false);
        btnSettings.setEnabled(false);
        btnGetInfo.setEnabled(false);
    }
    
    private void stopGUI(){
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnLogout.setEnabled(true);
        btnSettings.setEnabled(true);
        btnGetInfo.setEnabled(true);
        settings.SaveSetting("boolean", "stopServer", "false");
    }
    
    
    private void refreshLastEq(String place, String time, String magn, String coord0, String coord1){
        String tmpTime= time.split(" ")[1];
        String tmpDate= time.split(" ")[0];
        labelTime.setText(tmpTime);
        labelDate.setText(tmpDate);
        labelLoc.setText(place);
        labelMagn.setText(magn);
        labelCoo.setText(coord0+", "+coord1);
        if(this.distance.length()>=1) labelDist.setText(this.distance+" Km");
        else labelDist.setText("");
    }
    
    private void refreshTable(){
        //array: place, time, magn
        //table: date, time, location, magnitude
        int listSize= getInfoList.size();
        int rowNum= tableInfo.getRowCount();
        if(listSize>rowNum){
            DefaultTableModel model = (DefaultTableModel) tableInfo.getModel();
            model.setRowCount(listSize);
        }
        Iterator<String> itList= getInfoList.iterator();
        int rowCounter=0;
        while(itList.hasNext()){
            String tmpArray[]= itList.next().split("~");
            String tmpDate= tmpArray[1].split(" ")[0];
            String tmpTime= tmpArray[1].split(" ")[1];
            tableInfo.getModel().setValueAt(tmpDate, rowCounter, 0);
            tableInfo.getModel().setValueAt(tmpTime, rowCounter, 1);
            tableInfo.getModel().setValueAt(tmpArray[0], rowCounter, 2);
            tableInfo.getModel().setValueAt(tmpArray[2], rowCounter, 3);
            rowCounter++;
        }
    }
    
    private boolean lastQuakeCheck(String id){
        //TRUE new EarthQuake
        if(lastEqId.length()<1){
            lastEqId=id;
            return true;
        }
        if(!lastEqId.equals(id)) return true;
        return false;
    }
    
    private boolean locationFilter(String coord0, String coord1){
        //TRUE if location is within user-set limit.
        String myLocStr= settings.getStingValue("usrLocation");
        if(myLocStr.equals("worldwide")){
            this.distance= "";
            return true;
        }
        double myCoo1= Double.parseDouble(myLocStr.split(", ")[0]);
        double myCoo2= Double.parseDouble(myLocStr.split(", ")[1]);
        double incomeLoc1= Double.parseDouble(coord0);
        double incomeLoc2= Double.parseDouble(coord1);
        double dist= distCoo.getDist(myCoo1, myCoo2, incomeLoc2, incomeLoc1);
        double usrDistance= settings.getIntValue("usrDist");
        //System.out.println("usrDistance: " + usrDistance + "\t Dist: " + dist);   //debug
        if(usrDistance>=dist){
            this.distance=Integer.toString((int) dist);
            return true;
        }
        return false;
    }
    
    private boolean magnitudeFilter(String magnStr){
        double magn= Double.parseDouble(magnStr);
        double usrMagn= (double) settings.getIntValue("usrMagn");
        if(magn>=usrMagn) return true;
        return false;
    }
    
    private void polling(){
        BufferedReader br=null;
        try {
            URL url=new URL(defaultURL+limit+"&passw="+clientPass);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String ret= br.readLine();
            JSONObject j=new JSONObject(ret);
            JSONArray data=j.getJSONArray("elem");
            for (int i=0;i<data.length();i++) {
                JSONObject dataElem=data.optJSONObject(i);
                String id=dataElem.getString("id");
                String place=dataElem.getString("place");
                String time=dataElem.getString("time");
                String magn=dataElem.getString("magn");
                String coord0=dataElem.getString("coord").split(",")[0].substring(1);
                String coord1=dataElem.getString("coord").split(",")[1];

                //System.out.println("id: "+id+" Place: "+place+" time: "+time+" Magn: "+magn +" coord0: "+coord0 +" coord1: "+coord1);                
                if(locationFilter(coord0, coord1) && magnitudeFilter(magn) && lastQuakeCheck(id)){
                    refreshLastEq(place, time, magn, coord0, coord1);
                    warning.start();
                    settings.SaveSetting("string", "lastEqCoo0", coord0);
                    settings.SaveSetting("string", "lastEqCoo1", coord1);
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(EarthQuakeCheck.class.getName()).log(Level.SEVERE, null, ex);
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
        } catch (JSONException ex) {
            Logger.getLogger(EarthQuakeCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void getInfo(){
        BufferedReader br=null;
        try {
            URL url=new URL(defaultURL+limit+"&passw="+clientPass);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String ret= br.readLine();
            JSONObject j=new JSONObject(ret);
            JSONArray data=j.getJSONArray("elem");
            for (int i=0;i<data.length();i++) {
                JSONObject dataElem=data.optJSONObject(i);
                String id=dataElem.getString("id");
                String place=dataElem.getString("place");
                String time=dataElem.getString("time");
                String magn=dataElem.getString("magn");
                String coord0=dataElem.getString("coord").split(",")[0].substring(1);
                String coord1=dataElem.getString("coord").split(",")[1];

                //System.out.println("id: "+id+" Place: "+place+" time: "+time+" Magn: "+magn +" coord0: "+coord0 +" coord1: "+coord1);                
                if(locationFilter(coord0, coord1)){
                    String toAdd= place+"~"+time+"~"+magn;
                    getInfoList.add(toAdd);
                }
            }
            refreshTable();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(EarthQuakeCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(EarthQuakeCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

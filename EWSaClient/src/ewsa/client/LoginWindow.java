/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewsa.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author biar
 */
public class LoginWindow {
    
    private static String url= "http://localhost:3000/login";
    private Settings settings= new Settings();
    private boolean premium= false;
    private JButton btnLogout;
    private JButton btnSettings;
    private JButton btnStart;
    
    public LoginWindow(JButton btnLogout, JButton btnSettings, JButton btnStart){
        this.btnLogout=btnLogout;
        this.btnSettings=btnSettings;
        this.btnStart=btnStart;
    }
    
    private void updateGUI(){
        btnLogout.setEnabled(true);
        btnSettings.setEnabled(true);
        btnStart.setEnabled(true);
    }
    
    WindowListener exitListener = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
                 null, "Do you want be a premium user?", 
                 "Premium Account", JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0){
                settings.SaveSetting("boolean", "ewsapremium", "true");
                premium= true;
            }
            else{
                settings.SaveSetting("boolean", "ewsapremium", "false");
                premium= false;
            }
            saveUser();
        }
    };
    
    private void saveUser(){
        try {
            //saviung user to server && set user type
            String premiumStr= "";
            if(premium) premiumStr="2";
            else premiumStr="1";
            String statusLogin= "http://localhost:3000/status?type=" + premiumStr;
            URL url= new URL(statusLogin);
            HttpURLConnection huc= (HttpURLConnection) url.openConnection();
            BufferedReader br= new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String ret= br.readLine();
            JSONObject data= new JSONObject(ret);
            if(data.getString("status").equals("logged")){
                String pass= data.getString("pass");
                settings.SaveSetting("string", "clientPass", pass);
                String name= data.getString("name");
                System.out.println("NAME: " + name);  //debug
                updateGUI();
            }
            else{
                //ERRORE
            }
            
                    } catch (MalformedURLException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void initAndShowGUI() {
        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(800 , 610);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addWindowListener(exitListener);
        //frame.setDefaultCloseOperation(test());

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private static void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() {
        Scene scene = new Scene(new Group());


        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(browser);

        webEngine.getLoadWorker().stateProperty()
            .addListener(new ChangeListener<Worker.State>() {
              @Override
              public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {

                if (newState == Worker.State.SUCCEEDED) {
                  //stage.setTitle(webEngine.getLocation());
                }

              }
            });
        
        //webEngine.load("http://www.google.com");
        webEngine.load(url);

        scene.setRoot(scrollPane);
        return(scene);
    }
    
}
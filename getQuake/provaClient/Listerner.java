

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class Listerner implements ActionListener{
	public static String START="Start";
	public final GUI g;

	private String baseUrl="http://localhost:3000/quake?limit=";

	public Listerner(GUI g){
		this.g=g;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()==START){
			try {
				String limit=g.getInput();

				URL url=new URL(baseUrl+limit);

				HttpURLConnection huc = (HttpURLConnection) url.openConnection();

				BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
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

					System.out.println("id: "+id+" Place: "+place+" time: "+time+" Magn: "+magn +" coord0: "+coord0 +" coord1: "+coord1);
				}
				br.close();
			} catch (IOException e1) {e1.printStackTrace();} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
	}
}

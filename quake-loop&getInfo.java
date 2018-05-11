

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public quake(String limit){

	private String baseUrl="http://localhost:3000/quake?limit=";

    try {
		URL url=new URL(baseUrl+limit);

		HttpURLConnection huc = (HttpURLConnection) url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		String ret= br.readLine();
		JSONObject j=new JSONObject(ret);

		JSONArray data=j.getJSONArray("elem");

		for (int i=0;i<Integer.parseInt(limit);i++) {
			JSONObject dataElem=data.optJSONObject(i);
			String place=dataElem.getString("place");
			String time=dataElem.getString("time");
			String magn=dataElem.getString("magn");
			System.out.println("Place: "+place+" time: "+time+" Magn: "+magn);  //per ora le stampa
		}
		br.close();
		} catch (IOException e1) {e1.printStackTrace();} catch (JSONException e1) {e1.printStackTrace();}
}

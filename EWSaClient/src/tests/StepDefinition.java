package tests;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JTable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ewsa.client.ClientGUI;
import ewsa.client.EarthQuakeCheck;

public class StepDefinition {
	
	ClientGUI clientGUI= new ClientGUI();
    JTable tableInfo= clientGUI.getTable();
    EarthQuakeCheck eqc= new EarthQuakeCheck(tableInfo); 
	
    @Given("^A user in EWSaeratos GUI$")
	public void a_user_in_EWSaeratos_GUI() throws Throwable {
		ProcessBuilder builder = new ProcessBuilder("ps","-aux");
		builder.redirectErrorStream(true);
		Process process = builder.start();
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String line = null;
		int count=0;
		while ((line = reader.readLine()) != null) {
			if(line.contains("EWSaClient")) {
				count++;
			}
		}
		if(count<=0) fail("EWS not running");
	}

	@When("^Press Start button$")
	public void press_Start_button() throws Throwable {
	    JButton startBtn= clientGUI.getStartBtn();
	    if(!startBtn.isEnabled() || startBtn==null) fail("Unable to click start");
	    startBtn.doClick();
	}

	@Then("^He is able to use our service$")
	public void he_is_able_to_use_our_service() throws Throwable {
	    JButton stopBtn= clientGUI.getStopBtn();
	    Thread.sleep(1500);
	    if(!stopBtn.isEnabled()) fail("Start not pressed");
	}
	
	
	@When("^Press Get Info button$")
	public void press_Get_Info_button() throws Throwable {
        Thread eqcThr= new Thread(eqc);
        eqcThr.start();
	}

	@Then("^Gets last earthquakes infos$")
	public void gets_last_earthquakes_infos() throws Throwable {
		Thread.sleep(2000);
		int serverRes= eqc.serverResNumber();
        int count=0;
        for(int row=0; row<tableInfo.getRowCount(); row++) {
        	if(tableInfo.getValueAt(row, 0)!=null) count++;
        }
        if(serverRes>count) fail("Get Info Error");
	}
}

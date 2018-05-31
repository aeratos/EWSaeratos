/*
 * AERATOS TEAM
 */
package ewsa.client;

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
import javax.swing.JFrame;

public class MapWindow {
    
    static String url="";
    
    public MapWindow(String co1, String co2){
        url= linkBuilder(co1, co2);
    }
    
    private String linkBuilder(String co1, String co2){
    	//https://www.google.com/maps/@37.0625,-95.677068,9z?force=lite
        String URL= "https://www.google.com/maps/@"+co1+","+co2+",9z?force=lite";
        return URL;
    }
    
    public void initAndShowGUI() {
        JFrame frame = new JFrame("Map");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(800 , 610);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

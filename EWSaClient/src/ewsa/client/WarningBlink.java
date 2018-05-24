/*
 * AERATOS TEAM
 */
package ewsa.client;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WarningBlink implements Runnable{
    
    private JFrame frame;
    private JLabel labelEarhquake;

    public WarningBlink(JFrame frame, JLabel labelEarhquake){
        this.frame= frame;
        this.labelEarhquake= labelEarhquake;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                frame.getContentPane().setBackground(Color.RED);
                labelEarhquake.setForeground(Color.YELLOW);
                Thread.sleep(800);
                frame.getContentPane().setBackground(Color.YELLOW);
                labelEarhquake.setForeground(Color.RED);
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(WarningBlink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

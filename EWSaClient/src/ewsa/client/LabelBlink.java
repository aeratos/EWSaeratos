/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewsa.client;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author nicholas
 */
public class LabelBlink implements Runnable{
    
    private JLabel labelWarning;
    private JLabel labelMagn;
    private JLabel labelLoc;
    
    public LabelBlink(JLabel labelWarning, JLabel labelMagn, JLabel labelLoc){
        this.labelWarning= labelWarning;
        this.labelMagn= labelMagn;
        this.labelLoc= labelLoc;
    }

    @Override
    public void run() {
        try {
            while(true){
                labelMagn.setForeground(Color.RED);
                labelLoc.setForeground(Color.RED);
                labelWarning.setVisible(true);
                Thread.sleep(800);
                labelMagn.setForeground(Color.BLUE);
                labelLoc.setForeground(Color.BLUE);
                labelWarning.setVisible(false);
                Thread.sleep(800);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(LabelBlink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

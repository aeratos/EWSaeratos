/*
 * AERATOS TEAM
 */
package ewsa.client;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class Warning extends javax.swing.JFrame {
    
    private String soundPath= "/home/nicholas/OneDrive/University/Laboratorio_Sicurezza_Informatica/EWSaeratos/Git_EWSa/My_Fork/EWSaeratos/EWSaClient/src/ewsa/client/EASaeratosSound.wav";
    File soundFile = new File(soundPath);
    private JLabel labelWarning;
    private JLabel labelMagn;
    private JLabel labelLoc;
    private Settings settings;
    
    private Clip clip;
    
    public Warning(JLabel labelWarning, JLabel labelMagn, JLabel labelLoc) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.labelWarning= labelWarning;
        this.labelMagn= labelMagn;
        this.labelLoc= labelLoc;
        this.settings= new Settings();
    }
    
    public void start(){
        startBlink();
        if(settings.getBoolValue("soundEff")){
            SoundEffect();
        }
    }
    
    private void startBlink(){
        WarningBlink wb= new WarningBlink(this, labelEarhquake);
        Thread wbThr= new Thread(wb);
        wbThr.start();
        this.setVisible(true);
        LabelBlink lb= new LabelBlink(labelWarning, labelMagn, labelLoc);
        Thread lbThr= new Thread(lb);
        lbThr.start();
    }
    
    private void SoundEffect() {
        try {
            maxVolume();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("EASaeratosSound.wav"));
            DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
            clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            if (clip.isRunning()) clip.stop();
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    
    private void maxVolume(){
        try {
            String cmd = "amixer -c 0 set Master playback 100% unmute";
            Process proc = Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(Warning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEarhquake = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelEarhquake.setFont(new java.awt.Font("Ubuntu", 1, 105)); // NOI18N
        labelEarhquake.setText("EARTHQUAKE WARNING");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelEarhquake)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(labelEarhquake)
                .addGap(252, 252, 252))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Warning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Warning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Warning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Warning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Warning(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelEarhquake;
    // End of variables declaration//GEN-END:variables
}

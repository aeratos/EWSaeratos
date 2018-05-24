/*
 * AERATOS TEAM
 */
package ewsa.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class SettingsGUI extends javax.swing.JDialog {

    
    private Settings settings= new Settings();
    private LocationFinder locFind;
    
    public SettingsGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        combosManager();
        locFind= new LocationFinder();
    }
    
    
    private void combosManager(){
        boolean premium= settings.getBoolValue("ewsapremium");
        if(premium){
            btnStandard.setSelected(false);
            btnPremium.setSelected(true);
            boxLimit.setEnabled(true);
            int usrLimit= settings.getIntValue("usrLimit");
            if(usrLimit<=0){
                usrLimit= 1;
                settings.SaveSetting("int", "usrLimit", Integer.toString(usrLimit));
            }
            labelListSet.setText("Set " + Integer.toString(usrLimit));
        }
        else{
            btnStandard.setSelected(true);
            btnPremium.setSelected(false);
            boxLimit.setEnabled(false);
            labelListSet.setText("");
        }
        int usrDist= settings.getIntValue("usrDist");
        if(usrDist<0){
            usrDist= 10;
            settings.SaveSetting("int", "usrDist", Integer.toString(usrDist));
        }
        labelDistSet.setText("Set " + Integer.toString(usrDist));
        int usrMagn= settings.getIntValue("usrMagn");
        if(usrMagn<0){
            usrMagn= 0;
            settings.SaveSetting("int", "usrMagn", Integer.toString(usrMagn));
        }
        labelMagnSet.setText("Set " + Integer.toString(usrMagn));
        String location= settings.getStingValue("usrLocName");
        if(location==null || location.length()<2){
            location= "worldwide";
            settings.SaveSetting("string", "usrLocation", location);
            settings.SaveSetting("string", "usrLocName", location);
        }
        labelLocationSet.setText("Location Set: " + location);
        
        if(settings.getBoolValue("soundEff")){
            btnOn.setSelected(true);
            btnOff.setSelected(false);
        }
        else{
            btnOn.setSelected(false);
            btnOff.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        boxLimit = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStandard = new javax.swing.JRadioButton();
        btnPremium = new javax.swing.JRadioButton();
        cityLabel1 = new javax.swing.JLabel();
        boxMagnitude = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        fieldLocation = new javax.swing.JTextField();
        btnSetLoc = new javax.swing.JButton();
        cityLabel2 = new javax.swing.JLabel();
        boxDistance = new javax.swing.JComboBox<>();
        labelDistSet = new javax.swing.JLabel();
        labelLocationSet = new javax.swing.JLabel();
        labelMagnSet = new javax.swing.JLabel();
        labelListSet = new javax.swing.JLabel();
        labelSound = new javax.swing.JLabel();
        btnOn = new javax.swing.JRadioButton();
        btnOff = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.darkGray);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/earth-icon-30x30.png"))); // NOI18N
        jLabel4.setText("Location");

        boxLimit.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        boxLimit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        boxLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxLimitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.darkGray);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/hourglass-icon-black-30x30.png"))); // NOI18N
        jLabel5.setText("List Limit");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.darkGray);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/question-mark-icon-30x30.png"))); // NOI18N
        jLabel2.setText("User Type");

        btnStandard.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnStandard.setText("Standard");
        btnStandard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStandardMouseClicked(evt);
            }
        });
        btnStandard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStandardActionPerformed(evt);
            }
        });

        btnPremium.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnPremium.setText("Premium");
        btnPremium.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPremiumMouseClicked(evt);
            }
        });
        btnPremium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPremiumActionPerformed(evt);
            }
        });

        cityLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cityLabel1.setForeground(java.awt.Color.darkGray);
        cityLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/earthquake-magnitude-30x30.png"))); // NOI18N
        cityLabel1.setText("Min Magnitude");

        boxMagnitude.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        boxMagnitude.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        boxMagnitude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMagnitudeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.darkGray);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/settings-blakc-icon-40x40.png"))); // NOI18N
        jLabel7.setText("Settings");

        fieldLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldLocationActionPerformed(evt);
            }
        });

        btnSetLoc.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnSetLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/save-black-icon-20x20.png"))); // NOI18N
        btnSetLoc.setText("Set Loc");
        btnSetLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetLocActionPerformed(evt);
            }
        });

        cityLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cityLabel2.setForeground(java.awt.Color.darkGray);
        cityLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/distance-black-icon-30x30.png"))); // NOI18N
        cityLabel2.setText("Distance  (Km)");

        boxDistance.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        boxDistance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "50", "100", "150", "200" }));
        boxDistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDistanceActionPerformed(evt);
            }
        });

        labelDistSet.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelDistSet.setForeground(java.awt.Color.darkGray);
        labelDistSet.setText("Set");

        labelLocationSet.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelLocationSet.setForeground(java.awt.Color.darkGray);
        labelLocationSet.setText("Set");

        labelMagnSet.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelMagnSet.setForeground(java.awt.Color.darkGray);
        labelMagnSet.setText("Set");

        labelListSet.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelListSet.setForeground(java.awt.Color.darkGray);
        labelListSet.setText("Set");

        labelSound.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelSound.setForeground(java.awt.Color.darkGray);
        labelSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/volume-black-icon-30x30.png"))); // NOI18N
        labelSound.setText("Sound");

        btnOn.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnOn.setText("On");
        btnOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOnMouseClicked(evt);
            }
        });
        btnOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnActionPerformed(evt);
            }
        });

        btnOff.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnOff.setText("Off");
        btnOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOffMouseClicked(evt);
            }
        });
        btnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOffActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/credit-card-icon-black-40x40.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53))
                            .addComponent(cityLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cityLabel2)
                        .addGap(0, 412, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSound)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOn)
                                .addGap(28, 28, 28)
                                .addComponent(btnOff)))
                        .addGap(0, 436, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLocationSet)
                                    .addComponent(fieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(boxLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(boxMagnitude, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelDistSet)
                                            .addComponent(labelMagnSet)
                                            .addComponent(labelListSet)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnStandard)
                                        .addGap(28, 28, 28)
                                        .addComponent(btnPremium)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(btnSetLoc)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelLocationSet))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetLoc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cityLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cityLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDistSet))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxMagnitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMagnSet))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelListSet))))
                .addGap(19, 19, 19)
                .addComponent(labelSound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOn)
                    .addComponent(btnOff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStandard)
                            .addComponent(btnPremium)))
                    .addComponent(jLabel1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boxMagnitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMagnitudeActionPerformed
        String magn= String.valueOf(boxMagnitude.getSelectedItem());
        settings.SaveSetting("int", "usrMagn", magn);
        combosManager();
    }//GEN-LAST:event_boxMagnitudeActionPerformed

    private void btnStandardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStandardActionPerformed
        settings.SaveSetting("boolean", "ewsapremium", "false");
        combosManager();
    }//GEN-LAST:event_btnStandardActionPerformed

    private void btnPremiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPremiumActionPerformed
        settings.SaveSetting("boolean", "ewsapremium", "true");
        combosManager();
    }//GEN-LAST:event_btnPremiumActionPerformed

    private void btnPremiumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPremiumMouseClicked
        
    }//GEN-LAST:event_btnPremiumMouseClicked

    private void btnStandardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStandardMouseClicked
        
    }//GEN-LAST:event_btnStandardMouseClicked

    private void fieldLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldLocationActionPerformed
        
    }//GEN-LAST:event_fieldLocationActionPerformed

    private void btnSetLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetLocActionPerformed
        String location= fieldLocation.getText().toLowerCase();
        settings.SaveSetting("string", "usrLocName", location);
        if(!location.equals("worldwide")) location= locFind.getCoord(location);
        if(location.equals("error")){
            JOptionPane.showMessageDialog(this, "Cannot set location, try again", "Error", JOptionPane.ERROR_MESSAGE);
            location="worldwide";
            settings.SaveSetting("string", "usrLocation", location);
            settings.SaveSetting("string", "usrLocName", location);
        }
        else{
            settings.SaveSetting("string", "usrLocation", location);
            JOptionPane.showMessageDialog(null, "Location Set");
        }
        fieldLocation.setText("");
        combosManager();
    }//GEN-LAST:event_btnSetLocActionPerformed

    private void boxDistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDistanceActionPerformed
        String dist= String.valueOf(boxDistance.getSelectedItem());
        settings.SaveSetting("int", "usrDist", dist);
        combosManager();
    }//GEN-LAST:event_boxDistanceActionPerformed

    private void boxLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxLimitActionPerformed
        String limit= String.valueOf(boxLimit.getSelectedItem());
        settings.SaveSetting("int", "usrLimit", limit);
        combosManager();
    }//GEN-LAST:event_boxLimitActionPerformed

    private void btnOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOnMouseClicked

    private void btnOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnActionPerformed
        settings.SaveSetting("boolean", "soundEff", "true");
        combosManager();
    }//GEN-LAST:event_btnOnActionPerformed

    private void btnOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOffMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOffMouseClicked

    private void btnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOffActionPerformed
        settings.SaveSetting("boolean", "soundEff", "false");
        combosManager();
    }//GEN-LAST:event_btnOffActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SettingsGUI dialog = new SettingsGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDistance;
    private javax.swing.JComboBox<String> boxLimit;
    private javax.swing.JComboBox<String> boxMagnitude;
    private javax.swing.JRadioButton btnOff;
    private javax.swing.JRadioButton btnOn;
    private javax.swing.JRadioButton btnPremium;
    private javax.swing.JButton btnSetLoc;
    private javax.swing.JRadioButton btnStandard;
    private javax.swing.JLabel cityLabel1;
    private javax.swing.JLabel cityLabel2;
    private javax.swing.JTextField fieldLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelDistSet;
    private javax.swing.JLabel labelListSet;
    private javax.swing.JLabel labelLocationSet;
    private javax.swing.JLabel labelMagnSet;
    private javax.swing.JLabel labelSound;
    // End of variables declaration//GEN-END:variables
}

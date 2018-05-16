/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewsa.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author nicholas
 */
public class SettingsGUI extends javax.swing.JDialog {

    /**
     * Creates new form SettingsGUI
     */
    
    private Settings settings= new Settings();
    
    public SettingsGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        combosManager();
    }
    
    
    private void combosManager(){
        boolean premium= settings.getBoolValue("ewsapremium");
        if(premium){
            btnStandard.setSelected(false);
            btnPremium.setSelected(true);
            boxLimit.setEnabled(true);
        }
        else{
            btnStandard.setSelected(true);
            btnPremium.setSelected(false);
            boxLimit.setEnabled(false);
        }
        int usrDist= settings.getIntValue("usrDist");
        if(usrDist<=0){
            usrDist= 10;
            settings.SaveSetting("int", "usrDist", Integer.toString(usrDist));
        }
        labelDistSet.setText("Set " + Integer.toString(usrDist));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.darkGray);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/earth-icon-30x30.png"))); // NOI18N
        jLabel4.setText("Location");

        boxLimit.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        boxLimit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

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
        boxMagnitude.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
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
        cityLabel2.setText("Distance");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStandard)
                        .addGap(28, 28, 28)
                        .addComponent(btnPremium))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(94, 94, 94)
                        .addComponent(fieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cityLabel2)
                                .addGap(93, 93, 93)
                                .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boxLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cityLabel1)
                                    .addGap(37, 37, 37)
                                    .addComponent(boxMagnitude, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addComponent(labelDistSet)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSetLoc)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel2)
                    .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDistSet))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel1)
                    .addComponent(boxMagnitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(boxLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStandard)
                    .addComponent(btnPremium))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boxMagnitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMagnitudeActionPerformed
        // TODO add your handling code here:
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
        String city= fieldLocation.getText().toLowerCase();
        settings.SaveSetting("string", "usrLocation", city);
        combosManager();
        JOptionPane.showMessageDialog(null, "Location Set");
    }//GEN-LAST:event_btnSetLocActionPerformed

    private void boxDistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDistanceActionPerformed
        String dist= String.valueOf(boxDistance.getSelectedItem());
        settings.SaveSetting("int", "usrDist", dist);
        combosManager();
    }//GEN-LAST:event_boxDistanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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

        /* Create and display the dialog */
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
    private javax.swing.JRadioButton btnPremium;
    private javax.swing.JButton btnSetLoc;
    private javax.swing.JRadioButton btnStandard;
    private javax.swing.JLabel cityLabel1;
    private javax.swing.JLabel cityLabel2;
    private javax.swing.JTextField fieldLocation;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelDistSet;
    // End of variables declaration//GEN-END:variables
}
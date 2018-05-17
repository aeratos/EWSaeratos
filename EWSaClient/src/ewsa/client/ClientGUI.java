/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewsa.client;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author nicholas
 */
public class ClientGUI extends javax.swing.JFrame {
    
    private Settings settings= new Settings();
    
    public ClientGUI() {
        initComponents();
        
        startApp();
        refreshGUI();
    }
    
    
    private boolean logged(){
        if(settings.getStingValue("clientPass")==null || settings.getStingValue("clientPass").length()<2){
            settings.SaveSetting("string", "usrName", "");
            return false;
        }
        return true;
    }
    
    private void startApp(){
        labelMagn.setText("   ");
        labelTime.setText("       ");
        labelDate.setText("          ");
        labelCoo.setText("                    ");
        labelDist.setText("     ");
        labelLoc.setText("                                   ");
        labelWarning.setVisible(false);
        settings.SaveSetting("string", "lastEqCoo0", "");
        settings.SaveSetting("string", "lastEqCoo1", "");
    }
    
    private void refreshGUI(){
        if(!logged()){
            btnLogin.setEnabled(true);
            btnLogout.setEnabled(false);
            btnSettings.setEnabled(false);
            btnStart.setEnabled(false);
            btnStop.setEnabled(false);
            btnGetInfo.setEnabled(false);
            labelUsrType.setText("        ");
            labelName.setText("Please Login");
        }
        else{
            btnStop.setEnabled(false);
            btnLogin.setEnabled(false);
            labelName.setText("Hello: " + settings.getStingValue("usrName"));
            if(settings.getBoolValue("ewsapremium")){
                btnGetInfo.setEnabled(true);
                labelUsrType.setForeground(Color.BLUE);
                labelUsrType.setText("PREMIUM ");
            }
            else{
                btnGetInfo.setEnabled(false);
                labelUsrType.setForeground(Color.GREEN);
                labelUsrType.setText("STANDARD");
            }
        }
    }
    
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        labelUsrType = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        labelName = new javax.swing.JLabel();
        btnSettings = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelMagn = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelCoo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInfo = new javax.swing.JTable();
        btnGetInfo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnSoundTest = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        labelDist = new javax.swing.JLabel();
        labelMaps = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        labelLoc = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        labelWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setResizable(false);

        btnStart.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btnStart.setForeground(java.awt.Color.green);
        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/on-btn-black-green-40x40.png"))); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btnStop.setForeground(java.awt.Color.red);
        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/off-btn-black-red-40x40.png"))); // NOI18N
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.darkGray);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/question-mark-icon-30x30.png"))); // NOI18N
        jLabel2.setText("User Type");

        labelUsrType.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelUsrType.setForeground(new java.awt.Color(33, 207, 33));
        labelUsrType.setText("STANDARD");

        btnLogin.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/google-black-icon-30x30.png"))); // NOI18N
        btnLogin.setText("Login Page");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.darkGray);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/user-icon-black-30x30.png"))); // NOI18N
        jLabel6.setText("User Login");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelName.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 90, 78));
        labelName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/aeratos-logo-transparent-40x40.png"))); // NOI18N
        labelName.setText("Hello ABDULO");

        btnSettings.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/settings-blakc-icon-30x30.png"))); // NOI18N
        btnSettings.setText("Settings");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(79, 79, 248));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/earthquake-icon-30x30.png"))); // NOI18N
        jLabel8.setText("Last Earthquake info");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.darkGray);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/earthquake-magnitude-30x30.png"))); // NOI18N
        jLabel9.setText("Magnitude");

        labelMagn.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelMagn.setForeground(new java.awt.Color(104, 110, 222));
        labelMagn.setText("7.5");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.darkGray);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/calendar-icon-black-30x30.png"))); // NOI18N
        jLabel11.setText("Date");

        labelDate.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelDate.setForeground(new java.awt.Color(104, 110, 222));
        labelDate.setText("10-04-2018");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.darkGray);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/clock-icon-black-30x30.png"))); // NOI18N
        jLabel14.setText("Time");

        labelTime.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelTime.setForeground(new java.awt.Color(104, 110, 222));
        labelTime.setText("3:54 AM");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.darkGray);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/gps-location-icon-30x30.png"))); // NOI18N
        jLabel16.setText("Coordinates:");

        labelCoo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelCoo.setForeground(new java.awt.Color(104, 110, 222));
        labelCoo.setText("41.909507, 12.512788");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel18.setForeground(java.awt.Color.darkGray);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/earth-icon-30x30.png"))); // NOI18N
        jLabel18.setText("Last Earthquakes Info");

        tableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Time", "Location", "Magnitude"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableInfo);
        if (tableInfo.getColumnModel().getColumnCount() > 0) {
            tableInfo.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        btnGetInfo.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnGetInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/info-icon-20x20.png"))); // NOI18N
        btnGetInfo.setText("Get Info");
        btnGetInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetInfoActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSoundTest.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btnSoundTest.setForeground(java.awt.Color.red);
        btnSoundTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/brake-light-red-50x35.png"))); // NOI18N
        btnSoundTest.setText("Sound Test");
        btnSoundTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundTestActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel19.setForeground(java.awt.Color.darkGray);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/distance-black-icon-30x30.png"))); // NOI18N
        jLabel19.setText("Distance");

        labelDist.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelDist.setForeground(new java.awt.Color(104, 110, 222));
        labelDist.setText("100 Km");

        labelMaps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/googlemaps-black-icon-200x200.png"))); // NOI18N
        labelMaps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMapsMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel21.setForeground(java.awt.Color.darkGray);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/googlemaps-black-icon-30x30.png"))); // NOI18N
        jLabel21.setText("Show on Map");

        labelLoc.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelLoc.setForeground(new java.awt.Color(104, 110, 222));
        labelLoc.setText("3km SSW of Leilani Estates, Hawaii");
        labelLoc.setMaximumSize(new java.awt.Dimension(20, 21));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.darkGray);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/location-icon-30x30.png"))); // NOI18N
        jLabel10.setText("Location");

        btnLogout.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/logout-black-icon-30x30.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        labelWarning.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelWarning.setForeground(java.awt.Color.red);
        labelWarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ewsa/client/Icons/warning-icon-30x27.png"))); // NOI18N
        labelWarning.setText("WARNING");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGetInfo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel21)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelMaps)
                                .addGap(102, 102, 102))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelUsrType)
                                            .addComponent(btnLogin)))
                                    .addComponent(labelName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSettings)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogout)))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelDate))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(71, 71, 71)
                                                .addComponent(labelTime))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMagn))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCoo)
                                            .addComponent(jLabel16)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(18, 18, 18)
                                                .addComponent(labelDist))
                                            .addComponent(labelWarning)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 42, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSoundTest, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnStart)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelName)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(labelUsrType))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLogin)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSettings)
                                    .addComponent(btnLogout))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(labelWarning))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(labelMagn)
                                    .addComponent(jLabel16))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(labelTime)
                                    .addComponent(labelCoo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(labelDate)
                                    .addComponent(jLabel19)
                                    .addComponent(labelDist))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(labelLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(btnGetInfo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMaps))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop)
                    .addComponent(btnSoundTest))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LoginWindow lw= new LoginWindow(btnLogout, btnSettings, btnStart, labelName);
        lw.initAndShowGUI();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        SettingsGUI setGUI= new SettingsGUI(null, true);
        setGUI.setVisible(true);
        refreshGUI();
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        EarthQuakeCheck eqc= new EarthQuakeCheck(labelMagn, labelLoc, labelDate, labelTime, labelCoo, labelDist, btnStart, btnStop, btnLogout, btnSettings, btnGetInfo, labelWarning);
        Thread eqcThr= new Thread(eqc);
        eqcThr.start();
    }//GEN-LAST:event_btnStartActionPerformed

    private void labelMapsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMapsMouseClicked
        String coord0= settings.getStingValue("lastEqCoo0");
        String coord1= settings.getStingValue("lastEqCoo1");
        System.out.println("COORD0: " + coord0);
        System.out.println("COORD1: " + coord1);
        if(coord0==null || coord1==null || coord0.length()<2 || coord1.length()<2){
            JOptionPane.showMessageDialog(this, "No Earthquake to show", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            MapWindow mw= new MapWindow(coord0, coord1);
            mw.initAndShowGUI();
        }
    }//GEN-LAST:event_labelMapsMouseClicked

    private void btnGetInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetInfoActionPerformed
        EarthQuakeCheck eqc= new EarthQuakeCheck("3", tableInfo);   
        Thread eqcThr= new Thread(eqc);
        eqcThr.start();
    }//GEN-LAST:event_btnGetInfoActionPerformed

    private void btnSoundTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundTestActionPerformed
        Warning warn= new Warning(labelWarning, labelMagn, labelLoc);
        warn.setVisible(true);
    }//GEN-LAST:event_btnSoundTestActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        settings.SaveSetting("string", "clientPass", "");
        refreshGUI();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        settings.SaveSetting("boolean", "stopServer", "true");
    }//GEN-LAST:event_btnStopActionPerformed

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetInfo;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnSoundTest;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelCoo;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDist;
    private javax.swing.JLabel labelLoc;
    private javax.swing.JLabel labelMagn;
    private javax.swing.JLabel labelMaps;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelUsrType;
    private javax.swing.JLabel labelWarning;
    private javax.swing.JTable tableInfo;
    // End of variables declaration//GEN-END:variables
}

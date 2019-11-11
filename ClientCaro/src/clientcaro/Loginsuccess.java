package clientcaro;

import java.awt.event.ItemEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class Loginsuccess extends javax.swing.JFrame {

    DataInputStream inFromServer;
    DataOutputStream outToServer;
    String _name;
    address add;

    public Loginsuccess(DataInputStream inFromServer, DataOutputStream outToServer, String _name) {
        setVisible(true);
        setLocation(400, 200);
        initComponents();
        this.inFromServer = inFromServer;
        this.outToServer = outToServer;
        this._name = _name;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        createServer = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comServer = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton_loadServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setText("Đăng nhập thành công!!!");

        createServer.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        createServer.setText("Tạo server");
        createServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createServerActionPerformed(evt);
            }
        });

        btExit.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Click để tạo server!!!");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Lựa chọn đối thủ!!!");

        comServer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comServerItemStateChanged(evt);
            }
        });
        comServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comServerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Server:");

        jButton_loadServer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_loadServer.setText("Load List server");
        jButton_loadServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comServer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(createServer))
                                .addGap(154, 154, 154)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(9, 9, 9))
                                    .addComponent(jButton_loadServer, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btExit)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comServer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createServer)
                            .addComponent(jButton_loadServer))))
                .addGap(18, 18, 18)
                .addComponent(btExit)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * TẠO PHÒNG CHƠI, GỬI DỮ LIỆU PHÒNG TẠO VỀ SERVER
     *
     * @param evt
     */
    private void createServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createServerActionPerformed
        //Thông tin gồm: <tên case>-<tên server>-<IP server>
        String _taoServer = "3-" + _name + "-" + IpAddress.getIpAddress();
        //CaroServer CaroServer = new CaroServer(1000, 1001); 
        try {
            //Gửi thông tin phòng lên Server
            outToServer.writeBytes(_taoServer + "\n");
            
            //Đọc dữ liệu Server gửi về 
            String _string = inFromServer.readLine();
            System.out.println("[LOGIN-SUCCESS]: Dia chi kem port Server gui ve co dang: " + _string);
            String[] addr = _string.split("-");
            int _port1 = Integer.parseInt(addr[1]);
            int _port2 = Integer.parseInt(addr[2]);

            System.out.println("[LOGIN-SUCCESS]: 2 port server gui ve la: " + _port1 + " | " + _port2);
            CaroServer caroServer = new CaroServer(_port1, _port2, _name);
            setVisible(false);
            //System.exit(1);
        } catch (IOException ex) {
            System.err.println("[LOGIN-SUCCESS]: Loi khi nhan port tu Server");
            Logger.getLogger(Loginsuccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createServerActionPerformed

    private void comServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comServerActionPerformed

    }//GEN-LAST:event_comServerActionPerformed

    private void jButton_loadServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadServerActionPerformed
        String _choigame = "4-aaa";
        try {
            //gui len server
            outToServer.writeBytes(_choigame + "\n");
            //Đọc dữ liệu Server gửi về 
            String _strPort1 = inFromServer.readLine();
            String[] _cutPort1 = _strPort1.split("-");
            for (int i = 0; i < _cutPort1.length; i++) {
                add.port1.add(Integer.parseInt(_cutPort1[i]));

            }
            String _strPort2 = inFromServer.readLine();
            String[] _cutPort2 = _strPort2.split("-");
            for (int i = 0; i < _cutPort2.length; i++) {
                add.port2.add(Integer.parseInt(_cutPort2[i]));

            }
            String _strIp = inFromServer.readLine();
            String[] _cutIp = _strIp.split("-");
            for (int i = 0; i < _cutIp.length; i++) {
                add.ip.add(_cutIp[i]);

            }
            String _strName = inFromServer.readLine();
            String[] _cutName = _strName.split("-");
            for (int i = 0; i < _cutName.length; i++) {
                add.name.add(_cutName[i]);

            }
        } catch (IOException ex) {
            Logger.getLogger(Loginsuccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Chọn đối thủ:");
        for (int i = 0; i < add.name.size(); i++) {
            model.addElement(add.name.get(i));
        }
        comServer.setModel(model);
    }//GEN-LAST:event_jButton_loadServerActionPerformed

    private void comServerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comServerItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //JOptionPane.showMessageDialog(null, evt.getItem());
            int i = 0;
            for (i = 0; i < add.name.size(); i++) {
                if (evt.getItem() == add.name.get(i)) {
                    break;
                }

            }
            System.err.println("================IP: " + IpAddress.getIpAddress());
            CaroClient caroclient = new CaroClient("IP cua chu room", add.port1.get(i), add.port2.get(i), _name);
            //remove server sau khi da duoc chon
            String _choigame = "5-" + evt.getItem();
            try {
                //gui len server
                outToServer.writeBytes(_choigame + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Loginsuccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setVisible(false);
    }//GEN-LAST:event_comServerItemStateChanged

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        System.exit(1);

    }//GEN-LAST:event_btExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JComboBox comServer;
    private javax.swing.JButton createServer;
    private javax.swing.JButton jButton_loadServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

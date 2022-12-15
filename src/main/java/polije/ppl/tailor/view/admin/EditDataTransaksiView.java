/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package polije.ppl.tailor.view.admin;

import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author Hafidz
 */
public class EditDataTransaksiView extends javax.swing.JFrame {

    /**
     * Creates new form EditDataTransaksiView
     */
    public EditDataTransaksiView() {
        initComponents();
        
        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namapakaian = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        catatan = new javax.swing.JTextArea();
        btn_simpan2 = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1089, 740));
        getContentPane().setLayout(null);

        namapakaian.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        namapakaian.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        namapakaian.setBorder(null);
        namapakaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namapakaianActionPerformed(evt);
            }
        });
        getContentPane().add(namapakaian);
        namapakaian.setBounds(410, 307, 90, 30);

        jumlah.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jumlah.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jumlah.setBorder(null);
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(jumlah);
        jumlah.setBounds(630, 307, 90, 30);

        harga.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        harga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        harga.setBorder(null);
        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        getContentPane().add(harga);
        harga.setBounds(735, 307, 90, 30);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(837, 307, 30, 30);

        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        getContentPane().add(btn_hapus);
        btn_hapus.setBounds(877, 307, 30, 30);

        jTable1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(400, 340, 510, 80);

        catatan.setColumns(20);
        catatan.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        catatan.setRows(5);
        jScrollPane2.setViewportView(catatan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 505, 510, 120);
        getContentPane().add(btn_simpan2);
        btn_simpan2.setBounds(837, 655, 90, 30);

        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btn_kembali);
        btn_kembali.setBounds(395, 87, 40, 30);

        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setPreferredSize(new java.awt.Dimension(1089, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Edit Data Transaksi.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1089, 708);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namapakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namapakaianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namapakaianActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        new DataTransaksiView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliMouseClicked

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
            java.util.logging.Logger.getLogger(EditDataTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDataTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDataTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDataTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditDataTransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_kembali;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JLabel btn_simpan2;
    private javax.swing.JTextArea catatan;
    private javax.swing.JTextField harga;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField namapakaian;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}

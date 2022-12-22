/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package polije.ppl.tailor.view.tailor;

import polije.ppl.tailor.view.LandingPageView;

/**
 *
 * @author Hafidz
 */
public class EditDataUkuran extends javax.swing.JFrame {

    /**
     * Creates new form EditDataUkuran
     */
    public EditDataUkuran() {
        initComponents();
        
        plg.setOpaque(false);
        plg.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        tipepakaian.setOpaque(false);
        tipepakaian.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        nama.setOpaque(false);
        nama.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        nilai.setOpaque(false);
        nilai.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipepakaian = new javax.swing.JTextField();
        plg = new javax.swing.JTextField();
        nilai = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        simpan = new javax.swing.JLabel();
        hapus = new javax.swing.JLabel();
        simpandata = new javax.swing.JLabel();
        reset = new javax.swing.JLabel();
        bbutton = new javax.swing.JLabel();
        beranda = new javax.swing.JLabel();
        transaksi = new javax.swing.JLabel();
        ukuran = new javax.swing.JLabel();
        keluar = new javax.swing.JLabel();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1089, 740));
        getContentPane().setLayout(null);

        tipepakaian.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tipepakaian.setBorder(null);
        getContentPane().add(tipepakaian);
        tipepakaian.setBounds(395, 236, 510, 30);

        plg.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        plg.setBorder(null);
        getContentPane().add(plg);
        plg.setBounds(395, 176, 510, 30);

        nilai.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nilai.setBorder(null);
        getContentPane().add(nilai);
        nilai.setBounds(612, 327, 200, 30);

        nama.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nama.setBorder(null);
        getContentPane().add(nama);
        nama.setBounds(394, 327, 200, 30);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(384, 370, 530, 240);

        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(822, 328, 30, 30);

        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(862, 328, 30, 30);
        getContentPane().add(simpandata);
        simpandata.setBounds(821, 645, 90, 30);

        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(393, 644, 80, 30);

        bbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bbuttonMouseClicked(evt);
            }
        });
        getContentPane().add(bbutton);
        bbutton.setBounds(379, 102, 40, 30);

        beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                berandaMouseClicked(evt);
            }
        });
        getContentPane().add(beranda);
        beranda.setBounds(38, 104, 200, 50);

        transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiMouseClicked(evt);
            }
        });
        getContentPane().add(transaksi);
        transaksi.setBounds(38, 174, 200, 50);

        ukuran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ukuranMouseClicked(evt);
            }
        });
        getContentPane().add(ukuran);
        ukuran.setBounds(38, 245, 200, 50);

        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
        });
        getContentPane().add(keluar);
        keluar.setBounds(38, 315, 200, 50);

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Edit Ukuran Penjahit.png"))); // NOI18N
        getContentPane().add(BackGround);
        BackGround.setBounds(0, 0, 1089, 708);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanMouseClicked

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_resetMouseClicked

    private void bbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuttonMouseClicked
        new UkuranView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bbuttonMouseClicked

    private void berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_berandaMouseClicked
        new DashBoardPenjahitView().setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_berandaMouseClicked

    private void transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiMouseClicked
        new TransaksiPenjahitView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_transaksiMouseClicked

    private void ukuranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ukuranMouseClicked
        new UkuranView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ukuranMouseClicked

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        new LandingPageView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_keluarMouseClicked

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
            java.util.logging.Logger.getLogger(EditDataUkuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDataUkuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDataUkuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDataUkuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditDataUkuran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JLabel bbutton;
    private javax.swing.JLabel beranda;
    private javax.swing.JLabel hapus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel keluar;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nilai;
    private javax.swing.JTextField plg;
    private javax.swing.JLabel reset;
    private javax.swing.JLabel simpan;
    private javax.swing.JLabel simpandata;
    private javax.swing.JTextField tipepakaian;
    private javax.swing.JLabel transaksi;
    private javax.swing.JLabel ukuran;
    // End of variables declaration//GEN-END:variables
}

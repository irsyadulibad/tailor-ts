/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.admin;

/**
 *
 * @author muhai
 */
public class TambahDataPaketView extends javax.swing.JFrame {

    /**
     * Creates new form TambahDataPaketView
     */
    public TambahDataPaketView() {
        initComponents();
        
        txt_harga.setOpaque(false);
        txt_harga.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        txt_tipepakaian.setOpaque(false);
        txt_tipepakaian.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_tipepakaian = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        btn_hapus = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JLabel();
        btn_beranda = new javax.swing.JLabel();
        btn_paket = new javax.swing.JLabel();
        btn_pelanggan = new javax.swing.JLabel();
        btn_transaksi = new javax.swing.JLabel();
        btn_penjahit = new javax.swing.JLabel();
        btn_laporan = new javax.swing.JLabel();
        btn_panduan = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JLabel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 708));
        setPreferredSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        txt_tipepakaian.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txt_tipepakaian.setBorder(null);
        getContentPane().add(txt_tipepakaian);
        txt_tipepakaian.setBounds(410, 280, 490, 40);

        txt_harga.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txt_harga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_harga.setBorder(null);
        getContentPane().add(txt_harga);
        txt_harga.setBounds(410, 220, 490, 40);

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/TombolHapus.png"))); // NOI18N
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        getContentPane().add(btn_hapus);
        btn_hapus.setBounds(396, 335, 90, 40);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(827, 339, 90, 30);

        btn_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_berandaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_beranda);
        btn_beranda.setBounds(37, 103, 200, 50);

        btn_paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_paketMouseClicked(evt);
            }
        });
        getContentPane().add(btn_paket);
        btn_paket.setBounds(38, 174, 200, 50);

        btn_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(btn_pelanggan);
        btn_pelanggan.setBounds(37, 243, 200, 50);

        btn_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btn_transaksi);
        btn_transaksi.setBounds(37, 315, 200, 50);

        btn_penjahit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_penjahitMouseClicked(evt);
            }
        });
        getContentPane().add(btn_penjahit);
        btn_penjahit.setBounds(37, 385, 200, 50);

        btn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_laporan);
        btn_laporan.setBounds(37, 455, 200, 50);

        btn_panduan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_panduanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_panduan);
        btn_panduan.setBounds(37, 527, 200, 50);
        getContentPane().add(btn_keluar);
        btn_keluar.setBounds(37, 595, 200, 50);

        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btn_kembali);
        btn_kembali.setBounds(385, 153, 40, 40);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/LoadingPage.png"))); // NOI18N
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
        });
        getContentPane().add(view);
        view.setBounds(0, 0, 1110, 708);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_berandaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_berandaMouseClicked

    private void btn_paketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_paketMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_paketMouseClicked

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewMouseClicked

    private void btn_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanMouseClicked

    private void btn_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pelangganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pelangganMouseClicked

    private void btn_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transaksiMouseClicked

    private void btn_penjahitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_penjahitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_penjahitMouseClicked

    private void btn_panduanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_panduanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_panduanMouseClicked

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(TambahDataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahDataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahDataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahDataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahDataPaketView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_beranda;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_keluar;
    private javax.swing.JLabel btn_kembali;
    private javax.swing.JLabel btn_laporan;
    private javax.swing.JLabel btn_paket;
    private javax.swing.JLabel btn_panduan;
    private javax.swing.JLabel btn_pelanggan;
    private javax.swing.JLabel btn_penjahit;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JLabel btn_transaksi;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_tipepakaian;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

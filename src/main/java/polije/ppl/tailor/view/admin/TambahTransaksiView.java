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
public class TambahTransaksiView extends javax.swing.JFrame {

    /**
     * Creates new form TambahTransaksiView
     */
    public TambahTransaksiView() {
        initComponents();
        txt_tanggal.setOpaque(false);
        txt_tanggal.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        txt_pelanggan.setOpaque(false);
        txt_pelanggan.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        penjahit.setOpaque(false);
        penjahit.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        namapakaian.setOpaque(false);
        namapakaian.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        jumlah.setOpaque(false);
        jumlah.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        harga.setOpaque(false);
        harga.setBackground(new java.awt.Color(255, 255, 255, 0));
         
        totalharga.setOpaque(false);
        totalharga.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        tipe.setOpaque(false);
        tipe.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportBorder(null);
        
        catatan.setOpaque(false);
        catatan.setBackground(new java.awt.Color(255, 255, 255, 0));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_tanggal = new javax.swing.JTextField();
        txt_pelanggan = new javax.swing.JTextField();
        penjahit = new javax.swing.JTextField();
        totalharga = new javax.swing.JTextField();
        namapakaian = new javax.swing.JTextField();
        tipe = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        btn_kembali = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JLabel();
        btn_simpan2 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        btn_beranda = new javax.swing.JLabel();
        btn_pakey = new javax.swing.JLabel();
        btn_pelanggan = new javax.swing.JLabel();
        btn_transaksi = new javax.swing.JLabel();
        btn_penjahit = new javax.swing.JLabel();
        btn_laporan = new javax.swing.JLabel();
        btn_panduan = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        catatan = new javax.swing.JTextArea();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1088, 720));
        getContentPane().setLayout(null);

        txt_tanggal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txt_tanggal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_tanggal.setBorder(null);
        txt_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tanggal);
        txt_tanggal.setBounds(680, 220, 230, 30);

        txt_pelanggan.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txt_pelanggan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pelanggan.setBorder(null);
        txt_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pelanggan);
        txt_pelanggan.setBounds(420, 152, 490, 40);

        penjahit.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        penjahit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        penjahit.setBorder(null);
        penjahit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penjahitActionPerformed(evt);
            }
        });
        getContentPane().add(penjahit);
        penjahit.setBounds(420, 220, 230, 30);

        totalharga.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        totalharga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        totalharga.setBorder(null);
        totalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalhargaActionPerformed(evt);
            }
        });
        getContentPane().add(totalharga);
        totalharga.setBounds(730, 448, 180, 30);

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

        tipe.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tipe.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tipe.setBorder(null);
        tipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipeActionPerformed(evt);
            }
        });
        getContentPane().add(tipe);
        tipe.setBounds(520, 307, 90, 30);

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

        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btn_kembali);
        btn_kembali.setBounds(390, 85, 50, 40);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(830, 300, 40, 40);
        getContentPane().add(btn_simpan2);
        btn_simpan2.setBounds(835, 650, 90, 40);

        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        getContentPane().add(btn_hapus);
        btn_hapus.setBounds(873, 300, 40, 40);

        btn_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_berandaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_beranda);
        btn_beranda.setBounds(37, 103, 200, 50);

        btn_pakey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pakeyMouseClicked(evt);
            }
        });
        getContentPane().add(btn_pakey);
        btn_pakey.setBounds(37, 175, 200, 50);

        btn_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(btn_pelanggan);
        btn_pelanggan.setBounds(37, 245, 200, 50);

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
        btn_penjahit.setBounds(37, 386, 200, 50);

        btn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_laporan);
        btn_laporan.setBounds(37, 457, 200, 50);

        btn_panduan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_panduanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_panduan);
        btn_panduan.setBounds(37, 527, 200, 50);

        btn_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_keluarMouseClicked(evt);
            }
        });
        getContentPane().add(btn_keluar);
        btn_keluar.setBounds(40, 597, 200, 50);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(380, 340, 570, 80);

        catatan.setColumns(20);
        catatan.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        catatan.setRows(5);
        jScrollPane2.setViewportView(catatan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 505, 510, 120);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Tambah Transaksi.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 1090, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalActionPerformed

    private void txt_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pelangganActionPerformed

    private void penjahitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penjahitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penjahitActionPerformed

    private void totalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalhargaActionPerformed

    private void namapakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namapakaianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namapakaianActionPerformed

    private void tipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipeActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembaliMouseClicked

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_berandaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_berandaMouseClicked

    private void btn_pakeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pakeyMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pakeyMouseClicked

    private void btn_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pelangganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pelangganMouseClicked

    private void btn_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transaksiMouseClicked

    private void btn_penjahitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_penjahitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_penjahitMouseClicked

    private void btn_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanMouseClicked

    private void btn_panduanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_panduanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_panduanMouseClicked

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_keluarMouseClicked

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
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahTransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_beranda;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_keluar;
    private javax.swing.JLabel btn_kembali;
    private javax.swing.JLabel btn_laporan;
    private javax.swing.JLabel btn_pakey;
    private javax.swing.JLabel btn_panduan;
    private javax.swing.JLabel btn_pelanggan;
    private javax.swing.JLabel btn_penjahit;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JLabel btn_simpan2;
    private javax.swing.JLabel btn_transaksi;
    private javax.swing.JTextArea catatan;
    private javax.swing.JTextField harga;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField namapakaian;
    private javax.swing.JTextField penjahit;
    private javax.swing.JTextField tipe;
    private javax.swing.JTextField totalharga;
    private javax.swing.JTextField txt_pelanggan;
    private javax.swing.JTextField txt_tanggal;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

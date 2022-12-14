/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.admin;

import java.awt.Color;
import java.util.Set;

import javax.swing.JOptionPane;

import jakarta.validation.ConstraintViolation;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.repository.CustomerRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.util.ValidationUtil;
import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author muhai
 */
public class TambahDataPelangganView extends javax.swing.JFrame {
    private Repository<Customer> custRepo = new CustomerRepository();

    /**
     * Creates new form TambahDataPelangganView
     */
    public TambahDataPelangganView() {
        initComponents();
        
        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        txt_namapelanggan.setOpaque(false);
        txt_namapelanggan.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_nohp.setOpaque(false);
        txt_nohp.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_umur.setOpaque(false);
        txt_umur.setBackground(new java.awt.Color(255, 255, 255, 0));

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);

        txt_alamat.setBorder(null);
        txt_alamat.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nohp = new javax.swing.JTextField();
        txt_namapelanggan = new javax.swing.JTextField();
        txt_umur = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        btn_simpan = new javax.swing.JLabel();
        btn_reset = new javax.swing.JLabel();
        btn_back = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        txt_nohp.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_nohp.setBorder(null);
        txt_nohp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nohpActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nohp);
        txt_nohp.setBounds(398, 390, 500, 30);

        txt_namapelanggan.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_namapelanggan.setBorder(null);
        txt_namapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namapelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_namapelanggan);
        txt_namapelanggan.setBounds(398, 272, 500, 30);

        txt_umur.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_umur.setBorder(null);
        txt_umur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_umurActionPerformed(evt);
            }
        });
        getContentPane().add(txt_umur);
        txt_umur.setBounds(398, 330, 500, 30);

        txt_alamat.setColumns(20);
        txt_alamat.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_alamat.setRows(5);
        jScrollPane1.setViewportView(txt_alamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(398, 456, 500, 70);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(818, 557, 90, 30);

        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });
        getContentPane().add(btn_reset);
        btn_reset.setBounds(390, 560, 80, 30);

        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        getContentPane().add(btn_back);
        btn_back.setBounds(380, 190, 40, 40);

        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setPreferredSize(new java.awt.Dimension(1089, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Tambah Pelanggan.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 1100, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nohpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nohpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nohpActionPerformed

    private void txt_namapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namapelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namapelangganActionPerformed

    private void txt_umurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_umurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_umurActionPerformed

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        int age = txt_umur.getText().isEmpty() ? 0 : Integer.valueOf(txt_umur.getText());
        Customer customer = new Customer(
                txt_namapelanggan.getText(),
                age,
                txt_nohp.getText(),
                txt_alamat.getText()
        );
        Set<ConstraintViolation<Customer>> vols = ValidationUtil.validate(customer);

        if(vols.size() < 1) {
            custRepo.add(customer);
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");

            new DataPelangganView().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
        }
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        new DataPelangganView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        txt_alamat.setText("");
        txt_namapelanggan.setText("");
        txt_nohp.setText("");
        txt_umur.setText("");
    }//GEN-LAST:event_btn_resetMouseClicked

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
            java.util.logging.Logger.getLogger(TambahDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahDataPelangganView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_reset;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_namapelanggan;
    private javax.swing.JTextField txt_nohp;
    private javax.swing.JTextField txt_umur;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

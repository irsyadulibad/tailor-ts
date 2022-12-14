/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.admin;

import java.util.Set;

import javax.swing.JOptionPane;

import jakarta.validation.ConstraintViolation;
import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.repository.AccountRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.util.ValidationUtil;
import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author muhai
 */
public class TambahDataPenjahitView extends javax.swing.JFrame {
    private Repository<Account> accRepo = new AccountRepository();

    /**
     * Creates new form TambahDataPenjahitView
     */
    public TambahDataPenjahitView() {
        this.setTitle("Tambah Data Penjahit - Tailor TS");
        initComponents();

        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_namapenjahit.setOpaque(false);
        txt_namapenjahit.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_username.setOpaque(false);
        txt_username.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_email.setOpaque(false);
        txt_email.setBackground(new java.awt.Color(255, 255, 255, 0));

        pass.setOpaque(false);
        pass.setBackground(new java.awt.Color(255, 255, 255, 0));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_email = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_namapenjahit = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        btn_reset = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 708));
        setPreferredSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        txt_email.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_email.setBorder(null);
        getContentPane().add(txt_email);
        txt_email.setBounds(660, 330, 240, 40);

        txt_username.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_username.setBorder(null);
        getContentPane().add(txt_username);
        txt_username.setBounds(397, 332, 230, 40);

        txt_namapenjahit.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        txt_namapenjahit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_namapenjahit.setBorder(null);
        getContentPane().add(txt_namapenjahit);
        txt_namapenjahit.setBounds(397, 260, 500, 40);

        pass.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        pass.setBorder(null);
        getContentPane().add(pass);
        pass.setBounds(397, 402, 500, 40);

        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });
        getContentPane().add(btn_reset);
        btn_reset.setBounds(390, 460, 80, 30);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(817, 460, 90, 30);

        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btn_kembali);
        btn_kembali.setBounds(370, 190, 50, 40);

        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setPreferredSize(new java.awt.Dimension(1089, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Tambah Penjahit.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 1090, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        new DataPenjahitView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliMouseClicked

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        Account account = new Account(
            txt_namapenjahit.getText(),
            txt_email.getText(),
            txt_username.getText(),
            pass.getText(),
            AccountRole.tailor
        );

        Set<ConstraintViolation<Account>> vols = ValidationUtil.validate(account);

        if(vols.size() < 1) {
            accRepo.add(account);
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");

            new DataPenjahitView().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
        }
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        txt_email.setText("");
        txt_namapenjahit.setText("");
        txt_username.setText("");
        pass.setText("");
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
            java.util.logging.Logger.getLogger(TambahDataPenjahitView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahDataPenjahitView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahDataPenjahitView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahDataPenjahitView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahDataPenjahitView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_kembali;
    private javax.swing.JLabel btn_reset;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_namapenjahit;
    private javax.swing.JTextField txt_username;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view;

import java.util.Set;

import javax.swing.JOptionPane;

import jakarta.validation.ConstraintViolation;
import polije.ppl.tailor.data.SessionData;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.service.AuthService;
import polije.ppl.tailor.util.ValidationUtil;

/**
 *
 * @author Hafidz
 */
public class PassBaruView extends javax.swing.JFrame {

    /**
     * Creates new form PassBaruView
     */
    public PassBaruView() {
        initComponents();
        pass.setOpaque(false);
        pass.setBackground(new java.awt.Color(255, 255, 255, 0));

        passbaru.setOpaque(false);
        passbaru.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass = new javax.swing.JPasswordField();
        passbaru = new javax.swing.JPasswordField();
        bbutton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        IMGinti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        pass.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        pass.setBorder(null);
        getContentPane().add(pass);
        pass.setBounds(390, 338, 280, 40);

        passbaru.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        passbaru.setBorder(null);
        passbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passbaruActionPerformed(evt);
            }
        });
        getContentPane().add(passbaru);
        passbaru.setBounds(390, 416, 280, 40);

        bbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bbuttonMouseClicked(evt);
            }
        });
        getContentPane().add(bbutton);
        bbutton.setBounds(358, 178, 40, 30);

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(384, 469, 320, 40);

        IMGinti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Konfirmasi Password.png"))); // NOI18N
        getContentPane().add(IMGinti);
        IMGinti.setBounds(0, 0, 1089, 708);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuttonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bbuttonMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Account account = SessionData.account;

        if(pass.getText().equals(passbaru.getText())) {
            account.setPassword(passbaru.getText());

            Set<ConstraintViolation<Account>> violations = ValidationUtil.validate(account);
            String errors = ValidationUtil.getErrorsAsString(violations, "\n");

            if(violations.size() > 0) {
                JOptionPane.showMessageDialog(this, errors);
            } else {
                new AuthService().resetPassword(account);
                new DashBoardPenjahitView().setVisible(true);

                JOptionPane.showMessageDialog(this, "Password berhasil diubah");
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Password dan konfirmasi harus sama");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void passbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passbaruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passbaruActionPerformed

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
            java.util.logging.Logger.getLogger(PassBaruView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassBaruView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassBaruView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassBaruView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassBaruView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMGinti;
    private javax.swing.JLabel bbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField passbaru;
    // End of variables declaration//GEN-END:variables
}

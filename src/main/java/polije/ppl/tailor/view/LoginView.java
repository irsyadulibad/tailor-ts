/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view;

import javax.swing.JOptionPane;

import polije.ppl.tailor.service.AuthService;
import polije.ppl.tailor.util.ViewUtil;

/**
 *
 * @author Hafidz
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        this.setTitle("Login - Tailor TS");
        initComponents();
        username.setOpaque(false);
        username.setBackground(new java.awt.Color(255, 255, 255, 0));

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

        username = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        masuk = new javax.swing.JLabel();
        bbutton = new javax.swing.JLabel();
        reset = new javax.swing.JLabel();
        IMGinti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        username.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(390, 320, 280, 40);

        pass.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        pass.setBorder(null);
        getContentPane().add(pass);
        pass.setBounds(390, 396, 280, 40);

        masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masukMouseClicked(evt);
            }
        });
        getContentPane().add(masuk);
        masuk.setBounds(383, 452, 320, 40);

        bbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bbuttonMouseClicked(evt);
            }
        });
        getContentPane().add(bbutton);
        bbutton.setBounds(358, 160, 40, 30);

        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(600, 518, 40, 20);

        IMGinti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Page Login.png"))); // NOI18N
        getContentPane().add(IMGinti);
        IMGinti.setBounds(0, 0, 1089, 708);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void masukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masukMouseClicked
        if(!new AuthService().login(username.getText(), pass.getText())) {
            JOptionPane.showMessageDialog(this, "Username atau Password salah!");
            return;
        }

        new ViewUtil().authRedirector(this);
    }//GEN-LAST:event_masukMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        this.dispose();
        new LupaPasswordView().setVisible(true);
    }//GEN-LAST:event_resetMouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed

    }//GEN-LAST:event_usernameActionPerformed

    private void bbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuttonMouseClicked
        new LandingPageView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bbuttonMouseClicked

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMGinti;
    private javax.swing.JLabel bbutton;
    private javax.swing.JLabel masuk;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel reset;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view;

/**
 *
 * @author Hafidz
 */
public class InputKodeView extends javax.swing.JFrame {

    /**
     * Creates new form InputKodeView
     */
    public InputKodeView() {
        initComponents();
        kode.setOpaque(false);
        kode.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kode = new javax.swing.JTextField();
        kirim = new javax.swing.JLabel();
        bbutton = new javax.swing.JLabel();
        IMGiti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1088, 708));
        setMinimumSize(new java.awt.Dimension(1088, 708));
        setPreferredSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        kode.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        kode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kode.setBorder(null);
        getContentPane().add(kode);
        kode.setBounds(422, 360, 240, 50);

        kirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kirimMouseClicked(evt);
            }
        });
        getContentPane().add(kirim);
        kirim.setBounds(419, 430, 250, 40);

        bbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bbuttonMouseClicked(evt);
            }
        });
        getContentPane().add(bbutton);
        bbutton.setBounds(394, 228, 40, 30);

        IMGiti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Kode Verifikasi.png"))); // NOI18N
        getContentPane().add(IMGiti);
        IMGiti.setBounds(0, 0, 1088, 708);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kirimMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kirimMouseClicked

    private void bbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuttonMouseClicked
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(InputKodeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputKodeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputKodeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputKodeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputKodeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMGiti;
    private javax.swing.JLabel bbutton;
    private javax.swing.JLabel kirim;
    private javax.swing.JTextField kode;
    // End of variables declaration//GEN-END:variables
}

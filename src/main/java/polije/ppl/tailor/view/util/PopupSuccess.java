/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package polije.ppl.tailor.view.util;

/**
 *
 * @author muhai
 */
public class PopupSuccess extends javax.swing.JFrame {
    String msg;

    /**
     * Creates new form PopupSuccess
     */
    public PopupSuccess(String message) {
        this.msg = message;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text1 = new javax.swing.JLabel();
        btn = new javax.swing.JLabel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().setLayout(null);

        text1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        text1.setText("Data Berhasil Disimpan");
        getContentPane().add(text1);
        text1.setBounds(180, 140, 270, 120);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMouseClicked(evt);
            }
        });
        getContentPane().add(btn);
        btn.setBounds(190, 277, 120, 40);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/PopUp_Berhasill.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 498, 396);

        setSize(new java.awt.Dimension(516, 443));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    public static void show(String message) {
        new PopupSuccess(message).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

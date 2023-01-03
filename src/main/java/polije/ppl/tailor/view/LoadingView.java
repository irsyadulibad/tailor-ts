/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package polije.ppl.tailor.view;

/**
 *
 * @author ibad
 */
public class LoadingView extends javax.swing.JFrame {

    /**
     * Creates new form LoadingView
     */
    public LoadingView() {
        this.setTitle("Loading - Tailor TS");
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

        progress = new javax.swing.JProgressBar();
        loadingText = new javax.swing.JLabel();
        loadingPercent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 416));
        setUndecorated(true);
        getContentPane().setLayout(null);

        progress.setForeground(new java.awt.Color(102, 102, 0));
        getContentPane().add(progress);
        progress.setBounds(0, 395, 640, 20);

        loadingText.setText("Loading Environment...");
        getContentPane().add(loadingText);
        loadingText.setBounds(5, 375, 220, 19);

        loadingPercent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        loadingPercent.setText("0%");
        getContentPane().add(loadingPercent);
        loadingPercent.setBounds(537, 375, 100, 19);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/SplashScreen.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 416);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoadingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        LoadingView view = new LoadingView();
        view.setVisible(true);

        try {
            for(int i = 1; i <= 100; i++) {
               Thread.sleep(25);
               
               view.progress.setValue(i);
               view.loadingPercent.setText(i + "%");
               view.loadingText.setText("Loading modules...");
               
               if(i > 25) view.loadingText.setText("Connecting to database...");
               if(i > 50) view.loadingText.setText("Loading application...");
               if(i > 75) view.loadingText.setText("Launching application...");
            }
        } catch(Exception e) { e.printStackTrace(); }
        
        new LandingPageView().setVisible(true);
        view.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loadingPercent;
    private javax.swing.JLabel loadingText;
    private javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
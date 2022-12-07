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
public class LoadingPageView extends javax.swing.JFrame {

    /**
     * Creates new form LoadingPageView
     */
    public LoadingPageView() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        barloading = new javax.swing.JProgressBar();
        txt_loading = new javax.swing.JLabel();
        view_loadingbar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 708));

        jPanel1.setPreferredSize(new java.awt.Dimension(1088, 708));
        jPanel1.setLayout(null);

        jPanel2.setForeground(new java.awt.Color(0, 0, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barloading.setForeground(new java.awt.Color(118, 159, 205));
        jPanel2.add(barloading, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 52, 684, 26));

        txt_loading.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txt_loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_loading.setText("0%");
        jPanel2.add(txt_loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 24, -1, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(170, 490, 770, 100);

        view_loadingbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/LoadingPage.png"))); // NOI18N
        jPanel1.add(view_loadingbar);
        view_loadingbar.setBounds(0, -30, 1240, 780);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      LoadingPageView loading = new LoadingPageView();
      loading.setVisible(true);
      
      try{
          for (int i=0; i<100; i++){
              Thread.sleep(80);
              loading.txt_loading.setText(Integer.toString(i)+"%");
              loading.barloading.setValue(i);
          }
          new LandingPageView().setVisible(true);
          loading.dispose();
          
      }catch(InterruptedException e){
          
      }
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barloading;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txt_loading;
    private javax.swing.JLabel view_loadingbar;
    // End of variables declaration//GEN-END:variables
}

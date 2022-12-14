/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.tailor;

import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import polije.ppl.tailor.entity.Measure;
import polije.ppl.tailor.repository.MeasureRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.util.ViewUtil;
import polije.ppl.tailor.view.util.SidebarTailorView;

/**
 *
 * @author Hafidz
 */
public class UkuranView extends javax.swing.JFrame {
    private Repository<Measure> measRepo = new MeasureRepository();

    /**
     * Creates new form UkuranView
     */
    public UkuranView() {
        this.setTitle("Data Ukuran - Tailor TS");
        initComponents();

        search.setOpaque(false);
        search.setBackground(new java.awt.Color(255, 255, 255, 0));

        sidebar.add(new SidebarTailorView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));

        loadTable(measRepo.get());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    private UkuranView(Measure msr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tambahdata = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        sidebar = new javax.swing.JPanel();
        imginti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1089, 740));
        getContentPane().setLayout(null);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(362, 250, 640, 402);

        tambahdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahdataMouseClicked(evt);
            }
        });
        getContentPane().add(tambahdata);
        tambahdata.setBounds(872, 107, 130, 40);

        search.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        search.setBorder(null);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(780, 200, 170, 40);

        sidebar.setMaximumSize(new java.awt.Dimension(277, 708));
        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        imginti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/tailor-measures.png"))); // NOI18N
        getContentPane().add(imginti);
        imginti.setBounds(0, 0, 1090, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahdataMouseClicked
        new TambahDataUkuranView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tambahdataMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, 3).toString();
        polije.ppl.tailor.entity.Measure msr = measRepo.get(Integer.valueOf(value));

        new EditDataUkuranView(msr).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        List<Measure> measures = measRepo.search(new HashMap<>() {{
            put("cloth_type", search.getText());
        }});

        loadTable(measures);
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(UkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UkuranView().setVisible(true);
            }
        });
    }

    private void loadTable(List<Measure> measures) {
        int no = 1;
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Pakaian");
        model.addColumn("Pelanggan");
        model.addColumn("ID");

        for(Measure measure: measures) {
            model.addRow(new Object[] {
                no++,
                measure.getClothType(),
                measure.getCustomer().getFullname(),
                measure.getId(),
            });
        }

        jTable1.setModel(model);
        ViewUtil.hideTableColumn(jTable1, 3);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imginti;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel tambahdata;
    // End of variables declaration//GEN-END:variables
}

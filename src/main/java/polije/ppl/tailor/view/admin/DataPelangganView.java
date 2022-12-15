/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.admin;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.repository.CustomerRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.util.ViewUtil;
import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author muhai
 */
public class DataPelangganView extends javax.swing.JFrame {
    private Repository<Customer> custRepo = new CustomerRepository();

    /**
     * Creates new form DataPelangganView
     */
    public DataPelangganView() {
        initComponents();

        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_search.setOpaque(false);
        txt_search.setBackground(new java.awt.Color(255, 255, 255, 0));

        loadTable(custRepo.get());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_tambahdata = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 740));
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(360, 260, 570, 280);

        txt_search.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txt_search.setBorder(null);
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        getContentPane().add(txt_search);
        txt_search.setBounds(710, 202, 170, 30);

        btn_tambahdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahdataMouseClicked(evt);
            }
        });
        getContentPane().add(btn_tambahdata);
        btn_tambahdata.setBounds(800, 100, 130, 50);

        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Pelanggan.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 1080, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchKeyReleased

    private void btn_tambahdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahdataMouseClicked
        new TambahDataPelangganView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_tambahdataMouseClicked

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
            java.util.logging.Logger.getLogger(DataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPelangganView().setVisible(true);
            }
        });
    }

    private void loadTable(List<Customer> customers) {
        int no = 1;
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Umur");
        model.addColumn("No. Telp");
        model.addColumn("ID");

        for(Customer customer: customers) {
            model.addRow(new Object[] {
                no++,
                customer.getFullname(),
                customer.getAge(),
                customer.getPhone(),
                customer.getId()
            });
        }

        jTable1.setModel(model);
        ViewUtil.hideTableColumn(jTable1, 4);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_tambahdata;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

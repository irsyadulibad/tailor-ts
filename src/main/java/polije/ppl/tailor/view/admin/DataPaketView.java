/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.admin;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.repository.PackageRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.util.NumberUtil;
import polije.ppl.tailor.util.ViewUtil;
import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author muhai
 */
public class DataPaketView extends javax.swing.JFrame {
    private Repository<Package> pkgRepo = new PackageRepository();

    /**
     * Creates new form DataPaketView
     */
    public DataPaketView() {
        initComponents();

        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));

        txt_pencarian.setOpaque(false);
        txt_pencarian.setBackground(new java.awt.Color(255, 255, 255, 0));

        loadTable(pkgRepo.get());
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
        table_datapaket = new javax.swing.JTable();
        txt_pencarian = new javax.swing.JTextField();
        btn_tambahdata = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 708));
        getContentPane().setLayout(null);

        table_datapaket.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        table_datapaket.setModel(new javax.swing.table.DefaultTableModel(
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
        table_datapaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_datapaketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_datapaket);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(360, 230, 570, 240);

        txt_pencarian.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txt_pencarian.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pencarian.setBorder(null);
        txt_pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pencarianKeyReleased(evt);
            }
        });
        getContentPane().add(txt_pencarian);
        txt_pencarian.setBounds(710, 182, 170, 40);

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

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Paket.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 1090, 708);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahdataMouseClicked
        new TambahDataPaketView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_tambahdataMouseClicked

    private void txt_pencarianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pencarianKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pencarianKeyReleased

    private void table_datapaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_datapaketMouseClicked
        int row = table_datapaket.getSelectedRow();
        String value = table_datapaket.getModel().getValueAt(row, 3).toString();

        System.out.append(value);
    }//GEN-LAST:event_table_datapaketMouseClicked

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
            java.util.logging.Logger.getLogger(DataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPaketView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPaketView().setVisible(true);
            }
        });
    }

    private void loadTable(List<Package> packages) {
        Integer no = 1;
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Tipe Pakaian");
        model.addColumn("Harga");
        model.addColumn("ID");

        for(Package pkg: packages) {
            model.addRow(new Object[] {
                no++,
                pkg.getName(),
                NumberUtil.formatDec(pkg.getPrice()),
                pkg.getId()
            });
        }

        table_datapaket.setModel(model);
        ViewUtil.hideTableColumn(table_datapaket, 3);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_tambahdata;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTable table_datapaket;
    private javax.swing.JTextField txt_pencarian;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}
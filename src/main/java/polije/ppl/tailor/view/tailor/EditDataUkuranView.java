/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.tailor;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import jakarta.validation.ConstraintViolation;
import polije.ppl.tailor.data.ComboItem;
import polije.ppl.tailor.data.MeasureItem;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.entity.Measure;
import polije.ppl.tailor.repository.CustomerRepository;
import polije.ppl.tailor.repository.MeasureRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.service.validation.MeasureValidation;
import polije.ppl.tailor.util.ValidationUtil;
import polije.ppl.tailor.util.ViewUtil;
import polije.ppl.tailor.view.util.SearchableComboBox;
import polije.ppl.tailor.view.util.SidebarTailorView;

/**
 *
 * @author Hafidz
 */
public class EditDataUkuranView extends javax.swing.JFrame {
    private Measure measure;
    private List<MeasureItem> items;
    private Repository<Customer> custRepo = new CustomerRepository();
    private Repository<Measure> measRepo = new MeasureRepository();
    private Integer activeDetail;

    /**
     * Creates new form TambahDataUkuran
     */
    public EditDataUkuranView(Measure measure) {
        this.setTitle("Edit Data Ukuran - Tailor TS");
        this.measure = measure;
        this.items = measure.getItemsCollection();

        initComponents();
        initTransparents();
        fillInput();

        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipepakaian = new javax.swing.JTextField();
        nilai = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        simpan = new javax.swing.JLabel();
        hapus = new javax.swing.JLabel();
        simpandata = new javax.swing.JLabel();
        reset = new javax.swing.JLabel();
        bbutton = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        imginti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1089, 740));
        getContentPane().setLayout(null);

        fillComboBox();

        tipepakaian.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tipepakaian.setBorder(null);
        tipepakaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipepakaianActionPerformed(evt);
            }
        });
        getContentPane().add(tipepakaian);
        tipepakaian.setBounds(405, 236, 490, 30);

        nilai.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nilai.setBorder(null);
        nilai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nilaiKeyReleased(evt);
            }
        });
        getContentPane().add(nilai);
        nilai.setBounds(622, 327, 180, 30);

        nama.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nama.setBorder(null);
        getContentPane().add(nama);
        nama.setBounds(404, 327, 180, 30);

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
        jScrollPane1.setBounds(384, 370, 530, 240);

        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(822, 328, 30, 30);

        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(862, 328, 30, 30);

        simpandata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpandataMouseClicked(evt);
            }
        });
        getContentPane().add(simpandata);
        simpandata.setBounds(821, 645, 90, 30);

        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(393, 644, 80, 30);

        bbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bbuttonMouseClicked(evt);
            }
        });
        getContentPane().add(bbutton);
        bbutton.setBounds(379, 102, 40, 30);

        sidebar.setMaximumSize(new java.awt.Dimension(277, 708));
        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        imginti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Edit Ukuran Penjahit.png"))); // NOI18N
        getContentPane().add(imginti);
        imginti.setBounds(0, 0, 1090, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initTransparents() {
        plg.setOpaque(false);
        plg.setBackground(new java.awt.Color(255, 255, 255, 0));

        tipepakaian.setOpaque(false);
        tipepakaian.setBackground(new java.awt.Color(255, 255, 255, 0));

        nama.setOpaque(false);
        nama.setBackground(new java.awt.Color(255, 255, 255, 0));

        nilai.setOpaque(false);
        nilai.setBackground(new java.awt.Color(255, 255, 255, 0));

        sidebar.add(new SidebarTailorView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    private void nilaiKeyReleased(java.awt.event.KeyEvent evt) {
        ViewUtil.replaceNumberInput(nilai);
    }

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        String value = nilai.getText();
        MeasureItem item = (activeDetail == null) ?
            new MeasureItem() : items.get(activeDetail);

        item.setName(nama.getText());
        item.setValue(value.isBlank() ? 0 : Integer.valueOf(value));

        Set<ConstraintViolation<MeasureItem>> vols = ValidationUtil.validate(item);

        if(vols.size() > 0) {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
            return;
        }

        if(activeDetail == null) this.items.add(0, item);
        activeDetail = null;

        nilai.setText("");
        loadTable();
    }//GEN-LAST:event_simpanMouseClicked

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        if(activeDetail == null) {
            JOptionPane.showMessageDialog(this, "Anda harus memilih data terlebih dahulu");
            return;
        }

        items.remove((int) activeDetail);
        activeDetail = null;

        loadTable();
        nilai.setText("");
    }//GEN-LAST:event_hapusMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        int clicked = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?");

        if(clicked == 0) {
            measRepo.delete(measure.getId());

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            new UkuranView().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_resetMouseClicked

    private void bbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuttonMouseClicked
        new UkuranView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bbuttonMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        MeasureItem item = items.get(row);
        this.activeDetail = row;

        nama.setText(item.getName());
        nilai.setText(String.valueOf(item.getValue()));
    }//GEN-LAST:event_jTable1MouseClicked

    private void simpandataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpandataMouseClicked
        ComboItem customer = (ComboItem) plg.getSelectedItem();
        MeasureValidation comboValidation = new MeasureValidation(customer);

        Set<ConstraintViolation<MeasureValidation>> vols = ValidationUtil.validate(comboValidation);

        if(vols.size() > 0) {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
            return;
        }

        measure.setClothType(tipepakaian.getText());
        measure.setCustomer(custRepo.get(customer.getKey()));
        measure.setItems(items);

        Set<ConstraintViolation<Measure>> vols2 = ValidationUtil.validate(measure);
        if(vols2.size() > 0) {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
            return;
        }

        measRepo.update(measure);

        JOptionPane.showMessageDialog(this, "Data ukuran berhasil disimpan");
        new UkuranView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_simpandataMouseClicked

    private void tipepakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipepakaianActionPerformed

    }//GEN-LAST:event_tipepakaianActionPerformed



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
            java.util.logging.Logger.getLogger(EditDataUkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDataUkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDataUkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDataUkuranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Nama");
        model.addColumn("Nilai (cm)");

        for(MeasureItem item: this.items) {
            model.addRow(new Object[] {
                item.getName(),
                item.getValue(),
            });
        }

        jTable1.setModel(model);
    }

    private void fillComboBox() {
        ComboItem[] items;
        List<Customer> customers = custRepo.get();

        items = new ComboItem[customers.size()];
        for(int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            items[i] = new ComboItem(customer.getId(), customer.getFullname());
        }

        plg = new SearchableComboBox(items);
        plg.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        plg.setBorder(null);
        getContentPane().add(plg);
        plg.setBounds(395, 176, 510, 30);
    }

    private void fillInput(){
        tipepakaian.setText(measure.getClothType());
        plg.setSelectedItem(new ComboItem(
            measure.getCustomer().getId(),
            measure.getCustomer().getFullname()
        ));
    }

    private javax.swing.JComboBox plg;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bbutton;
    private javax.swing.JLabel hapus;
    private javax.swing.JLabel imginti;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nilai;
    private javax.swing.JLabel reset;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel simpan;
    private javax.swing.JLabel simpandata;
    private javax.swing.JTextField tipepakaian;
    // End of variables declaration//GEN-END:variables
}

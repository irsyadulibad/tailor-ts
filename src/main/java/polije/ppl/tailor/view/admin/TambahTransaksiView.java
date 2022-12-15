/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polije.ppl.tailor.view.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import jakarta.validation.ConstraintViolation;
import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.data.ComboItem;
import polije.ppl.tailor.data.TransactionStatus;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.entity.Transaction;
import polije.ppl.tailor.entity.TransactionDetail;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.repository.TransactionDetailRepository;
import polije.ppl.tailor.repository.TransactionRepository;
import polije.ppl.tailor.service.validation.TransactionValidation;
import polije.ppl.tailor.util.NumberUtil;
import polije.ppl.tailor.util.ValidationUtil;
import polije.ppl.tailor.repository.AccountRepository;
import polije.ppl.tailor.repository.CustomerRepository;
import polije.ppl.tailor.repository.PackageRepository;
import polije.ppl.tailor.view.util.SearchableComboBox;
import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author muhai
 */
public class TambahTransaksiView extends javax.swing.JFrame {
    private Repository<Account> accRepo = new AccountRepository();
    private Repository<Customer> custRepo = new CustomerRepository();
    private Repository<Package> pkgRepo = new PackageRepository();
    private Repository<Transaction> transRepo = new TransactionRepository();
    private Repository<TransactionDetail> detailRepo = new TransactionDetailRepository();
    private List<TransactionDetail> details = new ArrayList<>();
    private Integer activeDetail, total;

    /**
     * Creates new form TambahTransaksiView
     */
    public TambahTransaksiView() {
        fillComboBox();
        initComponents();
        initTransparent();
        loadTable();

        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        dateInput = new JDateChooser();
        namapakaian = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        btn_kembali = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        catatan = new javax.swing.JTextArea();
        grandTotal = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        btn_reset = new javax.swing.JLabel();
        view = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 730));
        getContentPane().setLayout(null);

        dateInput.setBounds(680, 223, 230, 30);
        getContentPane().add(dateInput);

        namapakaian.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        namapakaian.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        namapakaian.setBorder(null);
        namapakaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namapakaianActionPerformed(evt);
            }
        });
        getContentPane().add(namapakaian);
        namapakaian.setBounds(410, 307, 90, 30);

        jumlah.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jumlah.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jumlah.setBorder(null);
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(jumlah);
        jumlah.setBounds(630, 307, 90, 30);

        harga.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        harga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        harga.setBorder(null);
        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        getContentPane().add(harga);
        harga.setBounds(735, 307, 90, 30);

        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btn_kembali);
        btn_kembali.setBounds(395, 89, 40, 30);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(830, 300, 40, 40);

        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        getContentPane().add(btn_save);
        btn_save.setBounds(835, 650, 90, 40);

        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        getContentPane().add(btn_hapus);
        btn_hapus.setBounds(877, 307, 30, 30);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(400, 340, 510, 80);

        catatan.setColumns(20);
        catatan.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        catatan.setRows(5);
        jScrollPane2.setViewportView(catatan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 505, 510, 120);

        grandTotal.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        getContentPane().add(grandTotal);
        grandTotal.setBounds(730, 450, 180, 27);

        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setPreferredSize(new java.awt.Dimension(1089, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });
        getContentPane().add(btn_reset);
        btn_reset.setBounds(400, 650, 90, 40);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Tambah Transaksi.png"))); // NOI18N
        getContentPane().add(view);
        view.setBounds(0, 0, 1090, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fillComboBox() {
        ComboItem[] items;
        List<Customer> customers = custRepo.get();
        List<Package> packages = pkgRepo.get();
        List<Account> tailors = accRepo.get(new HashMap<>(){{
            put("role", AccountRole.tailor.toString());
        }});

        items = new ComboItem[customers.size()];
        for(int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            items[i] = new ComboItem(customer.getId(), customer.getFullname());
        }

        customerInput = new SearchableComboBox(items);
        customerInput.setFont(new java.awt.Font("Ubuntu", 0, 16));
        customerInput.setBorder(null);
        customerInput.setBounds(420, 156, 490, 30);

        items = new ComboItem[tailors.size()];
        for(int i = 0; i < tailors.size(); i++) {
            Account account = tailors.get(i);
            items[i] = new ComboItem(account.getId(), account.getFullname());
        }

        tailorInput = new SearchableComboBox(items);
        tailorInput.setFont(new java.awt.Font("Ubuntu", 0, 16));
        tailorInput.setBorder(null);
        tailorInput.setBounds(420, 223, 230, 30);

        items = new ComboItem[packages.size()];
        for(int i = 0; i < packages.size(); i++) {
            Package pkg = packages.get(i);
            items[i] = new ComboItem(pkg.getId(), pkg.getName());
        }

        packageInput = new SearchableComboBox(items);
        packageInput.setFont(new java.awt.Font("Ubuntu", 0, 16));
        packageInput.setBorder(null);
        packageInput.setBounds(520, 307, 90, 30);

        getContentPane().add(customerInput);
        getContentPane().add(tailorInput);
        getContentPane().add(packageInput);
    }

    private void initTransparent() {
        dateInput.setOpaque(false);
        dateInput.setBackground(new java.awt.Color(255, 255, 255, 0));

        customerInput.setOpaque(false);
        customerInput.setBackground(new java.awt.Color(255, 255, 255, 0));

        tailorInput.setOpaque(false);
        tailorInput.setBackground(new java.awt.Color(255, 255, 255, 0));

        namapakaian.setOpaque(false);
        namapakaian.setBackground(new java.awt.Color(255, 255, 255, 0));

        jumlah.setOpaque(false);
        jumlah.setBackground(new java.awt.Color(255, 255, 255, 0));

        harga.setOpaque(false);
        harga.setBackground(new java.awt.Color(255, 255, 255, 0));

        grandTotal.setOpaque(false);
        grandTotal.setBackground(new java.awt.Color(255, 255, 255, 0));

        packageInput.setOpaque(false);
        packageInput.setBackground(new java.awt.Color(255, 255, 255, 0));

        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportBorder(null);

        catatan.setOpaque(false);
        catatan.setBackground(new java.awt.Color(255, 255, 255, 0));
    }

    private void loadTable() {
        int no = 1;
        int total = 0;
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Nama Pakaian");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Subtotal");

        for(TransactionDetail detail: details) {
            int subTotal = detail.getPrice() * detail.getQty();
            total += subTotal;

            model.addRow(new Object[] {
                no++,
                detail.getClothName(),
                NumberUtil.formatDec(detail.getPrice()),
                NumberUtil.formatDec(detail.getQty()),
                NumberUtil.formatDec(subTotal)
            });
        }

        this.total = total;
        jTable1.setModel(model);
        grandTotal.setText(NumberUtil.formatDec(total));
    }

    private void resetInputDetail() {
        harga.setText("");
        jumlah.setText("");
        namapakaian.setText("");
    }

    private void namapakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namapakaianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namapakaianActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        TransactionDetail detail = (activeDetail == null) ?
            new TransactionDetail() : details.get(activeDetail);
        ComboItem pkgItem = (ComboItem) packageInput.getSelectedItem();
        Package pkg = pkgRepo.get(pkgItem.getKey());
        String price = harga.getText();
        String qty = jumlah.getText();

        detail.setPackage(pkg);
        detail.setPrice(price.isBlank() ? 0 : Integer.parseInt(price));
        detail.setQty(qty.isBlank() ? 0 : Integer.parseInt(qty));
        detail.setClothName(namapakaian.getText());

        Set<ConstraintViolation<TransactionDetail>> vols = ValidationUtil.validate(detail);

        if(vols.size() > 0) {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
            return;
        }

        if(activeDetail == null) details.add(detail);
        loadTable();
        resetInputDetail();
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        new DataTransaksiView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliMouseClicked

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        if(activeDetail == null) {
            JOptionPane.showMessageDialog(this, "Anda harus memilih data terlebih dahulu");
            return;
        }

        details.remove((int) activeDetail);
        activeDetail = null;

        loadTable();
        resetInputDetail();
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.rowAtPoint(evt.getPoint());
        TransactionDetail detail = details.get(index);
        activeDetail = index;

        jumlah.setText(String.valueOf(detail.getQty()));
        namapakaian.setText(detail.getClothName());
        harga.setText(String.valueOf(detail.getPrice()));
        packageInput.setSelectedItem(new ComboItem(
            detail.getPackage().getId(),
            detail.getPackage().getName())
        );
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        ComboItem customer = (ComboItem) customerInput.getSelectedItem();
        ComboItem tailor = (ComboItem) tailorInput.getSelectedItem();
        Date dueDate = dateInput.getDate();
        TransactionValidation comboValidation = new TransactionValidation(customer, tailor);

        Set<ConstraintViolation<TransactionValidation>> vols = ValidationUtil.validate(comboValidation);
        if(vols.size() > 0) {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
            return;
        }

        Transaction transaction = new Transaction(
            total,
            accRepo.get(tailor.getKey()),
            custRepo.get(customer.getKey()),
            new Date(),
            dueDate,
            catatan.getText(),
            TransactionStatus.unfinish
        );

        int id = transRepo.add(transaction);
        transaction.setId(id);
        addDetails(transaction);

        JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan");
        new DataTransaksiView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resetMouseClicked

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
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahTransaksiView().setVisible(true);
            }
        });
    }

    private void addDetails(Transaction transaction) {
        for(TransactionDetail detail: details) {
            detail.setTransaction(transaction);
            detailRepo.add(detail);
        }
    }

    private javax.swing.JComboBox customerInput;
    private javax.swing.JComboBox tailorInput;
    private javax.swing.JComboBox packageInput;
    private JDateChooser dateInput;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_kembali;
    private javax.swing.JLabel btn_reset;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JTextArea catatan;
    private javax.swing.JLabel grandTotal;
    private javax.swing.JTextField harga;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField namapakaian;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}

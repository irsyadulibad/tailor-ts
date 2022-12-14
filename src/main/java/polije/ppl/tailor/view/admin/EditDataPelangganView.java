/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package polije.ppl.tailor.view.admin;

import java.awt.Color;
import java.util.Set;

import javax.swing.JOptionPane;

import jakarta.validation.ConstraintViolation;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.repository.CustomerRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.util.ValidationUtil;
import polije.ppl.tailor.util.ViewUtil;
import polije.ppl.tailor.view.util.SidebarAdminView;

/**
 *
 * @author Hafidz
 */
public class EditDataPelangganView extends javax.swing.JFrame {
    private Customer customer;
    private Repository<Customer> custRepo = new CustomerRepository();

    /**
     * Creates new form EditDataPelangganView
     */
    public EditDataPelangganView(Customer customer) {
        this.setTitle("Edit Pelanggan Penjahit - Tailor TS");
        this.customer = customer;

        initComponents();
        fillForm();

        sidebar.add(new SidebarAdminView(this));
        sidebar.setBackground(new java.awt.Color(255, 255, 255, 0));

        namapelanggan.setOpaque(false);
        namapelanggan.setBackground(new java.awt.Color(255, 255, 255, 0));

        nohp.setOpaque(false);
        nohp.setBackground(new java.awt.Color(255, 255, 255, 0));

        umur.setOpaque(false);
        umur.setBackground(new java.awt.Color(255, 255, 255, 0));

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);

        alamat.setBorder(null);
        alamat.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        namapelanggan = new javax.swing.JTextField();
        umur = new javax.swing.JTextField();
        nohp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        btn_reset = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1089, 708));
        getContentPane().setLayout(null);

        sidebar.setMinimumSize(new java.awt.Dimension(277, 708));
        sidebar.setPreferredSize(new java.awt.Dimension(1089, 708));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 277, 708);

        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        getContentPane().add(btn_back);
        btn_back.setBounds(377, 192, 50, 40);

        namapelanggan.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        namapelanggan.setBorder(null);

        getContentPane().add(namapelanggan);
        namapelanggan.setBounds(398, 272, 510, 30);

        umur.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        umur.setBorder(null);
        umur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                umurKeyReleased(evt);
            }
        });
        getContentPane().add(umur);
        umur.setBounds(398, 330, 510, 30);

        nohp.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        nohp.setBorder(null);

        getContentPane().add(nohp);
        nohp.setBounds(398, 390, 510, 30);

        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(398, 456, 510, 70);

        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });
        getContentPane().add(btn_reset);
        btn_reset.setBounds(384, 557, 90, 30);

        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan);
        btn_simpan.setBounds(818, 557, 90, 30);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages/Edit Data Pelanggan.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1089, 708);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void umurKeyReleased(java.awt.event.KeyEvent evt) {
        ViewUtil.replaceNumberInput(umur);
    }

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        new DataPelangganView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        int clicked = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?");

        if(clicked == 0) {
            custRepo.delete(customer.getId());

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            new DataPelangganView().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_resetMouseClicked

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        String age = umur.getText();

        customer.setFullname(namapelanggan.getText());
        customer.setPhone(nohp.getText());
        customer.setAge(age.isBlank() ? 0 : Integer.valueOf(age));
        customer.setAddress(alamat.getText());

        Set<ConstraintViolation<Customer>> vols = ValidationUtil.validate(customer);

        if(vols.size() > 0) {
            JOptionPane.showMessageDialog(this, ValidationUtil.getErrorsAsString(vols, "\n"));
            return;
        }

        custRepo.update(customer);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
        new DataPelangganView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_simpanMouseClicked

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
            java.util.logging.Logger.getLogger(EditDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDataPelangganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    private void fillForm() {
        namapelanggan.setText(customer.getFullname());
        nohp.setText(customer.getPhone());
        umur.setText(String.valueOf(customer.getAge()));
        alamat.setText(customer.getAddress());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JLabel background;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_reset;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namapelanggan;
    private javax.swing.JTextField nohp;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField umur;
    // End of variables declaration//GEN-END:variables
}

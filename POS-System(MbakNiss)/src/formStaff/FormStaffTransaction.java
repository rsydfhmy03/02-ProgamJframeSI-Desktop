/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formStaff;

import FormTransaction.FormMakanan;
import static FormTransaction.FormMakanan.stok1;
import static FormTransaction.FormMakanan.stok2;
import FormTransaction.FormMinuman;
import transisi.TransisiForm;
import com.mysql.jdbc.Statement;
import entity.entitas;
import koneksi.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author KRISNA
 */
public class FormStaffTransaction extends TransisiForm {

    FormMakanan fmakanan;
    FormMinuman fminuman;
    
    FormStaffCetakStruk cs;
    
//    int jumlahjual;
    int id_transaksi;
    int harga_makan;
    int harga;
//    List keranjang[];
    Connection conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    JasperReport jasper;
    JasperPrint jaspri;
    Map param = new HashMap();
    JasperDesign jasdes;
    private DefaultTableModel model;
//    entitas eb = new entitas();
    int jumlah = 0;
    List<String> list = new ArrayList<String>();
    Statement stm;
    com.mysql.jdbc.Connection Con;
    private double total;
    DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "Nama Barang", "Jumlah"
            });

    public FormStaffTransaction() throws SQLException {
        initComponents();
        fmakanan = new FormMakanan();
        fminuman = new FormMinuman();

        panelTransisi.add(fmakanan);
        panelTransisi.add(fminuman);

        fmakanan.setVisible(true);
        fminuman.setVisible(false);
        
        cs = new FormStaffCetakStruk();
        panelCetakStruk.add(cs);
        cs.setVisible(false);

        this.conn = koneksi.configDB();
        kurang_stok.disable();
        total_pembayaran.disable();
        initHarga();
    }

    public void initHarga() {
        listMenu();
        getMenu();
    }

    public void listMenu() {
        String sql = "select id_menu,nama_menu,jumlah_menu from stok_menu";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            makanan.removeAllItems();
            while (rs.next()) {
                makanan.addItem(rs.getString(2));
                total_ketersediaan.setText(rs.getString(3));
            }
        } catch (SQLException ex) {
        }
    }

    public void getMenu() {
        String sql = "select id_menu, harga_menu,jumlah_menu from stok_menu where nama_menu = '" + makanan.getSelectedItem() + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                id_transaksi = Integer.parseInt(rs.getString(1));
                harga_makan = Integer.parseInt(rs.getString(2));
                total_ketersediaan.setText(rs.getString(3));
            }
        } catch (SQLException ex) {
        }
    }

    public void doTransaction() {
        String sql_last_data = "SELECT id_kr FROM transaksi ORDER BY id_kr DESC LIMIT 1";
        String query_tr = "insert into transaksi(id_menu, tanggal_keluar, pembayaran, nama_pelanggan) values (?, ?, ?, ?)";
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        int rows = table.getRowCount();

        try {
            pst = conn.prepareStatement(query_tr);
            pst.setInt(1, 1);
            pst.setTimestamp(2, date);
            pst.setString(3, pembayaran.getText());
            pst.setString(4, nama_pelanggan.getText());
            pst.execute();
            PreparedStatement pstm = conn.prepareStatement(sql_last_data);
            ResultSet rsst = pstm.executeQuery();
            rsst.next();
            
            //create detail transaksi
            String query_dt = "insert into detail_transaksi(nama_produk, id_kr, jumlah_beli, id_menu) values (?, ?, ?, ?)";
            PreparedStatement pst2 = conn.prepareStatement(query_dt);

            for (int row = 0; row < rows; row++) {
                System.out.println("test");
                String item_produk = (String) table.getValueAt(row, 0);// mengambil nama produk
                String item_jumlah = (String) table.getValueAt(row, 1);// mengambil qty
                String sq = "SELECT id_menu FROM stok_menu WHERE nama_menu = '" + item_produk + "' ";
                PreparedStatement ps = conn.prepareStatement(sq);
                ResultSet rss = ps.executeQuery();
                rss.next();
                System.out.println(rss.getString(1));

                pst2.setString(1, item_produk);
                pst2.setString(2, rsst.getString(1));
                pst2.setString(3, item_jumlah);
                pst2.setString(4, rss.getString(1));
                pst2.execute();
            }

            JOptionPane.showMessageDialog(null, "Pembayaran Sukses!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Pembayaran gagal!" + e.getMessage());
        }
        pembayaran.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCetakStruk = new javax.swing.JPanel();
        nama_pelanggan = new javax.swing.JTextField();
        kurang_stok = new javax.swing.JTextField();
        makanan = new javax.swing.JComboBox<>();
        btn_makanan = new swing.Button();
        btn_minuman = new swing.Button();
        btn_bayar = new swing.Button();
        btn_add = new swing.Button();
        btn_cetak = new swing.Button();
        total_pembayaran = new javax.swing.JTextField();
        panelTransisi = new javax.swing.JPanel();
        total_ketersediaan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new customtable.CustomTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCetakStruk.setOpaque(false);
        add(panelCetakStruk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1050, 530));
        add(nama_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, 30));
        add(kurang_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 210, 30));

        makanan.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                makananPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        add(makanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 140, 30));

        jumlah_kurang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jumlah_kurangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlah_kurangKeyReleased(evt);
            }
        });
        add(jumlah_kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 40, 30));

        btn_makanan.setBackground(new java.awt.Color(255, 202, 73));
        btn_makanan.setForeground(new java.awt.Color(82, 82, 82));
        btn_makanan.setText("Makanan");
        btn_makanan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_makanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_makananMousePressed(evt);
            }
        });
        add(btn_makanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 80, 20));

        btn_minuman.setBackground(new java.awt.Color(255, 202, 73));
        btn_minuman.setForeground(new java.awt.Color(82, 82, 82));
        btn_minuman.setText("Minuman");
        btn_minuman.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_minuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_minumanMousePressed(evt);
            }
        });
        add(btn_minuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 80, 20));

        btn_bayar.setBackground(new java.awt.Color(73, 255, 90));
        btn_bayar.setForeground(new java.awt.Color(255, 255, 255));
        btn_bayar.setText("Bayar");
        btn_bayar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });
        add(btn_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 90, 30));

        btn_add.setBackground(new java.awt.Color(82, 82, 82));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("ADD");
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 80, 30));

        btn_cetak.setBackground(new java.awt.Color(102, 102, 255));
        btn_cetak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak.setText("Cetak Struk");
        btn_cetak.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 90, 30));
        add(pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 190, 30));

        total_pembayaran.setBackground(new java.awt.Color(153, 255, 153));
        add(total_pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 190, 40));

        panelTransisi.setLayout(new javax.swing.BoxLayout(panelTransisi, javax.swing.BoxLayout.LINE_AXIS));
        add(panelTransisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 570, 220));
        add(total_ketersediaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 30, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 90, 310, 160));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageForm/StaffTransaksi.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_makananMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makananMousePressed
        fmakanan.setVisible(true);
        fminuman.setVisible(false);
    }//GEN-LAST:event_btn_makananMousePressed

    private void btn_minumanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minumanMousePressed
        fminuman.setVisible(true);
        fmakanan.setVisible(false);
    }//GEN-LAST:event_btn_minumanMousePressed

    private void jumlah_kurangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlah_kurangKeyReleased
        // TODO add your handling code here:
        int jumlahjual,jumlahstok;
        jumlahjual = Integer.parseInt(jumlah_kurang.getText());
        jumlahstok = Integer.parseInt(total_ketersediaan.getText());
        try {
            if(jumlahstok < jumlahjual){
                JOptionPane.showMessageDialog(this, "Maaf Stok Menu Tidak Mencukupi! " +jumlahstok);
                jumlah_kurang.setText("");
                total_pembayaran.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "kesalahan");
        }
        // menghitung total pembayaran
        // menghitung total per produk dalam array
        try {
            int total = harga_makan * Integer.parseInt(jumlah_kurang.getText());
            list.add(Integer.toString(total));
            jumlah = 0;
            //menghitung total pembayaran
            for (int i = 0; i < list.size(); i++) {
                jumlah = jumlah + Integer.parseInt(list.get(i));
            }
            total_pembayaran.setText(Integer.toString(jumlah));
        } catch (NumberFormatException ex) {
            jumlah_kurang.setText(null);
        }
    }//GEN-LAST:event_jumlah_kurangKeyReleased

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        getAdd();
        makanan.setSelectedItem("");
        kurang_stok.setText("");
        jumlah_kurang.setText("");
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        // TODO add your handling code here:
        int harga = Integer.parseInt(pembayaran.getText());
        int bayar = Integer.parseInt(total_pembayaran.getText());
        try {
            if (harga < bayar) {
                JOptionPane.showMessageDialog(null, "uang anda kurang");
            } else if (harga == bayar) {
                doTransaction();
                JOptionPane.showMessageDialog(null, "Terimakasih");
            } else {
                doTransaction();
                JOptionPane.showMessageDialog(null, "Terimakasih, Kembalian anda adalah " + (harga - bayar) + " ");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void makananPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_makananPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        getMenu();
    }//GEN-LAST:event_makananPopupMenuWillBecomeInvisible

    private void jumlah_kurangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlah_kurangKeyPressed
        // TODO add your handling code here:
//        try {
//            int jumlahjual;
//            int stok, stokm1;
//            jumlahjual = Integer.parseInt(jumlah_kurang.getText());
//            stok = Integer.parseInt(stok1.getText());
//            stokm1 = Integer.parseInt(stok2.getText());
//            if (stok < jumlahjual) {
//                JOptionPane.showMessageDialog(this, "Jumlah Stok Anda Kurang");
//                jumlah_kurang.setText("");
//                total_pembayaran.setText("");
//            } else if (stokm1 < jumlahjual) {
//                JOptionPane.showMessageDialog(this, "Jumlah Stok Anda Kurang" + stokm1);
//                jumlah_kurang.setText("");
//                total_pembayaran.setText("");
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jumlah_kurangKeyPressed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        cs.setVisible(true);
    }//GEN-LAST:event_btn_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_add;
    private swing.Button btn_bayar;
    private swing.Button btn_cetak;
    private swing.Button btn_makanan;
    private swing.Button btn_minuman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static final javax.swing.JTextField jumlah_kurang = new javax.swing.JTextField();
    private javax.swing.JTextField kurang_stok;
    private javax.swing.JComboBox<String> makanan;
    private javax.swing.JTextField nama_pelanggan;
    private javax.swing.JPanel panelCetakStruk;
    private javax.swing.JPanel panelTransisi;
    public static final javax.swing.JTextField pembayaran = new javax.swing.JTextField();
    private customtable.CustomTable table;
    private javax.swing.JTextField total_ketersediaan;
    private javax.swing.JTextField total_pembayaran;
    // End of variables declaration//GEN-END:variables

    private void inisialisasi_tabel() {
        table.setModel(tableModel);
    }

    private void getAdd() {
        try {
            String nama = makanan.getSelectedItem().toString();
            String jmlh = jumlah_kurang.getText();
            tableModel.addRow(new Object[]{nama, jmlh});
            inisialisasi_tabel();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}

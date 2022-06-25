/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import transisi.TransisiForm;

/**
 *
 * @author KRISNA
 */
public class FormStaffDashboard extends TransisiForm {

    Connection conn;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form formStaffDashboard
     */
    public FormStaffDashboard() throws SQLException {
        initComponents();
        initCount();
    }

    public void initCount() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mbaknis", "root", "");
            String sql = "SELECT nama_produk,COUNT(jumlah_beli) FROM detail_transaksi WHERE id_detail_transaksi";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel3.setText(rs.getString(1));
            }

            sql = "select count(*) from stok_menu";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel5.setText(rs.getString(1));
            }

            sql = "select sum(pembayaran) from transaksi";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel7.setText("Rp" + rs.getString(1));
            }
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameShow.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        nameShow.setForeground(new java.awt.Color(255, 255, 255));
        add(nameShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 120, 40));

        roleShow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roleShow.setForeground(new java.awt.Color(255, 255, 255));
        add(roleShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 90, 120, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Penjualan Terlaris :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 240, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Menu :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 190, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Pendapatan :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 240, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageForm/DasboardStaff.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static final javax.swing.JLabel nameShow = new javax.swing.JLabel();
    public static final javax.swing.JLabel roleShow = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormTransaction;

//import formStaff.FormStaffTransaction;
import static formStaff.FormStaffTransaction.jumlah_kurang;
import static formStaff.FormStaffTransaction.pembayaran;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author KRISNA
 */
public class FormMakanan extends javax.swing.JPanel {

    Connection conn;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form FormMakanan
     */
    public FormMakanan() throws SQLException {
        initComponents();
        initCount();
    }

    public void initCount() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mbaknis", "root", "");
            String sql = "SELECT nama_menu FROM stok_menu WHERE id_menu = 1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel2.setText(rs.getString(1));
            }

            sql = "SELECT jumlah_menu FROM stok_menu WHERE id_menu = 1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stok1.setText(rs.getString(1));
            }

            sql = "SELECT nama_menu FROM stok_menu WHERE id_menu = 2";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel4.setText(rs.getString(1));
            }

            sql = "SELECT jumlah_menu FROM stok_menu WHERE id_menu = 2";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stok2.setText(rs.getString(1));
            }

            sql = "SELECT nama_menu FROM stok_menu WHERE id_menu = 3";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel6.setText(rs.getString(1));
            }

            sql = "SELECT jumlah_menu FROM stok_menu WHERE id_menu = 3";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stok3.setText(rs.getString(1));
            }

            sql = "SELECT nama_menu FROM stok_menu WHERE id_menu = 4";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel8.setText(rs.getString(1));
            }

            sql = "SELECT jumlah_menu FROM stok_menu WHERE id_menu = 4";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stok4.setText(rs.getString(1));
            }

            sql = "SELECT nama_menu FROM stok_menu WHERE id_menu = 5";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel10.setText(rs.getString(1));
            }

            sql = "SELECT jumlah_menu FROM stok_menu WHERE id_menu = 5";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stok5.setText(rs.getString(1));
            }

            sql = "SELECT nama_menu FROM stok_menu WHERE id_menu = 6";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel12.setText(rs.getString(1));
            }

            sql = "SELECT jumlah_menu FROM stok_menu WHERE id_menu = 6";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stok6.setText(rs.getString(1));
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 80, 40));

        stok1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stok1KeyReleased(evt);
            }
        });
        add(stok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 80, -1));
        add(stok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 80, -1));
        add(stok3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 80, -1));
        add(stok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 80, -1));
        add(stok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 150, 90, -1));
        add(stok6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setText("jLabel2");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 80, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setText("jLabel2");
        jLabel6.setToolTipText("");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 80, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setText("jLabel2");
        jLabel8.setToolTipText("");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 80, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel10.setText("jLabel2");
        jLabel10.setToolTipText("");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 80, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel12.setText("jLabel2");
        jLabel12.setToolTipText("");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageForm/FormMakanan.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void stok1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stok1KeyReleased
        // TODO add your handling code here:
//        Integer jmljual, stok, hrgjual;
       int stok = Integer.parseInt(stok1.getText());
       int jmljual = Integer.parseInt(jumlah_kurang.getText());
       int hrgjual = Integer.parseInt(pembayaran.getText());
        if (stok  < jmljual) {
            JOptionPane.showMessageDialog(this, "Maaf, Stok tidak mencukupi");
        }else {
            System.out.println("ok");
                    
        }
    }//GEN-LAST:event_stok1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public static final javax.swing.JTextField stok1 = new javax.swing.JTextField();
    public static final javax.swing.JTextField stok2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField stok3 = new javax.swing.JTextField();
    public static final javax.swing.JTextField stok4 = new javax.swing.JTextField();
    public static final javax.swing.JTextField stok5 = new javax.swing.JTextField();
    public static final javax.swing.JTextField stok6 = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
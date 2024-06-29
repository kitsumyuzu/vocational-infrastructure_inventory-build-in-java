package inventaris_sarpra_smk.peminjaman;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import inventaris_sarpra_smk.db_connection;
import java.awt.Window;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import jnafilechooser.api.JnaFileChooser;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class pengembalian extends javax.swing.JDialog {

    public pengembalian(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        date.setText(dateFormat.format(cal.getTime()));

        load_table();
        load_table2();

    }

    private void load_table() {

        DefaultTableModel model = new DefaultTableModel();

            model.addColumn("#");
            model.addColumn("Barang");
            model.addColumn("Jumlah");
            model.addColumn("Tgl Peminjaman");
            model.addColumn("Status");
            model.addColumn("Peminjam");

        try {

            String sql = "SELECT detail_pinjam.id_detail_pinjam, inventaris.nama, detail_pinjam.jumlah_peminjaman, peminjam.tanggal_pinjam, peminjam.status_peminjaman, petugas.nama_petugas FROM detail_pinjam JOIN inventaris ON detail_pinjam.id_inventaris = inventaris.id_inventaris JOIN peminjam ON detail_pinjam.id_peminjam = peminjam.id_peminjam JOIN petugas ON inventaris.id_petugas = petugas.id_petugas WHERE peminjam.status_peminjaman = 'dipinjam'";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[] {

                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),

                });

            }

            table.setModel(model);
            

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    private void load_table2() {

        DefaultTableModel model = new DefaultTableModel();

            model.addColumn("#");
            model.addColumn("Barang");
            model.addColumn("Jumlah");
            model.addColumn("Tgl Peminjaman");
            model.addColumn("Status");
            model.addColumn("Peminjam");

        try {

            String sql = "SELECT detail_pinjam.id_detail_pinjam, inventaris.nama, detail_pinjam.jumlah_peminjaman, peminjam.tanggal_pinjam, peminjam.status_peminjaman, petugas.nama_petugas FROM detail_pinjam JOIN inventaris ON detail_pinjam.id_inventaris = inventaris.id_inventaris JOIN peminjam ON detail_pinjam.id_peminjam = peminjam.id_peminjam JOIN petugas ON inventaris.id_petugas = petugas.id_petugas WHERE peminjam.status_peminjaman = 'dikembalikan'";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[] {

                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),

                });

            }

            table2.setModel(model);

            String count_data = String.valueOf(table.getRowCount());
            total_data.setText("Total data : " + count_data);
            

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    public void load_table_view() {

        int row = table.getSelectedRow();
        String row_id = (table.getModel().getValueAt(row, 0).toString());

        id_pengembalian.setText(row_id);

    }

    private void exportToExcel(JTable table, String filePath) {
        
        try {

            TableModel model = table2.getModel();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Data");

            //  Membuat header kolom

                Row headerRow = sheet.createRow(0);

                for (int i = 0; i < model.getColumnCount(); i++) {

                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(model.getColumnName(i));

                }

            // Membuat data baris

                for (int i = 0; i < model.getRowCount(); i++) {

                    Row row = sheet.createRow(i + 1);

                    for (int j = 0; j < model.getColumnCount(); j++) {

                        Cell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());

                    }

                }

                // Menyimpan file Excel

                FileOutputStream fileOut = new FileOutputStream(new File(filePath));
                workbook.write(fileOut);
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Data berhasil di ekspor ke dalam file Excel");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengekspor ke Excel: " + e.getMessage());

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

        content = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        total_data = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        data = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_reload = new javax.swing.JButton();
        id_pengembalian = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_reload2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        content.setBackground(new java.awt.Color(31, 40, 62));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATA PENGEMBALIAN");

        total_data.setForeground(new java.awt.Color(153, 153, 153));
        total_data.setText("Total data : 0");

        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date.setText("Date.now();");

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table2);

        jButton1.setText("Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total_data)
                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(23, 23, 23))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        data.setBackground(new java.awt.Color(60, 60, 60));
        data.setMinimumSize(new java.awt.Dimension(100, 130));
        data.setPreferredSize(new java.awt.Dimension(850, 230));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Barang", "Jumlah", "Tgl Peminjaman", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btn_reload.setBackground(new java.awt.Color(60, 60, 60));
        btn_reload.setForeground(new java.awt.Color(255, 255, 255));
        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        id_pengembalian.setEditable(false);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID");

        btn_save.setBackground(new java.awt.Color(92, 184, 92));
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Change");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_reload2.setText("Reload 2");
        btn_reload2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reload2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataLayout = new javax.swing.GroupLayout(data);
        data.setLayout(dataLayout);
        dataLayout.setHorizontalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dataLayout.createSequentialGroup()
                        .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(dataLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_reload2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataLayout.setVerticalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataLayout.createSequentialGroup()
                        .addComponent(btn_reload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_reload2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(data, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        load_table_view();

    }//GEN-LAST:event_tableMouseClicked

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:

        load_table_view();

    }//GEN-LAST:event_tableMousePressed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        // TODO add your handling code here:

        load_table_view();

    }//GEN-LAST:event_tableMouseReleased

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        // TODO add your handling code here:

        load_table();

    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:

        String row_id = id_pengembalian.getText();

        if (!"0".equals(row_id)) {

            try {

                String sql = "UPDATE peminjam SET tanggal_kembali = '"+ date.getText() +"', status_peminjaman = 'dikembalikan' WHERE id_peminjam = '"+ row_id +"'";
    
                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.PreparedStatement pst = con.prepareStatement(sql);
                pst.execute();
    
                JOptionPane.showMessageDialog(null, "Berhasil mengubah Data pada Database!");
    
            } catch (Exception e) {
    
                JOptionPane.showMessageDialog(this, e.getMessage());
    
            }
    
            load_table();

        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_reload2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reload2ActionPerformed
        
        load_table2();
        
    }//GEN-LAST:event_btn_reload2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JnaFileChooser filechooser = new JnaFileChooser();
        Window window = null;
        boolean action = filechooser.showOpenDialog(window);
        
        if (action) {
            
            String fileString = filechooser.getSelectedFile() + " .xlsx";
            exportToExcel(table, fileString);
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try {
            
            String path =  "src/inventaris_sarpra_smk/report/pengembalian.jasper";
            java.sql.Connection con = (Connection) db_connection.configDB();

            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(path, parameters, con);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
            
            this.dispose();
            
        } catch (Exception e) {
            
            System.out.println("Error occured: " + e.getMessage());
            
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pengembalian dialog = new pengembalian(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_reload2;
    private javax.swing.JButton btn_save;
    private javax.swing.JPanel content;
    private javax.swing.JPanel data;
    private javax.swing.JLabel date;
    private javax.swing.JTextField id_pengembalian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JLabel total_data;
    // End of variables declaration//GEN-END:variables
}

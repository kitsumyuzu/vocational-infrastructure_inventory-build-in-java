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


public class peminjaman extends javax.swing.JDialog {
    
    public peminjaman(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        date.setText(dateFormat.format(cal.getTime()));

        setIconImage();
        SelectItems();
        SelectPengguna();
        load_table();
        clear();

        // Disabled button

            btn_enabled(false);
            btn_save.setText("Save");

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

            String count_data = String.valueOf(table.getRowCount());
            total_data.setText("Total data : " + count_data);
            

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    public void load_table_view() {

        int row = table.getSelectedRow();
        String row_id = (table.getModel().getValueAt(row, 0).toString());

        id_peminjaman.setText(row_id);

        btn_enabled(true);

    }

    private void btn_enabled(boolean x) {

        btn_update.setEnabled(x);
        btn_delete.setEnabled(x);

    }

    private void clear() {

        items_selection.setSelectedItem("-- Items --");
        total_input.setText("0");
        pengguna_selection.setSelectedItem("-- Pengguna --");

        id_peminjaman.setText(null);

    }

    private void SelectItems() {

        try {

            String sql = "SELECT * FROM inventaris";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                items_selection.addItem("-- Items --");

                while (res.next()) {

                    items_selection.addItem(res.getString("id_inventaris"));

                }

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    private void SelectPengguna() {

        try {

            String sql = "SELECT * FROM petugas";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                pengguna_selection.addItem("-- Pengguna --");

                while (res.next()) {

                    pengguna_selection.addItem(res.getString("id_petugas"));

                }

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    private void exportToExcel(JTable table, String filePath) {
        
        try {

            TableModel model = table.getModel();
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
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_insert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        total_input = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        total_data = new javax.swing.JLabel();
        form_title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pengguna_selection = new javax.swing.JComboBox();
        items_selection = new javax.swing.JComboBox();
        date = new javax.swing.JLabel();
        Excel = new javax.swing.JButton();
        pdf = new javax.swing.JButton();
        data = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_reload = new javax.swing.JButton();
        id_peminjaman = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Peminjaman");

        content.setBackground(new java.awt.Color(31, 40, 62));

        btn_delete.setBackground(new java.awt.Color(60, 60, 60));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(60, 60, 60));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_insert.setBackground(new java.awt.Color(60, 60, 60));
        btn_insert.setForeground(new java.awt.Color(255, 255, 255));
        btn_insert.setText("Add New");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Items");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total");

        total_input.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATA PEMINJAMAN");

        total_data.setForeground(new java.awt.Color(153, 153, 153));
        total_data.setText("Total data : 0");

        form_title.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        form_title.setForeground(new java.awt.Color(153, 153, 153));
        form_title.setText("Inserting data");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pengguna");

        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date.setText("Date.now();");

        Excel.setText("Excel");
        Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelActionPerformed(evt);
            }
        });

        pdf.setText("PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(Excel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pdf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pengguna_selection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(total_input, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(items_selection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(233, 233, 233)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(form_title, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(total_data)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))))))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(items_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pengguna_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(total_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date)))
                .addGap(118, 118, 118)
                .addComponent(form_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_update)
                    .addComponent(btn_insert)
                    .addComponent(Excel)
                    .addComponent(pdf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        id_peminjaman.setEditable(false);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID");

        btn_cancel.setBackground(new java.awt.Color(217, 83, 79));
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(92, 184, 92));
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
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
                    .addGroup(dataLayout.createSequentialGroup()
                        .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(dataLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86)
                        .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(data, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelActionPerformed
        // TODO add your handling code here:

        JnaFileChooser filechooser = new JnaFileChooser();
        Window window = null;
        boolean action = filechooser.showOpenDialog(window);
        
        if (action) {
            
            String fileString = filechooser.getSelectedFile() + " .xlsx";
            exportToExcel(table, fileString);
            
        }
        
    }//GEN-LAST:event_ExcelActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        // TODO add your handling code here:
        
        try {
            
            String path =  "src/inventaris_sarpra_smk/report/peminjaman.jasper";
            java.sql.Connection con = (Connection) db_connection.configDB();

            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(path, parameters, con);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
            
            this.dispose();
            
        } catch (Exception e) {
            
            System.out.println("Error occured: " + e.getMessage());
            
        }
        
    }//GEN-LAST:event_pdfActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {

        int valid = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this data?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        
        if (valid == 0) {

            try {

                String row_id = id_peminjaman.getText();
                String sql = "DELETE FROM peminjam WHERE id_peminjam = '"+ row_id + "'";

                    java.sql.Connection con = (Connection) db_connection.configDB();
                    java.sql.Statement stm = con.createStatement();
                    stm.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null, "Data has confirmed being deleted.");
                    btn_insert.doClick();

                    load_table();

            } catch (Exception e) {

                System.out.println("Error occured: " + e.getMessage());

            }

        }
        
    }

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {

        String row_id = id_peminjaman.getText();

        if (!"0".equals(row_id)) {

            try {

                String sql = "SELECT detail_pinjam.id_detail_pinjam, inventaris.id_inventaris as nama, detail_pinjam.jumlah_peminjaman, peminjam.tanggal_pinjam, peminjam.status_peminjaman, petugas.id_petugas as pengguna FROM detail_pinjam JOIN inventaris ON detail_pinjam.id_inventaris = inventaris.id_inventaris JOIN peminjam ON detail_pinjam.id_peminjam = peminjam.id_peminjam JOIN petugas ON peminjam.id_petugas";

                    java.sql.Connection con = (Connection) db_connection.configDB();
                    java.sql.Statement stm = con.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sql);

                if (res.next()) {

                    String codes = res.getString("nama");

                    form_title.setText("Updating data - " + codes);

                    id_peminjaman.setText(res.getString("id_detail_pinjam"));
                    items_selection.setSelectedItem(codes);
                    total_input.setText(res.getString("jumlah_peminjaman"));
                    pengguna_selection.setSelectedItem(res.getString("pengguna"));
                    
                    items_selection.requestFocus();

                }
                
            } catch (Exception e) {

                System.out.println("An error found: " + e.getMessage());

            }

        }
        
    }

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {

        form_title.setText("Inserting data");

        table.clearSelection();
        clear();

        btn_enabled(false);

        btn_save.setText("Save");
        items_selection.requestFocus();
        
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {

        load_table_view();

    }

    private void tableMousePressed(java.awt.event.MouseEvent evt) {

        load_table_view();

    }

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {

        load_table_view();

    }

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {

        load_table();

    }

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {

        btn_insert.doClick();

    }

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {

        Object SelectedItems = items_selection.getSelectedItem();
        Object SelectedPengguna = pengguna_selection.getSelectedItem();

        String row_id = id_peminjaman.getText();
        String row_items = SelectedItems.toString();
        String row_total = total_input.getText();
        String row_pengguna = SelectedPengguna.toString();
        String row_date = date.getText();

            int code = 0;

            if (!"-- Items --".equals(row_items) && !"".equals(row_total) && !"-- Pengguna --".equals(row_pengguna)) {

                try {

                    String sql = "SELECT COUNT(detail_pinjam.id_detail_pinjam) as count FROM detail_pinjam WHERE inventaris.id_inventaris = '"+ row_items +"'";

                        java.sql.Connection con = (Connection) db_connection.configDB();
                        java.sql.Statement stm = con.createStatement();
                        java.sql.ResultSet res = stm.executeQuery(sql);

                        res.next();

                        code = res.getInt("count");
                    
                } catch (Exception e) {
                    
                    System.out.println("An error found: " + e.getMessage());

                }

                if ("".equals(row_id)) {

                    if (code == 0) {

                        try {
                            
                            String sql1 = "INSERT INTO peminjam(tanggal_pinjam, id_petugas) VALUES ('"+ row_date +"', '"+ row_pengguna +"')";

                            java.sql.Connection con = (Connection) db_connection.configDB();
                            java.sql.Statement stm = con.createStatement();
                            stm.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);

                            ResultSet generatedKeys = stm.getGeneratedKeys();
                            int idPeminjam = -1;

                            if (generatedKeys.next()) {

                                idPeminjam = generatedKeys.getInt(1);

                            }
                            
                            if (idPeminjam != -1) {

                                String sql2 = "INSERT INTO detail_pinjam(id_inventaris, jumlah_peminjaman, id_peminjam) VALUES ('"+ row_items +"', '"+ row_total +"', '"+ idPeminjam +"')";
                                stm.executeUpdate(sql2);

                                JOptionPane.showMessageDialog(null, "Successfully added new data.");

                                btn_insert.doClick();
                                load_table();

                            }

                        } catch (Exception e) {

                            System.out.println("Error occurred: " + e.getMessage());

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "This username have ever been stored before.", "Failed to attempt", JOptionPane.ERROR_MESSAGE);

                    }

                } else {

                    if (code == 0 || row_id.equals(row_id)) {

                        try {

                            String sql1 = "UPDATE peminjam SET tanggal_pinjam='" + row_date + "', id_petugas='" + row_pengguna + "' WHERE id_peminjam = '" + row_id + "'";
                    
                            java.sql.Connection con = (Connection) db_connection.configDB();
                            java.sql.Statement stm = con.createStatement();

                            int rowsAffected1 = stm.executeUpdate(sql1);
                    
                            if (rowsAffected1 > 0) {

                                String sql2 = "UPDATE detail_pinjam SET id_inventaris='" + row_items + "', jumlah_peminjaman='" + row_total + "' WHERE id_peminjam = '" + row_id + "'";

                                int rowsAffected2 = stm.executeUpdate(sql2);
                    
                                if (rowsAffected2 > 0) {

                                    JOptionPane.showMessageDialog(null, "Successfully updated data.");

                                    btn_insert.doClick();
                                    load_table();

                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "Failed to update data.", "Error", JOptionPane.ERROR_MESSAGE);

                            }

                        } catch (Exception e) {

                            System.out.println("Error occurred: " + e.getMessage());

                        }

                    }

                }

            } else {

                JOptionPane.showMessageDialog(null, "There was empty field!");
                
            }

    }

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
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                peminjaman dialog = new peminjaman(new javax.swing.JFrame(), true);
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

    void setIconImage() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/favicon.png")));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excel;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JPanel content;
    private javax.swing.JPanel data;
    private javax.swing.JLabel date;
    private javax.swing.JLabel form_title;
    private javax.swing.JTextField id_peminjaman;
    private javax.swing.JComboBox items_selection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pdf;
    private javax.swing.JComboBox pengguna_selection;
    private javax.swing.JTable table;
    private javax.swing.JLabel total_data;
    private javax.swing.JTextField total_input;
    // End of variables declaration//GEN-END:variables
}

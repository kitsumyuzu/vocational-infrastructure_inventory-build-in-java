package inventaris_sarpra_smk.inventaris;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import inventaris_sarpra_smk.db_connection;


public class inventaris extends javax.swing.JDialog {

    public inventaris(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        registered_date.setText(dateFormat.format(cal.getTime()));

        setIconImage();
        SelectConditions();
        SelectType();
        SelectRooms();
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
            model.addColumn("Kondisi");
            model.addColumn("Keterangan");
            model.addColumn("Jumlah");
            model.addColumn("Jenis");
            model.addColumn("Tanggal");
            model.addColumn("Ruang");
            model.addColumn("Kode");
            model.addColumn("Pegawai");

        try {

            String sql = "SELECT inventaris.id_inventaris, inventaris.nama, inventaris.kondisi, inventaris.keterangan_inventaris, inventaris.jumlah, jenis.nama_jenis as jenis, inventaris.tanggal_register, ruang.nama_ruang as ruang, inventaris.kode_inventaris, petugas.nama_petugas FROM inventaris JOIN jenis ON inventaris.id_jenis = jenis.id_jenis JOIN ruang ON inventaris.id_ruang = ruang.id_ruang JOIN petugas ON inventaris.id_petugas = petugas.id_petugas";

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
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),

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

        id_inventaris.setText(row_id);

        btn_enabled(true);

    }

    private void btn_enabled(boolean x) {

        btn_update.setEnabled(x);
        btn_delete.setEnabled(x);

    }

    private void clear() {

        items_input.setText(null);
        condition_selection.setSelectedItem("-- Conditions --");
        description_input.setText(null);
        total_input.setText("0");
        type_selection.setSelectedItem("-- Type --");
        rooms_selection.setSelectedItem("-- Rooms --");
        code_input.setText(null);
        pengguna_selection.setSelectedItem("-- Pengguna --");

        id_inventaris.setText(null);

    }

    private void SelectConditions() {

        try {

            condition_selection.addItem("-- Conditions --");
            condition_selection.addItem("baik");
            condition_selection.addItem("buruk");

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    private void SelectType() {

        try {

            String sql = "SELECT * FROM jenis";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                type_selection.addItem("-- Type --");

                while (res.next()) {

                    type_selection.addItem(res.getString("id_jenis"));

                }

        } catch (Exception e) {

            System.out.println("An error found: " + e.getMessage());

        }

    }

    private void SelectRooms() {

        try {

            String sql = "SELECT * FROM ruang";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                rooms_selection.addItem("-- Rooms --");

                while (res.next()) {

                    rooms_selection.addItem(res.getString("id_ruang"));

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
        items_input = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total_data = new javax.swing.JLabel();
        form_title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        description_input = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        total_input = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        type_selection = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        registered_date = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rooms_selection = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        code_input = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pengguna_selection = new javax.swing.JComboBox();
        condition_selection = new javax.swing.JComboBox();
        data = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_reload = new javax.swing.JButton();
        id_inventaris = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventaris");

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

        items_input.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Conditions");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATA INVENTARIS");

        total_data.setForeground(new java.awt.Color(153, 153, 153));
        total_data.setText("Total data : 0");

        form_title.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        form_title.setForeground(new java.awt.Color(153, 153, 153));
        form_title.setText("Inserting data");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description");

        description_input.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total");

        total_input.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Type");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registered");

        registered_date.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rooms");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Code");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pengguna");

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(description_input, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(items_input)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(total_input)
                    .addComponent(condition_selection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(type_selection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registered_date)
                        .addComponent(rooms_selection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(code_input, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(0, 131, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(total_data))
                        .addGap(23, 23, 23))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(pengguna_selection, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form_title, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(items_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total_data))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(condition_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(description_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pengguna_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registered_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rooms_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(code_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(form_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_update)
                    .addComponent(btn_insert))
                .addContainerGap())
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        data.setBackground(new java.awt.Color(60, 60, 60));
        data.setMinimumSize(new java.awt.Dimension(100, 130));
        data.setPreferredSize(new java.awt.Dimension(850, 230));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Barang", "Kondisi", "Keterangan", "Jumlah", "Jenis", "Tanggal", "Ruang", "Kode", "Petugas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
        }

        btn_reload.setBackground(new java.awt.Color(60, 60, 60));
        btn_reload.setForeground(new java.awt.Color(255, 255, 255));
        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        id_inventaris.setEditable(false);

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
                                .addComponent(id_inventaris, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
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
                            .addComponent(id_inventaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(data, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {

        form_title.setText("Inserting data");

        table.clearSelection();
        clear();

        btn_enabled(false);

        btn_save.setText("Save");
        items_input.requestFocus();

    }

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {

        String row_id = id_inventaris.getText();

        if (!"0".equals(row_id)) {

            try {

                String sql = "SELECT inventaris.id_inventaris, inventaris.nama, inventaris.kondisi, inventaris.keterangan_inventaris, inventaris.jumlah, jenis.id_jenis as jenis, inventaris.tanggal_register, ruang.id_ruang as ruang, inventaris.kode_inventaris, petugas.id_petugas as petugas FROM inventaris JOIN jenis ON inventaris.id_jenis = jenis.id_jenis JOIN ruang ON inventaris.id_ruang = ruang.id_ruang JOIN petugas ON inventaris.id_petugas = petugas.id_petugas WHERE inventaris.id_inventaris ='"+ row_id +"'";

                    java.sql.Connection con = (Connection) db_connection.configDB();
                    java.sql.Statement stm = con.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sql);

                if (res.next()) {

                    String codes = res.getString("kode_inventaris");

                    form_title.setText("Updating data - " + codes);

                    id_inventaris.setText(res.getString("id_inventaris"));
                    items_input.setText(res.getString("nama"));
                    condition_selection.setSelectedItem(res.getString("kondisi"));
                    description_input.setText(res.getString("keterangan_inventaris"));
                    total_input.setText(res.getString("jumlah"));
                    type_selection.setSelectedItem(res.getString("jenis"));
                    registered_date.setText(res.getString("tanggal_register"));
                    rooms_selection.setSelectedItem(res.getString("ruang"));
                    code_input.setText(codes);
                    pengguna_selection.setSelectedItem(res.getString("petugas"));

                    items_input.requestFocus();

                }
                
            } catch (Exception e) {

                System.out.println("An error found: " + e.getMessage());

            }

        }

    }

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {

        int valid = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this data?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        
        if (valid == 0) {

            try {

                String row_id = id_inventaris.getText();
                String sql = "DELETE FROM inventaris WHERE id_inventaris = '"+ row_id + "'";

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

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {

        Object SelectedConditions = condition_selection.getSelectedItem();
        Object SelectedType = type_selection.getSelectedItem();
        Object SelectedRooms = rooms_selection.getSelectedItem();
        Object SelectedPengguna = pengguna_selection.getSelectedItem();

        String row_id = id_inventaris.getText();
        String row_items = items_input.getText();
        String row_conditions = SelectedConditions.toString();
        String row_description = description_input.getText();
        String row_total = total_input.getText();

        String row_Type = SelectedType.toString();
        String row_registered = registered_date.getText();
        String row_rooms = SelectedRooms.toString();
        String row_code = code_input.getText();

        String row_pengguna = SelectedPengguna.toString();

            int code = 0;

            if (!"".equals(row_items) && !"".equals(row_items) && !"-- Conditions --".equals(row_conditions) && !"".equals(row_total) && !"-- Type --".equals(row_Type) && !"".equals(row_registered) && !"-- Rooms --".equals(row_rooms) && !"".equals(row_code) && !"-- Pengguna --".equals(row_pengguna)) {
                
                try {

                    String sql = "SELECT COUNT(inventaris.id_inventaris) as count FROM inventaris WHERE inventaris.kode_inventaris = '"+ row_code +"'";

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

                            String sql = "INSERT INTO inventaris(nama, kondisi, keterangan_inventaris, jumlah, id_jenis, tanggal_register, id_ruang, kode_inventaris, id_petugas) VALUES ('"+ row_items +"', '"+ row_conditions +"', '"+ row_description +"', '"+ row_total +"', '"+ row_Type +"', '"+ row_registered +"', '"+ row_rooms +"', '"+ row_code +"', '"+ row_pengguna +"')";

                                java.sql.Connection con = (Connection) db_connection.configDB();
                                java.sql.Statement stm = con.createStatement();
                                stm.executeUpdate(sql);

                            JOptionPane.showMessageDialog(null, "Successfully added new data.");

                            btn_insert.doClick();
                            load_table();

                        } catch (Exception e) {

                            System.out.println("Error occured: " + e.getMessage());

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "This username have ever been stored before.", "Failed to attempt", JOptionPane.ERROR_MESSAGE);

                    }

                } else {

                    if (code == 0 || row_id.equals(row_id)) {

                        try {

                            String sql = "UPDATE inventaris SET nama='"+ row_items +"', kondisi='"+ row_conditions +"', keterangan_inventaris='"+ row_description +"', jumlah='"+ row_total +"', id_jenis='"+ row_Type +"', tanggal_register='"+ row_registered +"', id_ruang='"+ row_rooms +"', kode_inventaris='"+ row_code +"', id_petugas='"+ pengguna_selection +"' WHERE id_inventaris = '"+ row_id +"'";

                                java.sql.Connection con = (Connection) db_connection.configDB();
                                java.sql.Statement stm = con.createStatement();
                                stm.executeUpdate(sql);

                            JOptionPane.showMessageDialog(null, "Successfully edited data.");

                            btn_insert.doClick();
                            load_table();

                        } catch (Exception e) {

                            System.out.println("Error occurred: " + e.getMessage());

                        }

                    }

                }

            } else {

                JOptionPane.showMessageDialog(null, "There was empty field!");
                
            }

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
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inventaris dialog = new inventaris(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField code_input;
    private javax.swing.JComboBox condition_selection;
    private javax.swing.JPanel content;
    private javax.swing.JPanel data;
    private javax.swing.JTextField description_input;
    private javax.swing.JLabel form_title;
    private javax.swing.JTextField id_inventaris;
    private javax.swing.JTextField items_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pengguna_selection;
    private javax.swing.JTextField registered_date;
    private javax.swing.JComboBox rooms_selection;
    private javax.swing.JTable table;
    private javax.swing.JLabel total_data;
    private javax.swing.JTextField total_input;
    private javax.swing.JComboBox type_selection;
    // End of variables declaration//GEN-END:variables
}

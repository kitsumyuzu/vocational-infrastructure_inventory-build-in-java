package inventaris_sarpra_smk.inventaris;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

import inventaris_sarpra_smk.db_connection;


public class jenis extends javax.swing.JDialog {

    public jenis(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        setIconImage();
        load_table();
        clear();

        // Disabled button

            btn_enabled(false);
            btn_save.setText("Save");

    }

    private void load_table() {

        DefaultTableModel model = new DefaultTableModel();

            model.addColumn("#");
            model.addColumn("Jenis");
            model.addColumn("Kode Jenis");
            model.addColumn("Keterangan");

        try {

            String sql = "SELECT * FROM jenis";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[] {

                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),

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

        id_jenis.setText(row_id);

        btn_enabled(true);

    }

    private void btn_enabled(boolean x) {

        btn_update.setEnabled(x);
        btn_delete.setEnabled(x);

    }

    private void clear() {

        type_input.setText(null);
        code_input.setText(null);
        description_input.setText(null);

        id_jenis.setText(null);

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
        type_input = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        code_input = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        total_data = new javax.swing.JLabel();
        form_title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        description_input = new javax.swing.JTextField();
        data = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_reload = new javax.swing.JButton();
        id_jenis = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jenis");

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
        jLabel1.setText("Type");

        type_input.setForeground(new java.awt.Color(0, 0, 0));
        type_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                type_inputKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Code");

        code_input.setForeground(new java.awt.Color(0, 0, 0));
        code_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code_inputKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATA JENIS");

        total_data.setForeground(new java.awt.Color(153, 153, 153));
        total_data.setText("Total data : 0");

        form_title.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        form_title.setForeground(new java.awt.Color(153, 153, 153));
        form_title.setText("Inserting data");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description");

        description_input.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(code_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(type_input, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(description_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addComponent(jLabel3))
                .addGap(233, 233, 233)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(0, 207, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(total_data))
                        .addGap(23, 23, 23))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(form_title, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    .addComponent(type_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(code_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(description_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(form_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_update)
                    .addComponent(btn_insert))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        data.setBackground(new java.awt.Color(60, 60, 60));
        data.setMinimumSize(new java.awt.Dimension(100, 130));
        data.setPreferredSize(new java.awt.Dimension(850, 230));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Jenis", "Kode Jenis", "Keterangan"
            }
        ));
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

        id_jenis.setEditable(false);

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
                                .addComponent(id_jenis, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
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
                            .addComponent(id_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(data, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {

        int valid = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this data?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

            if (valid == 0) {

                try {

                    String row_id = id_jenis.getText();
                    String sql = "DELETE FROM jenis WHERE id_jenis = '"+ row_id + "'";

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

        String row_id = id_jenis.getText();

        if (!"0".equals(row_id)) {

            try {

                String sql = "SELECT * FROM jenis WHERE jenis.id_jenis = '"+ row_id +"'";

                    java.sql.Connection con = (Connection) db_connection.configDB();
                    java.sql.Statement stm = con.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sql);

                if (res.next()) {

                    String codes = res.getString("kode_jenis");

                    form_title.setText("Updating data - " + codes);

                    id_jenis.setText(res.getString("id_jenis"));
                    type_input.setText(res.getString("nama_jenis"));
                    code_input.setText(codes);
                    description_input.setText(res.getString("keterangan"));

                    type_input.requestFocus();

                }
                
            } catch (Exception e) {

                System.out.println("An error found: " + e.getMessage());

            }

        }

    }

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {

        String row_id = id_jenis.getText();
        String row_Type = type_input.getText();
        String row_codeType = code_input.getText();
        String row_descType = description_input.getText();

        int code = 0;

            if (!"".equals(row_Type) && !"".equals(row_codeType) && !"".equals(row_descType)) {
                
                try {

                    String sql = "SELECT COUNT(jenis.id_jenis) as count FROM jenis WHERE jenis.kode_jenis = '"+ row_codeType +"'";

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

                            String sql = "INSERT INTO jenis(nama_jenis, kode_jenis, keterangan) VALUES ('"+ row_Type +"', '"+ row_codeType +"', '"+ row_descType +"')";

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

                        JOptionPane.showMessageDialog(null, "This Type have ever been stored before.", "Failed to attempt", JOptionPane.ERROR_MESSAGE);

                    }

                } else {

                    if (code == 0 || row_id.equals(row_id)) {

                        try {

                            String sql = "UPDATE jenis SET nama_jenis='"+ row_Type +"', kode_jenis='"+ row_codeType +"', keterangan='"+ row_descType +"' WHERE id_jenis = '"+ row_id +"'";

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

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {

        form_title.setText("Inserting data");

        table.clearSelection();
        clear();

        btn_enabled(false);

        btn_save.setText("Save");
        code_input.requestFocus();

    }

    private void type_inputKeyTyped(java.awt.event.KeyEvent evt) {

        char type = evt.getKeyChar();
        
        if (type == KeyEvent.VK_SPACE) {

            JOptionPane.showMessageDialog(null, "Oops! type may not contains space!", "Illegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();

        }

    }

    private void code_inputKeyTyped(java.awt.event.KeyEvent evt) {

        char type = evt.getKeyChar();
        
        if (type == KeyEvent.VK_SPACE) {

            JOptionPane.showMessageDialog(null, "Oops! code may not contains space!", "Illegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();

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
            java.util.logging.Logger.getLogger(jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jenis dialog = new jenis(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel content;
    private javax.swing.JPanel data;
    private javax.swing.JTextField description_input;
    private javax.swing.JLabel form_title;
    private javax.swing.JTextField id_jenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel total_data;
    private javax.swing.JTextField type_input;
    // End of variables declaration//GEN-END:variables
}

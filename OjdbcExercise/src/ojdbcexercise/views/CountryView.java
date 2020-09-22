/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcexercise.views;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ojdbcexercise.controllers.CountryController;
import ojdbcexercise.models.Country;

/**
 *
 * @author Laila
 */
public class CountryView extends javax.swing.JInternalFrame {

    private CountryController countryController;

    /**
     * Creates new form CountryView
     * load all the data in countries
     */
    public CountryView() {
        initComponents();
        this.countryController = new CountryController();
        loadData(countryController.getDataCountry());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCountry = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOutId = new javax.swing.JTextField();
        txtOutName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOutRegion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setText("jLabel4");

        setTitle("Form Country");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        tblCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCountryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCountry);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setToolTipText("Detail");
        jPanel2.setName("Detail"); // NOI18N

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        txtOutId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutIdActionPerformed(evt);
            }
        });

        txtOutName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Region");

        txtOutRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutRegionActionPerformed(evt);
            }
        });

        jLabel5.setText("Detail Country");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOutName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOutId, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtOutRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOutId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOutName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOutRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(5, 5, 5)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOutIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutIdActionPerformed

    private void txtOutNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutNameActionPerformed

    private void txtOutRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutRegionActionPerformed
   
    /**
     * This method is called when edit button pressed. Process all the input to
     * be edited such id, name and region. If you pressed this button, you will
     * get confirmation, whether you want to edit the file or cancel it. Your
     * edited data will showed in table tblCountry
     * after editing data, your input will be cleared with method clearFields
     * @param evt
     */
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to save this data?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        String id = txtOutId.getText();
        String name = txtOutName.getText();
        String region = txtOutRegion.getText();
        String msg = "Cancelled";

        if (confirm == 0) {
            msg = this.countryController.updateCountryController(id, name, region);
        }
        JOptionPane.showMessageDialog(this, msg);
        loadData(countryController.getDataCountry());
        clearFields();
    }//GEN-LAST:event_btnEditActionPerformed
    /**
     * This method is called when save button pressed. Process all the input to
     * be saved such id, name and region. If you pressed this button, you will
     * get confirmation, whether you want to save the file or cancel it. Your
     * saved data will be showed in table tblCountry
     * after saving data, your input will be cleared with method clearFields
     * @param evt
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to save this data?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        String id = txtOutId.getText();
        String name = txtOutName.getText();
        String region = txtOutRegion.getText();
        String msg = "Cancelled";

        if (confirm == 0) {
            msg = this.countryController.insertCountryController(id, name, region);
            JOptionPane.showMessageDialog(this, msg);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, msg);
        }

        loadData(countryController.getDataCountry());

    }//GEN-LAST:event_btnSaveActionPerformed
  /**
   * This method for clearing input in text field such txtId, txtName, and txtRegion, when button save, edit and delete clicked
   */
    private void clearFields() {
        txtOutId.setText(null);
        txtOutName.setText(null);
        txtOutRegion.setText(null);

    }
/**
   * This method for clearing input in txtSearch field , when button search clicked
   */
    private void clearSearchField() {
        txtSearch.setText(null);

    }

    /**
     * This method is called when delete button pressed. You only need to enter
     * the id of data that you want to be deleted. If you pressed this button,
     * you will get confirmation, whether you want to delete the file or cancel
     * it. Your data will be showed in table tblCountry that your data is deleted,
     * after deleting data, your input will be cleared with method clearFields
     * @param evt
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to delete this data?", "WARNING", JOptionPane.YES_NO_OPTION);
        String id = txtOutId.getText();
        String name = txtOutName.getText();
        String region = txtOutRegion.getText();
        String msg = "Cancelled";
        if (confirm == 0) {

            msg = this.countryController.deleteCountryController(id);
        }

        JOptionPane.showMessageDialog(this, msg, "WARNING", JOptionPane.ERROR_MESSAGE);
        loadData(countryController.getDataCountry());
        clearFields();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed
    /**
     * This method is called when search button pressed. Process all the input
     * you want to search, you can enter either id's data, name's data, or
     * region's data. If you pressed this button, you will get all the data that
     * matches your clue. Your data will be showed in table tblCountry.
     * After searching, your input will be cleared with method clearSearchField
     * @param evt
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = "%" + txtSearch.getText() + "%";
        loadData(countryController.findCountry(keyword));
        clearSearchField();
    }//GEN-LAST:event_btnSearchActionPerformed
    /**
     * This method is called when tblCountry is left clicked by mouse. If you pressed
     * this button, you will get the data from which row you chose. Your data
     * will be showed in text field of txtId, txtName, and txtRegion. By using or
     * calling this method, you wont need to enter id, name, and region's data
     * one by one to edit or delete it
     *
     * @param evt
     */
    private void tblCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCountryMouseClicked
        int row = tblCountry.getSelectedRow();
        String id = tblCountry.getValueAt(row, 0).toString();
        String name = tblCountry.getValueAt(row, 1).toString();
        String region = tblCountry.getValueAt(row, 2).toString();

        txtOutId.setText(id);
        txtOutName.setText(name);
        txtOutRegion.setText(region);
    }//GEN-LAST:event_tblCountryMouseClicked
    /**
     * This method is called when you are in search text field, and pressed
     * enter. Process all the input you want to search, you can enter either id's
     * data, name's data, or region's data. If you pressed this button, you will
     * get all the data that matches your clue. Your data will be showed in table
     * tblCountry,
     * after searching data, your input will be cleared with method clearFields
     * @param evt
     */
    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = "%" + txtSearch.getText() + "%";
            loadData(countryController.findCountry(keyword));
            clearSearchField();
        }
    }//GEN-LAST:event_txtSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblCountry;
    private javax.swing.JTextField txtOutId;
    private javax.swing.JTextField txtOutName;
    private javax.swing.JTextField txtOutRegion;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
/**
     * This method is called to show all the data in table countries, 
     * Shows data such id, name, and region in column 1, 2 and 3.
     * Uses table model to setup this method 
     * Your data will be showed in table tblCountry
     *
     * @param evt
     */
    private void loadData(List<Country> countrys) {
        String header[] = {"Id", "Name", "Region"};
        String[][] data = new String[countrys.size()][3];

//    String data[] = new String[countrys.size()][2];
        for (int i = 0; i < data.length; i++) {
//            String string = data[i];

            data[i][0] = countrys.get(i).getId();
            data[i][1] = countrys.get(i).getName();
            data[i][2] = countrys.get(i).getRegion() + "";

        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, header);
        tblCountry.setModel(defaultTableModel);
    }

}

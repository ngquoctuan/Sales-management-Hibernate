/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import BLL.ReceiptBLL;
import BLL.ImportBLL;
import BLL.StatisticsBLL;
import BLL.CustomersBLL;
import POJO.customers;
import POJO.orderdetail;
import POJO.orderproduct;
import POJO.vegetable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tantaiAdmin
 */
public class ReceiptDetail extends javax.swing.JFrame {
        ReceiptBLL hdBLL;
        ImportBLL nhaphangBLL;
        StatisticsBLL tkBLL;
        List<orderdetail>odlist;
        public float tongcong=0;
    /**
     * Creates new form HoaDonBanHangEdit
     */
    public ReceiptDetail(orderproduct op) {
        initComponents();
        hdBLL = new ReceiptBLL();
        nhaphangBLL = new ImportBLL();
        tkBLL = new StatisticsBLL();
        showcombobox();
        loadTableNhaphang();
        txt_orderID_Edit.setText(String.valueOf(op.getOrderID()));
        cb_cus_Edit.setSelectedItem(op.getCustomerID().getFullname());
        txt_date_Edit.setText(String.valueOf(op.getDate()));
        txt_total_Edit.setText(String.valueOf(op.getTotal()));
        txt_note_Edit.setText(op.getNote());
        tongcong = op.getTotal();
        loadtableDetail();
    }
    
    private ReceiptDetail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void loadtableDetail(){
        orderproduct op = hdBLL.getOrder(Integer.valueOf(txt_orderID_Edit.getText()));
        Set<orderdetail> odd = op.getOrderdetails();
        odlist = new ArrayList<orderdetail>();
        odlist.addAll(odd);
        Object[][] modelOBJ;
        modelOBJ = tkBLL.convertListvgName(odlist);
        String[] title = {"OrderID","VegetableName","Quantity","Price"};
        DefaultTableModel model = new DefaultTableModel(modelOBJ,title);
        tb_ordr_detail_Edit.setModel(model);
    }
    private void showcombobox(){
        CustomersBLL cusBLL= new CustomersBLL();
        cb_cus_Edit.removeAllItems();
        List<customers> list = cusBLL.loadCustomers();
        for (int i = 0; i < list.size(); i++) {
            cb_cus_Edit.addItem(list.get(i).getFullname());
        }
        txt_date_Edit.setText(String.valueOf(java.time.LocalDate.now()));
    }
     private void loadTableNhaphang(){
        List ls = nhaphangBLL.loadVegetable();
        Object[][] modelOBJ;
        modelOBJ = nhaphangBLL.convertList(ls);
        String[] title = {"VegetableID ","VegetableName","Unit","Amount","Image","Price"};
        DefaultTableModel model = new DefaultTableModel(modelOBJ,title);
        tb_sp_Edit.setModel(model);
    }
     public void Quaylai(){
        ReceiptReport jf= new ReceiptReport();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        this.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ordr_detail_Edit = new javax.swing.JTable();
        bt_del_detail_Edit = new javax.swing.JButton();
        txt_tk_sp_Edit = new javax.swing.JTextField();
        bt_find_sp_Edit = new javax.swing.JButton();
        bt_fresh_sp_Edit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sp_Edit = new javax.swing.JTable();
        btn_new_sp_Edit = new javax.swing.JButton();
        cb_cus_Edit = new javax.swing.JComboBox<>();
        txt_orderID_Edit = new javax.swing.JTextField();
        txt_date_Edit = new javax.swing.JTextField();
        txt_total_Edit = new javax.swing.JTextField();
        txt_note_Edit = new javax.swing.JTextField();
        btn_addneworder_Edit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2_Edit = new javax.swing.JLabel();
        jLabel3_Edit = new javax.swing.JLabel();
        jLabel1_Edit = new javax.swing.JLabel();
        back_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tb_ordr_detail_Edit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_ordr_detail_Edit);

        bt_del_detail_Edit.setBackground(new java.awt.Color(255, 153, 153));
        bt_del_detail_Edit.setText("Delete");
        bt_del_detail_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_del_detail_EditActionPerformed(evt);
            }
        });

        bt_find_sp_Edit.setBackground(new java.awt.Color(255, 204, 255));
        bt_find_sp_Edit.setText("Search");
        bt_find_sp_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_find_sp_EditActionPerformed(evt);
            }
        });

        bt_fresh_sp_Edit.setBackground(new java.awt.Color(204, 204, 255));
        bt_fresh_sp_Edit.setText("Refesh");
        bt_fresh_sp_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fresh_sp_EditActionPerformed(evt);
            }
        });

        tb_sp_Edit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(tb_sp_Edit);

        btn_new_sp_Edit.setBackground(new java.awt.Color(255, 153, 204));
        btn_new_sp_Edit.setText("Add");
        btn_new_sp_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_sp_EditActionPerformed(evt);
            }
        });

        txt_orderID_Edit.setEditable(false);

        txt_date_Edit.setEditable(false);

        txt_total_Edit.setEditable(false);

        btn_addneworder_Edit.setBackground(new java.awt.Color(255, 153, 204));
        btn_addneworder_Edit.setText("Save");
        btn_addneworder_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addneworder_EditActionPerformed(evt);
            }
        });

        jLabel6.setText("Note");

        jLabel4.setText("Date");

        jLabel5.setText("Total");

        jLabel2_Edit.setText("OrderID");

        jLabel3_Edit.setText("Customer");

        jLabel1_Edit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1_Edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_Edit.setText("Receipt Detail");

        back_edit.setBackground(new java.awt.Color(255, 255, 204));
        back_edit.setText("Back");
        back_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bt_del_detail_Edit)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(back_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_new_sp_Edit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_tk_sp_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_find_sp_Edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_fresh_sp_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_orderID_Edit))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_cus_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_date_Edit)
                                    .addComponent(txt_total_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_note_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_addneworder_Edit))))))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_orderID_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_note_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cus_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addneworder_Edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(bt_del_detail_Edit)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tk_sp_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_find_sp_Edit)
                    .addComponent(bt_fresh_sp_Edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new_sp_Edit)
                    .addComponent(back_edit))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_del_detail_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_del_detail_EditActionPerformed
        // TODO add your handling code here:
        int rows=tb_ordr_detail_Edit.getSelectedRow();
        if(rows<0){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng cần xóa!");
        }
        else{
            int repose = JOptionPane.showConfirmDialog(rootPane, "Xóa chi tiết này?", "", JOptionPane.YES_NO_OPTION);
            if(repose==JOptionPane.YES_OPTION){
                tongcong-=Float.valueOf(tb_ordr_detail_Edit.getValueAt(rows, 3).toString());
                txt_total_Edit.setText(String.valueOf(tongcong));
                orderproduct od1 = hdBLL.getOrder(Integer.valueOf(tb_ordr_detail_Edit.getValueAt(rows, 0).toString()));
                vegetable vg1 = traveidvegetable(tb_ordr_detail_Edit.getValueAt(rows, 1).toString());
                orderdetail or1 = new orderdetail();
                or1.setOrderID(od1);
                or1.setVegetableID(vg1);
                tkBLL.deleteOrderDetail(or1);
                odlist.remove(rows);
                saveEditOrder();
            }
        }
    }//GEN-LAST:event_bt_del_detail_EditActionPerformed
    public vegetable traveidvegetable(String name){
        List<vegetable> vglist= nhaphangBLL.loadVegetable();
        for (int i = 0; i < vglist.size(); i++) {
            if(vglist.get(i).getVegetableName().equals(name)){
                return vglist.get(i);
            }
        }
        return null;
    }
    private void bt_find_sp_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_find_sp_EditActionPerformed
        // TODO add your handling code here:
        if(txt_tk_sp_Edit.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Khong de trong'");
        }
        else{
            String nhap = txt_tk_sp_Edit.getText();
            List ls = nhaphangBLL.findProduct(nhap);
            Object[][] modelOBJ;
            modelOBJ = nhaphangBLL.convertList(ls);
            String[] title = {"VegetableID ","VegetableName","Unit","Amount","Image","Price"};
            DefaultTableModel model = new DefaultTableModel(modelOBJ,title);
            tb_sp_Edit.setModel(model);
        }
    }//GEN-LAST:event_bt_find_sp_EditActionPerformed

    private void bt_fresh_sp_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fresh_sp_EditActionPerformed
        // TODO add your handling code here:
        loadTableNhaphang();
    }//GEN-LAST:event_bt_fresh_sp_EditActionPerformed

    private void btn_new_sp_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_sp_EditActionPerformed
        // TODO add your handling code here:
        int rows=tb_sp_Edit.getSelectedRow();
        if(rows<0){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng cần thêm vào chi tiết hóa đơn!");
        }
        else{
            int test= 0;
            for (int i = 0; i < odlist.size(); i++) {
                vegetable vg = new vegetable();
                vg.setVegetableID(Integer.valueOf(tb_sp_Edit.getValueAt(rows, 0).toString()));
                if(vg.getVegetableID()==odlist.get(i).getVegetableID().getVegetableID()){
                    JOptionPane.showMessageDialog(rootPane, "Đã thêm sản phẩm này!");
                    test++;
            }
            }
            if(test==0){
               int rep= JOptionPane.showConfirmDialog(rootPane, "Thêm ?", "", JOptionPane.YES_NO_OPTION);
               if(rep==JOptionPane.YES_OPTION){
                   orderproduct ord1 = hdBLL.getOrder(Integer.valueOf(txt_orderID_Edit.getText()));
                   vegetable vg1 = nhaphangBLL.getProductByID(Integer.valueOf(tb_sp_Edit.getValueAt(rows, 0).toString()));
                   orderdetail or1 = new orderdetail();
                   or1.setOrderID(ord1);
                   or1.setVegetableID(vg1);
                   or1.setQuantity(1);
                   float tam= Float.valueOf(tb_sp_Edit.getValueAt(rows, 5).toString());
                   or1.setPrice(tam);
                   tongcong += tam;
                   txt_total_Edit.setText(String.valueOf(tongcong));
                   tkBLL.addOrderDetail(or1);
                   saveEditOrder();
               }
            }
         
        
        }
    }//GEN-LAST:event_btn_new_sp_EditActionPerformed
   
    private void btn_addneworder_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addneworder_EditActionPerformed
        // TODO add your handling code here:
        if(txt_note_Edit.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Không để trống Note!");

        }
        else{
               saveEditOrder();
        }
    }//GEN-LAST:event_btn_addneworder_EditActionPerformed
    public void saveEditOrder(){
            orderproduct od = hdBLL.getOrder(Integer.valueOf(txt_orderID_Edit.getText()));
            od.setCustomerID(traveidkhachhang(cb_cus_Edit.getSelectedItem().toString()));
            od.setTotal(Float.valueOf(txt_total_Edit.getText()));
            od.setNote(txt_note_Edit.getText());
            hdBLL.updateOrder(od);
            JOptionPane.showMessageDialog(rootPane, "Đã sửa hóa đơn! Vui lòng ấn reload để cập nhật");
             Quaylai();
    }
    public customers traveidkhachhang(String name){
    CustomersBLL cusBLL = new CustomersBLL();
        List<customers> cslist= cusBLL.loadCustomers();
        for (int i = 0; i < cslist.size(); i++) {
            if(cslist.get(i).getFullname().equals(name)){
                return cslist.get(i);
            }
        }
        return null;
    }
    private void back_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_editActionPerformed
        // TODO add your handling code here:
        Quaylai();
    }//GEN-LAST:event_back_editActionPerformed

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
            java.util.logging.Logger.getLogger(ReceiptDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_edit;
    private javax.swing.JButton bt_del_detail_Edit;
    private javax.swing.JButton bt_find_sp_Edit;
    private javax.swing.JButton bt_fresh_sp_Edit;
    private javax.swing.JButton btn_addneworder_Edit;
    private javax.swing.JButton btn_new_sp_Edit;
    private javax.swing.JComboBox<String> cb_cus_Edit;
    private javax.swing.JLabel jLabel1_Edit;
    private javax.swing.JLabel jLabel2_Edit;
    private javax.swing.JLabel jLabel3_Edit;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_ordr_detail_Edit;
    private javax.swing.JTable tb_sp_Edit;
    private javax.swing.JTextField txt_date_Edit;
    private javax.swing.JTextField txt_note_Edit;
    private javax.swing.JTextField txt_orderID_Edit;
    private javax.swing.JTextField txt_tk_sp_Edit;
    private javax.swing.JTextField txt_total_Edit;
    // End of variables declaration//GEN-END:variables
}

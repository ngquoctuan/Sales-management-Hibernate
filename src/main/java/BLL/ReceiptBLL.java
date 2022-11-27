/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.ReceiptDAL;
import DAL.StatisticsDAL;
import Hibernatecfs.HibernateUtils;
import POJO.*;
import java.util.List;
import org.hibernate.*;
/**
 *
 * @author Ngquoctuan
 */
public class ReceiptBLL {
    private ReceiptDAL hdDAL;

    public ReceiptBLL() {
        hdDAL = new ReceiptDAL();
    }
    public List loadOrder(){
        List list = hdDAL.loadOrder();
        return list;
    }
    public Object[][] convertList(List<orderproduct> list){
        int rows= list.size();
        int cols= 5;
        Object[][] cusList = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            cusList[i][0]= list.get(i).getOrderID();
            cusList[i][1]=list.get(i).getCustomerID().getFullname();
            cusList[i][2]=list.get(i).getDate();
            cusList[i][3]=list.get(i).getTotal();
            cusList[i][4]=list.get(i).getNote();
        }
        return cusList;
    }
    public orderproduct getOrder(int id){
        orderproduct ordr = hdDAL.getOrder(id);
        return ordr;
    }
    public List findOrder(int id){
      List list;
        list= hdDAL.findOrder(id);
        return list;
    }
        public void addOrder(orderproduct ordr){
        hdDAL.addOrder(ordr);
    }
            public void deleteOrder(orderproduct ordr){
        hdDAL.deleteOrder(ordr);
    }
    public void updateOrder(orderproduct ordr){
        hdDAL.updateOrder(ordr);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.StatisticsDAL;
import Hibernatecfs.HibernateUtils;
import POJO.*;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Ngquoctuan
 */
public class StatisticsBLL {
     private StatisticsDAL tkDAL;

    public StatisticsBLL() {
         tkDAL= new StatisticsDAL();
    }
    public List loadStatistics(){
        List list = tkDAL.loadOrderdetail();
        return list;
    }
    public Object[][] convertList(List<orderdetail> list){
        int rows= list.size();
        int cols= 4;
        Object[][] objList = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            objList[i][0]= list.get(i).getOrderID().getOrderID();
            objList[i][1]=list.get(i).getVegetableID().getVegetableID();
            objList[i][2]=list.get(i).getQuantity();
            objList[i][3]=list.get(i).getPrice();
        }
        return objList;
    }
    public Object[][] convertListvgName(List<orderdetail> list){
        int rows= list.size();
        int cols= 4;
        Object[][] objList = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            objList[i][0]= list.get(i).getOrderID().getOrderID();
            objList[i][1]=list.get(i).getVegetableID().getVegetableName();
            objList[i][2]=list.get(i).getQuantity();
            objList[i][3]=list.get(i).getPrice();
        }
        return objList;
    }
    public List findStatisticsVegetableID(int id){
        List list = tkDAL.findOrderdetailtheoVegetableID(id);
        return list;
    }
   
     public void addOrderDetail(orderdetail od){
        tkDAL.addOrderdetail(od);
    }
            public void deleteOrderDetail(orderdetail od){
        tkDAL.deleteOrderdetail(od);
    }
    public void updateOrderDetail(orderdetail od){
        tkDAL.updateOrderdetail(od);
    }
}

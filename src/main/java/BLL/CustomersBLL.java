/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CustomersDAL;
import POJO.customers;
import java.util.List;

/**
 *
 * @author Ngquoctuan
 */
public class CustomersBLL {
    CustomersDAL cus;

    public CustomersBLL() {
        cus= new CustomersDAL();
    }
     public List loadCustomers(){
        List list = cus.loadCustumers();
        return list;
    }
    public Object[][] convertList(List<customers> list){
        int rows= list.size();
        int cols= 5;
        Object[][] cusList = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            cusList[i][0]= list.get(i).getCustomerID();
            cusList[i][1]=list.get(i).getPassword();
            cusList[i][2]=list.get(i).getFullname();
            cusList[i][3]=list.get(i).getAddress();
            cusList[i][4]=list.get(i).getCity();
        }
        return cusList;
    }
    public customers getCustomers(int id){
        customers cs = cus.getCustomers(id);
        return cs;
    }
    public List findCustomers(String name){
        List list;
        list= cus.findCustumers(name);
        return list;
    }
        public void addnewCustomers(customers cs){
        cus.addCustomers(cs);
    }
            public void deleteCustomers(customers cs){
        cus.deleteCustomers(cs);
    }
    public void updateCustomers(customers cs){
        cus.updateCustomers(cs);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Hibernatecfs.HibernateUtils;
import POJO.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.*;

import org.hibernate.Session;

/**
 *
 * @author Ngquoctuan
 */
public class StatisticsDAL {
    Session session;

    public StatisticsDAL() {
         session = HibernateUtils.getFACTORY().openSession();
    }
    
    public List loadOrderdetail(){
        List<orderdetail> odlist;
        session.getTransaction().begin();
        odlist=session.createQuery("From orderdetail",orderdetail.class).list();
        session.getTransaction().commit();
        return odlist; 
    }
    public List findOrderdetailtheoVegetableID(int id){
        List<orderdetail> oblist = new ArrayList<orderdetail>();
        session.getTransaction().begin();
        vegetable pr =session.get(vegetable.class, id);
            Set<orderdetail>ord=pr.getOrderdetails();
            oblist.addAll(ord);
         session.getTransaction().commit();
        return oblist;
    }

     public orderdetail getOrderdetail(int id){
        orderdetail od = session.get(orderdetail.class, id);
        return od;
    }
    
    public void addOrderdetail(orderdetail od){
        session.getTransaction().begin();
        session.save(od);
        session.getTransaction().commit();
    }
    public void updateOrderdetail(orderdetail od){
        session.getTransaction().begin();
        session.update(od);
        session.getTransaction().commit();
    }
    public void deleteOrderdetail(orderdetail od){
        session.getTransaction().begin();
        session.delete(od);
        session.getTransaction().commit();
    }
}

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
public class ReceiptDAL {
    Session session;

    public ReceiptDAL() {
       session = HibernateUtils.getFACTORY().openSession();
    }
 public List loadOrder(){
        List<orderproduct> odrlist;
        session.getTransaction().begin();
        odrlist=session.createQuery("From orderproduct",orderproduct.class).list();
        session.getTransaction().commit();
        return odrlist; 
    }
 public List findOrder(int id){
        List<orderproduct> list;
        session.getTransaction().begin();
        Query query = session.createQuery("From orderproduct od Where od.OrderID = :id");
        query.setParameter("id", id);
         list = query.list();
         session.getTransaction().commit();
        return list;
    }
 
 public orderproduct getOrder(int id){
        orderproduct od = session.get(orderproduct.class, id);
        return od;
    }
    
    public void addOrder(orderproduct odr){
        session.getTransaction().begin();
        session.save(odr);
        session.getTransaction().commit();
    }
    public void updateOrder(orderproduct odr){
        session.getTransaction().begin();
        session.update(odr);
        session.getTransaction().commit();
    }
    public void deleteOrder(orderproduct odr){
        session.getTransaction().begin();
        session.delete(odr);
        session.getTransaction().commit();
    }
}

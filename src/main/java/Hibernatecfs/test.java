/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hibernatecfs;


import POJO.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Ngquoctuan
 */
public class test {
    public static void main(String[] args) {
        Session session = HibernateUtils.getFACTORY().openSession();
       
        
      /* Query q= session.createQuery("FROM category");
        List<category> list=  q.getResultList();
        
         for (category s : list) {
            System.out.println(s.getName());
             System.out.println(s.getCatagoryID());
        }*/
        /*category c = session.get(category.class, 1);
        c.setName("Fruit");
        session.getTransaction().begin();
        session.save(c);
        session.getTransaction().commit();*/
      /*  Transaction tx = session.beginTransaction();
            category c = new category();
            c.setCatagoryID(12);
            c.setName("dasd");
            c.setDescription("qeqwe");
            session.save(c);
         tx.commit();*/
           /*Transaction tx = session.beginTransaction();
           customers cus= new customers();
           cus.setCustomerID(25);
           cus.setPassword("ABCD1234");
           cus.setFullname("acvcx");
           cus.setAddress("123");
           cus.setCity("vcvx");
           session.save(cus);
           tx.commit();*/
        //  category c = session.get(category.class, 4);
         // System.out.println(c.getCatagoryID());
        
            
           //session.getTransaction().begin();
           // orderproduct vg = session.get(orderproduct.class, 1);
            //System.out.println(vg.getNote());
           
            // System.out.println(od1.getOrderID());
            
            /*orderproduct od1= session.get(orderproduct.class, 123);
            vegetable vg1 = session.get(vegetable.class, 4);
            orderdetail ord1 = new orderdetail();
            ord1.setOrderID(od1);
            ord1.setVegetableID(vg1);
          session.delete(ord1);*/
            
            //List<orderdetail> ord = session.createQuery("From orderdetail",orderdetail.class).list();
            //System.out.println(ord.get(1).getPrice());
            //List<> oblist;
           // org.hibernate.Query query = session.createQuery("From vegetable e Where e.getCatagoryID().getCatagoryID() = :id");
            //query.setParameter("id", 1);
            //oblist = query.list();
            
           /* vegetable pr =session.get(vegetable.class, 1);
            Set<orderdetail>ord=pr.getOrderdetails();
            List<orderdetail> orlist = new ArrayList<orderdetail>();
            orlist.addAll(ord);
            for (int i = 0; i < orlist.size(); i++) {
                System.out.println(orlist.get(i).getPrice());
            
        }*/
           /*List<orderproduct> oblist;
           org.hibernate.Query query = session.createQuery("From orderproduct od Where od.OrderID = :id");
             query.setParameter("id", 1);
             oblist = query.list();*/
            //session.getTransaction().commit();
            session.getTransaction().begin();
            orderproduct ord = session.get(orderproduct.class, 3);
            vegetable vg =session.get(vegetable.class, 123);
            orderdetail ordetail = new orderdetail();
            ordetail.setOrderID(ord);
            ordetail.setVegetableID(vg);
            ordetail.setQuantity(4);
            ordetail.setPrice(20000);
            session.save(ordetail);
            session.getTransaction().commit();
            session.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Hibernatecfs.HibernateUtils;
import POJO.*;
import java.util.List;
import org.hibernate.*;
/**
 *
 * @author Ngquoctuan
 */
public class CustomersDAL {
    Session session;

    public CustomersDAL() {
        session= HibernateUtils.getFACTORY().openSession();
    }
    
    
    public List loadCustumers(){
        List<customers> cuslist;
        session.getTransaction().begin();
        cuslist=session.createQuery("From customers",customers.class).list();
        session.getTransaction().commit();
        return cuslist; 
    }
    public List findCustumers(String name){
        name = "%" + name + "%";
        List<customers> list;
        session.getTransaction().begin();
        Query query = session.createQuery("From customers cs Where cs.Fullname Like :Fullname");
        query.setParameter("Fullname", name);
         list = query.list();
         session.getTransaction().commit();
        return list;
    }
    public customers getCustomers(int id){
        customers cs = session.get(customers.class, id);
        return cs;
    }
    public void addCustomers(customers cs){
        session.getTransaction().begin();
        session.save(cs);
        session.getTransaction().commit();
    }
    public void updateCustomers(customers cs){
        session.getTransaction().begin();
        session.update(cs);
        session.getTransaction().commit();
    }
    public void deleteCustomers(customers cs){
        session.getTransaction().begin();
        session.delete(cs);
        session.getTransaction().commit();
    }
}

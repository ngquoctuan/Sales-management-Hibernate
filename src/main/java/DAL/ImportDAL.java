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
public class ImportDAL {
    Session session;

    public ImportDAL() {
        session = HibernateUtils.getFACTORY().openSession();
    }
    
    
    public List loadVegetable(){
        List<vegetable> vegetlist;
        session.getTransaction().begin();
        vegetlist=session.createQuery("From vegetable",vegetable.class).list();
        session.getTransaction().commit();
        return vegetlist; 
    }
    public List findVegetable(String name){
        name = "%" + name + "%";
        List<vegetable> list;
        session.getTransaction().begin();
        Query query = session.createQuery("From vegetable vg Where vg.VegetableName Like :VegetableName");
        query.setParameter("VegetableName", name);
         list = query.list();
         session.getTransaction().commit();
        return list;
    }
    
    
    public vegetable getVegetable(int id){
        vegetable vg = session.get(vegetable.class, id);
        return vg;
    }
    
    public void addVegetable(vegetable vg){
        session.getTransaction().begin();
        session.save(vg);
        session.getTransaction().commit();
    }
    public void updateVegetable(vegetable vg){
        session.getTransaction().begin();
        session.update(vg);
        session.getTransaction().commit();
    }
    public void deleteVegetable(vegetable vg){
        session.getTransaction().begin();
        session.delete(vg);
        session.getTransaction().commit();
    }
    
    public List loadCategory(){
        List<category> catetlist;
        session.getTransaction().begin();
        catetlist=session.createQuery("From category",category.class).list();
        session.getTransaction().commit();
        return catetlist; 
    }
    public category getCategory(int id){
        category cate = session.get(category.class, id);
        return cate;
    }
}

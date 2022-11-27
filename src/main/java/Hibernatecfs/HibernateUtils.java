/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hibernatecfs;

import POJO.*;
import java.util.Properties;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author Ngquoctuan
 */
public class HibernateUtils {
    //khai bao factory
    private static final  SessionFactory FACTORY;
    static {
        Configuration cfn = new Configuration();
        
        //khai bao thong tin cau hinh`
        Properties prop = new Properties();
        prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        prop.put(Environment.URL, "jdbc:mysql://localhost:3306/market");
        prop.put(Environment.USER, "root");
        prop.put(Environment.PASS, "");
        prop.put(Environment.SHOW_SQL, "true");
       
        cfn.setProperties(prop);
        cfn.addAnnotatedClass(category.class);
        cfn.addAnnotatedClass(customers.class);
        cfn.addAnnotatedClass(vegetable.class); 
        cfn.addAnnotatedClass(orderdetail.class);  
        cfn.addAnnotatedClass(orderproduct.class);  
        
        
        //tao FACTORY
        ServiceRegistry regition = new StandardServiceRegistryBuilder().applySettings(cfn.getProperties()).build();
        FACTORY = cfn.buildSessionFactory(regition);
        
        
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
   
}

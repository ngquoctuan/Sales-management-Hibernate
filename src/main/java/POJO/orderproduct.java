/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ngquoctuan
 */
@Entity
@Table(name = "orderproduct")
public class orderproduct implements Serializable{
    @Id
    private int OrderID;
    private Date Date;
    private Float Total;
    private String Note;

    @ManyToOne
     @JoinColumn(name = "CustomerID")
           private customers CustomerID;

    @OneToMany(mappedBy = "OrderID")
        private Set<orderdetail> orderdetails;

    public Date getDate() {
        return Date;
    }

    /**
     * @return the OrderID
     */
    public int getOrderID() {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the Total
     */
    public Float getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(Float Total) {
        this.Total = Total;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    /**
     * @return the CustomerID
     */
    public customers getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(customers CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the orderdetails
     */
    public Set<orderdetail> getOrderdetails() {
        return orderdetails;
    }

    /**
     * @param orderdetails the orderdetails to set
     */
    public void setOrderdetails(Set<orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }
    
}

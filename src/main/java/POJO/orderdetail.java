/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ngquoctuan
 */
@Entity
@Table(name = "orderdetail")
public class orderdetail implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name="OrderID")
    private orderproduct OrderID;
    
    @Id
    @ManyToOne
    @JoinColumn(name="VegetableID")
    private vegetable VegetableID;
    
    private int Quantity;
    private float Price;



    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Price
     */
    public float getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(float Price) {
        this.Price = Price;
    }

    /**
     * @return the OrderID
     */
    public orderproduct getOrderID() {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(orderproduct OrderID) {
        this.OrderID = OrderID;
    }

    /**
     * @return the VegetableID
     */
    public vegetable getVegetableID() {
        return VegetableID;
    }

    /**
     * @param VegetableID the VegetableID to set
     */
    public void setVegetableID(vegetable VegetableID) {
        this.VegetableID = VegetableID;
    }


    
}

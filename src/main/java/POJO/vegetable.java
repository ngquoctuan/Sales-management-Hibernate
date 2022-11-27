/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
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
@Table(name = "vegetable")
public class vegetable implements Serializable{
    @Id
    private int VegetableID;
    private String VegetableName;
    private String Unit;
    private int Amount;
    private String  Image;
    private Float Price;
    
    @ManyToOne
    @JoinColumn(name = "CatagoryID")
    private category CatagoryID ;

    @OneToMany(mappedBy = "VegetableID")
   private Set<orderdetail> orderdetails;
   
    
    /**
     * @return the VegetableID
     */
    public int getVegetableID() {
        return VegetableID;
    }

    /**
     * @param VegetableID the VegetableID to set
     */
    public void setVegetableID(int VegetableID) {
        this.VegetableID = VegetableID;
    }

    /**
     * @return the VegetableName
     */
    public String getVegetableName() {
        return VegetableName;
    }

    /**
     * @param VegetableName the VegetableName to set
     */
    public void setVegetableName(String VegetableName) {
        this.VegetableName = VegetableName;
    }

    /**
     * @return the Unit
     */
    public String getUnit() {
        return Unit;
    }

    /**
     * @param Unit the Unit to set
     */
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    /**
     * @return the Amount
     */
    public int getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Image
     */
    public String getImage() {
        return Image;
    }

    /**
     * @param Image the Image to set
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

    /**
     * @return the Price
     */
    public Float getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(Float Price) {
        this.Price = Price;
    }

    /**
     * @return the CatagoryID
     */
    public category getCatagoryID() {
        return CatagoryID;
    }

    /**
     * @param CatagoryID the CatagoryID to set
     */
    public void setCatagoryID(category CatagoryID) {
        this.CatagoryID = CatagoryID;
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

    /**
     * @return the orderdetails
     */

    
    
}

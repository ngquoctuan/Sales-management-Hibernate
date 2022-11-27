/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ngquoctuan
 */
@Entity
@Table(name = "category")
public class category implements Serializable{
        @Id
        private int CatagoryID;
        private String Name;
        private String Description;
        
        @OneToMany(mappedBy = "CatagoryID")
        private Set<vegetable> vegetables;
    /**
     * @return the CatagoryID
     */
    public int getCatagoryID() {
        return CatagoryID;
    }
     /* 
     * 
     * @param CatagoryID the CatagoryID to set
     */
    public void setCatagoryID(int CatagoryID) {
        this.CatagoryID = CatagoryID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the vegetables
     */
    public Set<vegetable> getVegetables() {
        return vegetables;
    }

    /**
     * @param vegetables the vegetables to set
     */
    public void setVegetables(Set<vegetable> vegetables) {
        this.vegetables = vegetables;
    }
    
    
}

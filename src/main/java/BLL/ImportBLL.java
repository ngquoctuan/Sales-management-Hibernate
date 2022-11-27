/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.*;
import POJO.*;
import java.util.List;
/**
 *
 * @author Ngquoctuan
 */
public class ImportBLL {
    private ImportDAL importDAL;

    public ImportBLL() {
        importDAL= new ImportDAL();
    }
    
    
    public List loadVegetable(){
        List list = importDAL.loadVegetable();
        return list;
    }
    public Object[][] convertList(List<vegetable> list){
        int rows= list.size();
        int cols= 6;
        Object[][] objList = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            objList[i][0]= list.get(i).getVegetableID();
            objList[i][1]=list.get(i).getVegetableName();
            objList[i][2]=list.get(i).getUnit();
            objList[i][3]=list.get(i).getAmount();
            objList[i][4]=list.get(i).getImage();
            objList[i][5]=list.get(i).getPrice();
        }
        return objList;
    }
    public List findProduct(String name){
        List list = importDAL.findVegetable(name);
        return list;
    }
    public void addnewProduct(vegetable vg){
        importDAL.addVegetable(vg);
    }
    public vegetable getProductByID(int id){
        vegetable vg=importDAL.getVegetable(id);
        return vg;
    }
    public void deleteProduct(vegetable vg){
        importDAL.deleteVegetable(vg);
    }
    public void updateProduct(vegetable vg){
        importDAL.updateVegetable(vg);
    }
    
    public List loadCategory(){
        List list= importDAL.loadCategory();
        return list;
    }
    public category getDanhMuc(int id){
        category cate=importDAL.getCategory(id);
        return cate;
    }
    
}

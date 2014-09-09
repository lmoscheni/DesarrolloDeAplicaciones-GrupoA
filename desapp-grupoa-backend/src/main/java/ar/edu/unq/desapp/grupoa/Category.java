package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Class category
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Category {
    
    public String name;
    public List<Category> subcategorys;
    
    public Category(){
        this.subcategorys = new ArrayList<Category>();
    }
    
    public Category(String anName) {
        name = anName;
        subcategorys = new ArrayList<Category>();
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getSubcategorys() {
        return subcategorys;
    }

    public void setSubcategorys(List<Category> subcategorys) {
        this.subcategorys = subcategorys;
    }
    
    // ***********************************************************************************************************
    // Methods of class Voucher
    // ***********************************************************************************************************
    
    public void addSubcategory(String name) {
        this.subcategorys.add(new Category(name));
        
    }

    
}

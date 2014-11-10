package ar.edu.unq.desapp.grupoa.model.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class category
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */


public class Category implements Serializable{

    private static final long serialVersionUID = 8560666959522143702L;

    private Integer id;
    
    protected String name;
    
    public List<String> subcategories = new ArrayList<String>();
    
    public Category() {
        super();
    }

    public Category(String anName) {
        name = anName;
    }

    // Getters and setters
    public List<String> getSubcategories() {
        return subcategories;
    }
    
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTheSame(Category category) {
        return this.name == category.getName();
    }
    
 
    // Methods of class Category
    
    public void addSubcategory(String subcategory){
        this.subcategories.add(subcategory);
    }
    
    public void deleteSubcategory(String subcategory){
        this.subcategories.remove(subcategory);
    }
    
    public void modifySubcategory(String subcategory, String newSubcategory){
        List<String> newSubcategories = new ArrayList<String>();
        for(String s : this.subcategories){
            if(s.equals(subcategory)){
                newSubcategories.add(newSubcategory);
            }else{
                newSubcategories.add(s);
            }
        }
        this.subcategories = newSubcategories;
    }
}
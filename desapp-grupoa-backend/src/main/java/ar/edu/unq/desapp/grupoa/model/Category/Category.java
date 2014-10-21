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


public class Category implements Serializable, CategoryI{

    private static final long serialVersionUID = 8560666959522143702L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    protected String name;
    
    public List<Subcategory> subcategories = new ArrayList<Subcategory>();
    
    public Category() {
        super();
    }

    public Category(String anName) {
        name = anName;
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************
    
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
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

    public boolean isTheSame(CategoryI category) {
        return this.name == category.getName();
    }
    
 // ***********************************************************************************************************
//  // Methods of class Category
//  // ***********************************************************************************************************
    
    public void addSubcategory(Subcategory subcategory){
        this.subcategories.add(subcategory);
    }
    
    public Subcategory getSubcategory(String name){
        Subcategory return_subcategory = new Subcategory();
        for(Subcategory subcategory : this.subcategories){
            if (subcategory.name.equals(name)){
                return_subcategory = subcategory;
            }
        }
        return return_subcategory;
    }
}
package ar.edu.unq.desapp.grupoa.model.Category;

import java.io.Serializable;
import javax.persistence.Entity;


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
    
    public Subcategory subcategory;
    
    public Category() {
        super();
    }

    public Category(String anName) {
        name = anName;
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************
    
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
    
    public Subcategory getSubcategory() {
        return this.subcategory;
    }
    
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public boolean isTheSame(CategoryI category) {
        return this.name == category.getName();
    }


}
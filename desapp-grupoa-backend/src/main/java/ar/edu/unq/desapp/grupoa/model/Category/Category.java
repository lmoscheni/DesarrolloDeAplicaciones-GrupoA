package ar.edu.unq.desapp.grupoa.model.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class category
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */


@Entity
public class Category implements Serializable{

    private static final long serialVersionUID = 8560666959522143702L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    protected String name;
    
    public List<Category> subcategorys;
    
    public Category() {
        super();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    // Methods of class Category
    // ***********************************************************************************************************

    public void addSubcategory(String name) {
        this.subcategorys.add(new Category(name));

    }
    
    public boolean isTheSame(Category category) {
        return this.getName().equals(category.getName());
    }

}

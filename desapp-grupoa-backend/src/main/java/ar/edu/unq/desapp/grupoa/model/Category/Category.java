package ar.edu.unq.desapp.grupoa.model.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class category
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */


@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

    private static final long serialVersionUID = 8560666959522143702L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true)
    private Long id;
    
    @Column(name = "NAME")
    protected String name;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

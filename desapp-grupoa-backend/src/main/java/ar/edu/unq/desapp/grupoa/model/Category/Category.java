package ar.edu.unq.desapp.grupoa.model.Category;


/**
 * Class category
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Category implements CategoryI{

    public String name;
    public Subcategory subcategory;

    public Category() {
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

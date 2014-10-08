package ar.edu.unq.desapp.grupoa.model.Category;

public class Subcategory implements CategoryI{
    public String name;
    
    public Subcategory(String name) {
        this.name = name;
    }
    
    public boolean isTheSame(CategoryI category) {
        return this.name == category.getName();
    }

    public String getName() {
        return this.name;
    }

}

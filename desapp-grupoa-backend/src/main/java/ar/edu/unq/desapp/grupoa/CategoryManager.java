package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    List<Category> categorys;
    
    public CategoryManager() {
        categorys = new ArrayList<Category>();
    }
    
    public void addCategory(Category anCategory) {
        categorys.add(anCategory);
    }
    
    public void addSubcategory(Category superCategory,Subcategory newSubcategory) {
        superCategory.addSubcategory(newSubcategory);
    }
    
    public void delete(Category anCategory) {
        categorys.remove(anCategory);
    }
    
    public void deleteSubcategory(Category superCategory, Subcategory subcategory) {
        superCategory.removeSucategory(subcategory);
    }
}

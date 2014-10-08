package ar.edu.unq.desapp.grupoa.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Class cateogry manager
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class CategoryManager {

    private List<Category> categorys;

    public CategoryManager() {
        categorys = new ArrayList<Category>();
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    // ***********************************************************************************************************
    // Methods of class Voucher
    // ***********************************************************************************************************

    public void addCategory(Category anCategory) {
        this.categorys.add(anCategory);
    }

    public void addSubcategory(Category category, String subcategoryName) {
        for (Category c : this.categorys) {
            if (!c.isTheSame(category)) {
                c.setSubcategory(new Subcategory(subcategoryName));
            }
        }
    }
}

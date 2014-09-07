package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    public String name;
    public List<Subcategory> subcategorys;
    
    public Category(String anName) {
        name = anName;
        subcategorys = new ArrayList<Subcategory>();
    }

    public void addSubcategory(Subcategory newSubcategory) {
        subcategorys.add(newSubcategory);
        
    }

    public void removeSucategory(Subcategory anSubcategory) {
        subcategorys.remove(anSubcategory);
        
    }

}

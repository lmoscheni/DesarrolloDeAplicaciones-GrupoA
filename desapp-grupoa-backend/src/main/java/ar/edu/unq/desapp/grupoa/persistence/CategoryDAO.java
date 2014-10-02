package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public class CategoryDAO {

    public void saveOrUpdate(Category category){
        SessionManager.runInSession(new SaveOrUpdateCategoryOperation(category));
    }
    
    public void delete(String nameCategory){
        SessionManager.runInSession(new DeleteCategoryOperation(nameCategory));
    }
    
    public void getCategories(){
        SessionManager.runInSession(new GetCategoriesOperation());
    }
    
    public void saveSubcategory(){
        
    }
}

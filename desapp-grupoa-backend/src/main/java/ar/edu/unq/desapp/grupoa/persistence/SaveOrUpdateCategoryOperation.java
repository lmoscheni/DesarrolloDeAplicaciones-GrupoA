package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public class SaveOrUpdateCategoryOperation implements Operation<Category>{

    protected Category category;
    
    public SaveOrUpdateCategoryOperation(Category category){
        this.category = category;
    }
    
    public Category execute() {
        SessionManager.getSession().saveOrUpdate(this.category);
        return this.category;
    }

}

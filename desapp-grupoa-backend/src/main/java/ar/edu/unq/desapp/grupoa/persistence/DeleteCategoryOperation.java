package ar.edu.unq.desapp.grupoa.persistence;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public class DeleteCategoryOperation implements Operation<Category>{

    protected String nameCategory;
    
    public DeleteCategoryOperation(String nameCategory){
        this.nameCategory = nameCategory;
    }
    
    public Category execute() {
        Criteria cri = SessionManager.getSession().createCriteria(Category.class);
        cri.add(Restrictions.eq("name", this.nameCategory));
        Category categoryResult = (Category)cri.uniqueResult();
        SessionManager.getSession().delete(categoryResult);
        return categoryResult;
    }

}

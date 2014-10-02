package ar.edu.unq.desapp.grupoa.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public class GetCategoriesOperation implements Operation<Category>{

    protected List<Category> categories;
    
    public GetCategoriesOperation() {
        this.categories = new ArrayList<Category>();
    }
    
    @SuppressWarnings("unchecked")
    public Category execute() {
        Criteria cri = SessionManager.getSession().createCriteria(Category.class);
        this.categories = cri.list();
        return null;
    }

}

package ar.edu.unq.desapp.grupoa.services;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public class CategoryService extends GenericService<Category> {

    private static final long serialVersionUID = 5264923410350659074L;

    @Transactional
    public Category findByName(final String name){
        return this.getDao().findByName(name);
    }
    
    @Transactional
    public void saveOrUpdate(Category entity){
        this.getDao().saveOrUpdate(entity);
    }
    
}

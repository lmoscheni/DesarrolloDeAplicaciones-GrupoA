package ar.edu.unq.desapp.grupoa.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.parser.Parser;

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
    
    @Transactional
    public void saveCategory(Category category) throws Exception{
        List<Category> categories = retriveAll();
        for(Category c :categories){
            if(c.getName().equals(category.getName())){
                throw new Exception("Ya existe la categoria");
            }
        }
        save(category);
    }
    
    @Transactional
    public void updateCategory(int id, String nombre){
        Category c = findById(id);
        c.setName(nombre);
        update(c);
    }
    
    @Transactional
    public void saveSubcategory(String json) throws Exception{
        update(Parser.parseCategory(json,this));
    }
}

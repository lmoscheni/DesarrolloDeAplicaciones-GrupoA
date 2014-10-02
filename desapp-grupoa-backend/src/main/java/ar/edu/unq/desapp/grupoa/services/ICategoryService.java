package ar.edu.unq.desapp.grupoa.services;

import java.util.List;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public interface ICategoryService {

    List<Category> findAllCategories();
    
    Category findCategory(Long categoryId);
    
    void createCategory(final Category category);
    
    void updateCategory(final Category category);
    
    void deleteCategory(final Category category);
    
    void deleteCategoryById(Long categoryId);
    
    void saveSubcategory(String nameCategory, String nameSubcategory);
}

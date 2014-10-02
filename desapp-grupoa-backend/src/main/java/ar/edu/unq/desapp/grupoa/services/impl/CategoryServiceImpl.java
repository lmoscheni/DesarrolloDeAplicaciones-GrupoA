package ar.edu.unq.desapp.grupoa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.persistence.repository.CategoryRepository;
import ar.edu.unq.desapp.grupoa.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Transactional
    public void createCategory(final Category category) {
        categoryRepository.save(category);
    }
    
    @Transactional
    public void deleteCategory(final Category category) {
        categoryRepository.delete(category);
    }

    @Transactional
    public void deleteCategoryById(final Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    
    @Transactional
    public void updateCategory(final Category category) {
        categoryRepository.save(category);
    }
    
    @Transactional(readOnly = true)
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findCategory(final Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
    
    @Transactional
    public void saveSubcategory(String nameCategory, String nameSubcategory) {
        categoryRepository.saveSubcategory(nameCategory, nameSubcategory);
    }
    
    public void setCategoryRepository(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}

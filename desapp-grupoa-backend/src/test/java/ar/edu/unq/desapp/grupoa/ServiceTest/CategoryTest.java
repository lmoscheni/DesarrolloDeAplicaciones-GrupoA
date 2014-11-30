package ar.edu.unq.desapp.grupoa.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

/**
 * Test Category service
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml","classpath:META-INF/spring-web.xml"})
public class CategoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    CategoryService categoryService;
    
    @Test
    public void testGuardarCategory() throws Exception{
        
        Category category = new Category("Ventas Mayoristas");
        getCategoryService().saveCategory(category);
        
        assertTrue(category.getId() != null);

        assertEquals("Ventas Mayoristas", getCategoryService().findById(category.getId()).getName());
    }
    
    @Test
    public void testGuardarCategoryExistente(){
        
        Category category = new Category("Ventas Mayoristas");
        Category category1 = new Category("Ventas Mayoristas");
        
        try{
            getCategoryService().saveCategory(category);
            getCategoryService().saveCategory(category1);
            assertTrue(false);
        }catch(Exception e){
            assertTrue(true);
            assertEquals("Ventas Mayoristas", getCategoryService().findById(category.getId()).getName());
        }
    }
    
    @Test
    public void testUpdateCategory(){
        Category category = new Category("Ventas Mayoristas");
        getCategoryService().save(category);
       
        getCategoryService().updateCategory(category.getId(), "Ventas");
        
        assertEquals("Ventas", getCategoryService().findById(category.getId()).getName());
    }
    
    @Test
    public void testDeleteCategory(){
        Category category = new Category("Ventas Mayoristas");
        getCategoryService().save(category);
        
        assertTrue(category.getId() != null);
        int id = category.getId();
        
        getCategoryService().delete(category);
        
        assertEquals(null, getCategoryService().findById(id));
    }

    @Test
    public void testFindByNameCategory(){
        Category category = new Category("Ventas Mayoristas");
        getCategoryService().save(category);
        
        assertTrue(category.getId() != null);
        Category categoryFind = getCategoryService().findByName("Ventas Mayoristas");
        
        assertEquals(categoryFind,category);
    }
    
    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
}

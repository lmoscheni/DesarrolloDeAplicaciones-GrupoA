package ar.edu.unq.desapp.grupoa.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml","classpath:META-INF/spring-web.xml"})
public class SubcategoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    CategoryService categoryService;
    
    @Test
    public void testGuardarSubcategory() throws Exception{
        
        Category category = new Category("Ventass");
        getCategoryService().saveCategory(category);
        
        assertEquals(0,getCategoryService().findById(category.getId()).subcategories.size());
        
        getCategoryService().saveSubcategory("{category:Ventass,subcategory:Alfajor}");
        
        assertEquals(1,getCategoryService().findById(category.getId()).subcategories.size());
    }
    
    @Test
    public void testGuardarSubcategoryExistente(){
        
        Category category = new Category("Ventass");
        try {
            getCategoryService().saveCategory(category);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        assertEquals(0,getCategoryService().findById(category.getId()).subcategories.size());
        
        try{
            getCategoryService().saveSubcategory("{category:Ventass,subcategory:Alfajor}");
            getCategoryService().saveSubcategory("{category:Ventass,subcategory:Alfajor}");
            assertTrue(false);
        }catch(Exception e){
            assertTrue(true);
            assertEquals(1,getCategoryService().findById(category.getId()).subcategories.size());
        }
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }
}


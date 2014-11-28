package ar.edu.unq.desapp.grupoa.serviceTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.services.CategoryService;


@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml","classpath:META-INF/spring-web.xml"})
public class SaveCategoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    CategoryService categoryService;
    
    @Test
    public void testGuardarYBuscarCategory(){
        
        Category category = new Category("Ventas Mayoristas");
        getCategoryService().save(category);
        boolean esta = false;
        
        assertTrue(category.getId() != null);

        List<Category> categories = getCategoryService().retriveAll();
        for(Category c : categories){
            if(c.getName().equals("Ventas Mayoristas")){
                esta = true;
            }
        }
        assertTrue(esta);
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
//    @Test
//    public void deleteCategory(){
//        Category category = new Category("ventas");
//        categoryService.save(category);
//        List<Category> categories = categoryService.findAll();
//        assertEquals( 1 , categories.size());
//        
//        categoryService.removeCategory("ventas");
//        
//        categories = categoryService.findAll();
//        assertEquals( 0 , categories.size());
//    }
    
}

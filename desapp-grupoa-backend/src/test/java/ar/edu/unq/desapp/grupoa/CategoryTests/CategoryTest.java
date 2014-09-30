package ar.edu.unq.desapp.grupoa.CategoryTests;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import junit.framework.TestCase;

public class CategoryTest extends TestCase {

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    public void testGetAndSetName() {

        Category category = new Category();
        category.setName("Juli");

        assertEquals("Juli", category.getName());
    }

    @SuppressWarnings("unchecked")
    public void testGetAndSetSubcategories() {

        List<Category> mockListSubcategory = mock(ArrayList.class);

        Category category = new Category();
        category.setSubcategorys(mockListSubcategory);

        assertEquals(mockListSubcategory, category.getSubcategorys());
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testAddSubcategory() {

        Category category = new Category();
        category.addSubcategory("Venta");

        assertEquals(1, category.getSubcategorys().size());
    }
    
    public void testIsTheSame(){
        
        Category categoryIngreso = new Category("Ingreso");
        Category categoryVenta = new Category("Venta");
        
        assertFalse(categoryIngreso.isTheSame(categoryVenta));
    }
}

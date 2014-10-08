package ar.edu.unq.desapp.grupoa.CategoryTests;

import static org.mockito.Mockito.mock;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Category.Subcategory;
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

    public void testGetAndSetSubcategory() {

        Subcategory mockSubcategory = mock(Subcategory.class);

        Category category = new Category();
        category.setSubcategory(mockSubcategory);

        assertEquals(mockSubcategory, category.getSubcategory());
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testAddSubcategory() {
        Subcategory mockSubcategory = mock(Subcategory.class);
        
        Category category = new Category();
        category.setSubcategory(mockSubcategory);

        assertEquals(mockSubcategory, category.getSubcategory());
    }
    
    public void testIsTheSame(){
        
        Category categoryIngreso = new Category("Ingreso");
        Category categoryVenta = new Category("Venta");
        
        assertFalse(categoryIngreso.isTheSame(categoryVenta));
    }
}

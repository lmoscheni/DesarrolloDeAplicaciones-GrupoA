package ar.edu.unq.desapp.grupoa.CategoryTests;

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
    
    public void testGetAndSetId() {

        Category category = new Category();
        Integer i = new Integer(1);
        category.setId(i);

        assertEquals(i, category.getId());
    }

    public void testGetSubcategories(){
       
        Category category = new Category();
        category.addSubcategory("Alfajor");
        
        assertTrue(category.getSubcategories().contains("Alfajor"));
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testAddSubcategory() {
        
        Category category = new Category();
        String subcategory = "Alfajor";
        category.addSubcategory(subcategory);

        assertTrue(category.getSubcategories().contains(subcategory));
    }
    
    public void testIsTheSame(){
        
        Category categoryIngreso = new Category("Ingreso");
        Category categoryVenta = new Category("Venta");
        
        assertFalse(categoryIngreso.isTheSame(categoryVenta));
    }
}

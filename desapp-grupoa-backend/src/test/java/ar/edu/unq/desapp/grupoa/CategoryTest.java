package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

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
}

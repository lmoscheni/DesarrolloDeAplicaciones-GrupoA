package ar.edu.unq.desapp.grupoa.CategoryTests;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Category.CategoryManager;
import ar.edu.unq.desapp.grupoa.model.Category.Subcategory;
import junit.framework.TestCase;

/**
 * Test category manager
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class CategoryManagerTest extends TestCase {

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    @SuppressWarnings("unchecked")
    public void testGetAndSetCategories() {

        List<Category> mockCategories = mock(ArrayList.class);

        CategoryManager cManager = new CategoryManager();
        cManager.setCategorys(mockCategories);

        assertEquals(mockCategories, cManager.getCategorys());
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testAddCategory() {

        CategoryManager cManager = new CategoryManager();

        Category mockCategory = mock(Category.class);

        cManager.addCategory(mockCategory);

        assertEquals(1, cManager.getCategorys().size());
    }

    public void testAddSubcategory() {
        //Subcategory mockSubcategory = mock(Subcategory.class);
        Category mockCategory = mock(Category.class);
        when(mockCategory.getName()).thenReturn("Ingreso");
        when(mockCategory.isTheSame(any(Category.class))).thenReturn(false);
        
        CategoryManager cManager = new CategoryManager();
        cManager.addCategory(mockCategory);
        cManager.addSubcategory(mockCategory, "Venta");
        // no tiene mucho sentido esto ahora
    }
}

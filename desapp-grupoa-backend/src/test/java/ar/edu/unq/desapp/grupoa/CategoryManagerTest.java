package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * Test category manager
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class CategoryManagerTest extends TestCase{

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************
    
    public void testGetAndSetCategories(){
        
        List mockCategories = mock(ArrayList.class);
        
        CategoryManager cManager = new CategoryManager();
        cManager.setCategorys(mockCategories);
        
        assertEquals(mockCategories, cManager.getCategorys());
    }
    
    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************
    
    public void testAddCategory(){
        
        CategoryManager cManager = new CategoryManager();
        
        Category mockCategory = mock(Category.class);
        
        cManager.addCategory(mockCategory);
        
        assertEquals(1, cManager.getCategorys().size());
    }
    
    public void testAddSubcategory(){
        
        Category mockCategory = mock(Category.class);
        when(mockCategory.getName()).thenReturn("Ingreso");
        
        CategoryManager cManager = new CategoryManager();
        cManager.addCategory(mockCategory);
        cManager.addSubcategory(mockCategory, "Venta");
        
        verify(mockCategory, times(2)).getName();
        verify(mockCategory, times(1)).addSubcategory(anyString());;
    }
}

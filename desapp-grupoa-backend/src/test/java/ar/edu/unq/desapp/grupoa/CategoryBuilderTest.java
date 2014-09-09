package ar.edu.unq.desapp.grupoa;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.builders.CategoryBuilder;

/**
 * Test category builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class CategoryBuilderTest extends TestCase{

    public void testBuildVoucherName() {

        Category category = CategoryBuilder.aCategory().withName("Juli").build();

        assertEquals("Juli", category.getName());
    }

}

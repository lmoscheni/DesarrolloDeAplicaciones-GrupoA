package ar.edu.unq.desapp.grupoa.BuilderTests;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.helpers.builders.CategoryBuilder;
import ar.edu.unq.desapp.grupoa.model.Category.Category;

/**
 * Test category builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class CategoryBuilderTest extends TestCase {

    public void testBuildVoucherName() {

        Category category = CategoryBuilder.aCategory().withName("Juli").build();

        assertEquals("Juli", category.getName());
    }

}

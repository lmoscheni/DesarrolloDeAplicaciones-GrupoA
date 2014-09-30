package ar.edu.unq.desapp.grupoa.BuilderTests;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.helpers.builders.OperationBuilder;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import static org.mockito.Mockito.*;

/**
 * Test operation builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class OperationBuilderTest extends TestCase {

    public void testBuildVoucherWithAmount() {

        Operation operation = OperationBuilder.aOperation().withAmount(100.0).build();

        assertEquals(100.0, operation.getAmount());
    }

    public void testBuildVoucherWithCategory() {

        Category mockCategory = mock(Category.class);

        Operation operation = OperationBuilder.aOperation().withCategory(mockCategory).build();

        assertEquals(mockCategory, operation.getCategory());
    }

    public void testBuildVoucherWithShift() {

        Shift mockShift = Shift.EVENING;

        Operation operation = OperationBuilder.aOperation().withShift(mockShift).build();

        assertEquals(mockShift, operation.getShift());
    }

    public void testBuildVoucherOperationType() {

        OperationType mockOperationType = mock(OperationType.class);

        Operation operation = OperationBuilder.aOperation().withOperationType(mockOperationType).build();

        assertEquals(mockOperationType, operation.getOperationType());
    }
}

package ar.edu.unq.desapp.grupoa.helperTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.parser.Parser;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

public class ParserTest extends TestCase{

    
    public void testParseOperation() throws Exception{
        
        Operation o = new Operation();
        String json = "{'amount':500,'shift':'Noche','category':'Ventas','operationType':true,'subcategory':'Alfajores','concept':'nada','account':'Cuenta en efectivo'}";
        CategoryService CS = mock(CategoryService.class);
        Category category = mock(Category.class);
        when(category.getName()).thenReturn("Ventas");
        when(CS.findByName("Ventas")).thenReturn(category);
        
        Operation parsedOperation = Parser.parseOperation(o, json, CS);
        
        System.out.println(parsedOperation.getCategory());
        
        assertEquals(500.0, parsedOperation.getAmount());
        //assertEquals(category.getName(), parsedOperation.getCategory().getName());
        assertTrue(parsedOperation.getSubcategory().contains("Alfajores"));
        assertEquals(OperationTypeEnum.INCOME, parsedOperation.getOperationTypeEnum());
        assertTrue(parsedOperation.getConcept().contains("nada"));
        //assertEquals(Shift.NOCHE,parsedOperation.getShift());
    }
}

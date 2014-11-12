package ar.edu.unq.desapp.grupoa.parser;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Egress;
import ar.edu.unq.desapp.grupoa.model.Operation.Income;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationTypeService;

public class Parser {

    public static Operation parseOperation(Operation o,final String jsonOperation, CategoryService categoryService, OperationTypeService operationTypeService) throws Exception {
        String[] tokens = getTokens(jsonOperation);
        
        o.setAmount(Double.parseDouble(tokens[2]));
        o.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        o.setCategory(category);
        OperationType operationType = null;
        
        if(tokens[8].equals("true")){
//            operationType = operationTypeService.findByName("Income");
//            if(operationType.equals(null)){
                operationType = new Income();
//            }
        }else{
//            operationType = operationTypeService.findByName("Egress");
//            if(operationType.equals(null)){
                operationType = new Egress();
//            }
        }
        
        o.setSubcategory(tokens[10]);
        o.setOperationType(operationType);
        return o;
    }
    
    public static Category parseCategory(final String json, CategoryService categoryService){
        String[] tokens = getTokens(json);
        Category category = categoryService.findByName(tokens[2]);
        category.addSubcategory(tokens[4]);
        return category;
    }
    
    private static String[] getTokens(String json){
        String delims = "[ \",:{}]+";
        String[] tokens = json.split(delims);
        return tokens;
    }
}

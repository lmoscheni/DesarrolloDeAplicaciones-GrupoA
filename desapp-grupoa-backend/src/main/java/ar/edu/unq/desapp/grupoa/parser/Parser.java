package ar.edu.unq.desapp.grupoa.parser;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Egress;
import ar.edu.unq.desapp.grupoa.model.Operation.Income;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

public class Parser {

    public static Operation parseOperation(final String jsonOperation, CategoryService categoryService) throws Exception {
        String[] tokens = getTokens(jsonOperation);
        
        Operation newOperation = new Operation();
        newOperation.setAmount(Double.parseDouble(tokens[2]));
        newOperation.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        newOperation.setCategory(category);
        OperationType operationType = null;
        
        if(tokens[8].equals("true")){
            operationType = new Income();
        }else{
            operationType = new Egress();
        }
        
        newOperation.setSubcategory(tokens[10]);
        newOperation.setOperationType(operationType);
        return newOperation;
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

package ar.edu.unq.desapp.grupoa.parser;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.services.AccountService;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

public class Parser {

    public static Operation parseOperation(Operation o,final String jsonOperation, CategoryService categoryService) throws Exception {
        String[] tokens = getTokens(jsonOperation);
        
        o.setAmount(Double.parseDouble(tokens[2]));
        o.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        o.setCategory(category);
        OperationTypeEnum operationType = null;
        
        if(tokens[8].equals("true")){
            operationType = OperationTypeEnum.INCOME;
        }else{
            operationType = OperationTypeEnum.EGRESS;
        }
        
        o.setSubcategory(tokens[10]);
        o.setOperationTypeEnum(operationType);
        o.setConcept(tokens[12]);
        o.setAccount(AccountEnum.create(tokens[14]));
        return o;
    }
    
    public static Operation parseUpdateOperation(Operation o,final String jsonOperation, CategoryService categoryService) throws Exception {
        String[] tokens = getTokens(jsonOperation);
        
        o.setAmount(Double.parseDouble(tokens[2]));
        o.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        o.setCategory(category);
        OperationTypeEnum operationType = null;
        
        if(tokens[8].equals("true")){
            operationType = OperationTypeEnum.INCOME;
        }else{
            operationType = OperationTypeEnum.EGRESS;
        }
        
        o.setSubcategory(tokens[10]);
        o.setOperationTypeEnum(operationType);
        o.setConcept(tokens[12]);
        o.setAccount(AccountEnum.create(tokens[14]));
        return o;
    }
    
    public static Category parseCategory(final String json, CategoryService categoryService) throws Exception{
        String[] tokens = getTokens(json);
        Category category = categoryService.findByName(tokens[2]);
        for(String subcategory : category.subcategories){
            if(subcategory.equals(tokens[4])){
                throw new Exception("Ya existe subcategoria");
            }
        }
        category.addSubcategory(tokens[4]);
        return category;
    }
    
    private static String[] getTokens(String json){
        String delims = "[\",:{}]+";
        String[] tokens = json.split(delims);
        return tokens;
    }
}

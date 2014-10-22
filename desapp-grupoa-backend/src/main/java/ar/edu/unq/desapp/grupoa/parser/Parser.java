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
        String delims = "[ \",:{}]+";
        String[] tokens = jsonOperation.split(delims);
        Operation newOperation = new Operation();
        newOperation.setAmount(Integer.parseInt(tokens[2]));
        newOperation.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        newOperation.setCategory(category);
        OperationType operationType = null;
        if(tokens[8].equals("true")){
            operationType = new Income();
        }else{
            operationType = new Egress();
        }
        newOperation.setOperationType(operationType);
        return newOperation;
    }
}

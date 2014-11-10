package ar.edu.unq.desapp.grupoa.helpers.builders;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;
import ar.edu.unq.desapp.grupoa.model.System.Shift;

/**
 * Class a operation builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class OperationBuilder {

    public static OperationBuilder aOperation() {
        return new OperationBuilder();
    }

    private double amount;

    private Category category;
    
    private String subcategory;

    private Shift shift;

    private OperationType operationType;

    public Operation build() throws Exception {
        return new Operation(amount, category , subcategory , shift, operationType);
    }

    public OperationBuilder withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public OperationBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public OperationBuilder withShift(Shift shift) {
        this.shift = shift;
        return this;
    }

    public OperationBuilder withOperationType(OperationType operationType) {
        this.operationType = operationType;
        return this;
    }
}

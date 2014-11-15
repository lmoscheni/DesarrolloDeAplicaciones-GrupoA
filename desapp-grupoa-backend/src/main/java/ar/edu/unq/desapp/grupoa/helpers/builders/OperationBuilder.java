package ar.edu.unq.desapp.grupoa.helpers.builders;

import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
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
    
    private String concept;
    
    private Shift shift;

    private OperationTypeEnum operationType;

    private AccountEnum account;
    
    public Operation build() throws Exception {
        return new Operation(amount, category , subcategory , shift, operationType, concept, account);
    }

    public OperationBuilder withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public OperationBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public OperationBuilder withSubcategory(String subcategory) {
        this.subcategory = subcategory;
        return this;
    }
    
    public OperationBuilder withShift(Shift shift) {
        this.shift = shift;
        return this;
    }

    public OperationBuilder withOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;
        return this;
    }
    
    public OperationBuilder withConcept(String concept) {
        this.concept = concept;
        return this;
    }
    
    public OperationBuilder withAccount(AccountEnum account) {
        this.account = account;
        return this;
    }
}

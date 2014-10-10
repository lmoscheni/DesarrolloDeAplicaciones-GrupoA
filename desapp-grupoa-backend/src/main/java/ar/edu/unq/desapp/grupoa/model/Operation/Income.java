package ar.edu.unq.desapp.grupoa.model.Operation;

import java.io.Serializable;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;

public class Income extends OperationType implements Serializable{

    private static final long serialVersionUID = -7977509416327744911L;

    public Income(){

    }
    
    public void chargeOperation(Operation operation, Account account) {
        account.increaseBalance(operation.getAmount());
    }

    @Override
    public boolean isIncome() {
        return true;
    }
}

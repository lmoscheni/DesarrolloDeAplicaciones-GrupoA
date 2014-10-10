package ar.edu.unq.desapp.grupoa.model.Operation;

import java.io.Serializable;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;

public class Egress extends OperationType implements Serializable{

    private static final long serialVersionUID = 4299045345594904343L;

    public Egress(){

    }
    
    public void chargeOperation(Operation operation, Account account) {
        account.increaseBalance(operation.getAmount());
    }
}

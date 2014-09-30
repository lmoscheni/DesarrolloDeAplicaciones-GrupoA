package ar.edu.unq.desapp.grupoa.Operation;

import ar.edu.unq.desapp.grupoa.Accounts.Account;

/**
 * Class operation type
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public abstract class OperationType {

    public abstract void chargeOperation(Operation operation, Account account);

    public boolean isIncome() {
        return false;
    }
}

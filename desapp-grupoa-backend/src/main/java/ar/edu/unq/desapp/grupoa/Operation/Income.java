package ar.edu.unq.desapp.grupoa.Operation;

import ar.edu.unq.desapp.grupoa.Accounts.Account;

public class Income extends OperationType {

    public void chargeOperation(Operation operation, Account account) {
        account.increaseBalance(operation.getAmount());
    }

    @Override
    public boolean isIncome() {
        return true;
    }
}

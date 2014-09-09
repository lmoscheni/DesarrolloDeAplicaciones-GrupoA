package ar.edu.unq.desapp.grupoa;

public class Egress extends OperationType {

    public void chargeOperation(Operation operation, Account account) {
        account.increaseBalance(operation.getAmount());
    }
}

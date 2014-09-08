package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends PaymentType {

    public double accrued;
    public List<Operation> pendingOperations;
    
    public BankAccount() {
        super();
        accrued = 0.0;
        pendingOperations = new ArrayList<Operation>();
    }
    
    @Override
    public void registerOperation(Operation anOperation) throws Exception {
        if (anOperation.isIncome()){
            available = available + anOperation.getAmount();
        }
        else {
            available = available - anOperation.getAmount();
        }
    }
}

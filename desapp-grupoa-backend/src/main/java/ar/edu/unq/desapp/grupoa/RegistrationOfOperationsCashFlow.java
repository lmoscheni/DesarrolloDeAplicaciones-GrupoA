package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class RegistrationOfOperationsCashFlow
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class RegistrationOfOperationsCashFlow {

    protected List<Operation> operations;
    protected List<Voucher> vouchers;
    protected List<Consolidation> consolidations;
    protected List<Account> accounts;

    public RegistrationOfOperationsCashFlow(List<Account> accounts) {
        this.operations = new ArrayList<Operation>();
        this.vouchers = new ArrayList<Voucher>();
        this.consolidations = new ArrayList<Consolidation>();
        this.accounts = new ArrayList<Account>();
    }

    // ********************************************************************************************************
    // Getters and setters
    // ********************************************************************************************************

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    // ********************************************************************************************************
    // Methods of class RegistrationOfOperationsCashFlow
    // ********************************************************************************************************

    public void registrateOperation(Operation mockOperation) {
        this.operations.add(mockOperation);
    }

    public void concolidationOfAccounts() {
        double available = 0.0;
        double accrued = 0.0;
        for (Account account : this.accounts) {
            available += account.getBalance();
            accrued += account.getAccrued();
        }
        this.consolidations.add(new Consolidation(available, accrued, new Date()));
    }

}

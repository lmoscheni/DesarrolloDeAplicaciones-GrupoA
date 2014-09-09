package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import ar.edu.unq.desapp.grupoa.exportation.GenerateExcel;

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
        this.accounts = accounts;
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

    public void transferAccruedToBalance(){
        
        for(Account account : this.accounts){
            if(account.isBankAccount() && account.getCuurently().compareTo(new Date()) <= 0){
                double tranfer = account.getAccrued();
                account.decreaseBalance(tranfer);
                account.setBalance(account.getBalance() + tranfer);
            }
        }
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
    
    public Vector datesOperetionExport(){ 
    
        Vector dates = new Vector();
        dates.add("Date, Type, Category, Subcategory, Shift, Apply to, Amount");
        for(Operation operation: this.operations){
            String dateString = "";
            dateString = operation.getDateOperation().toString() + ", " + operation.getOperationType().getClass().toString() +
                    ", " + operation.getCategory().getName() + ", " + " " + ", " + operation.getShift().toString() +
                    ", " + " " + ", " + operation.getAmount();
            dates.add(dateString);
        }
        return dates;
    }
    
    public void exportOperations(){
        
        Vector vectorDates = this.datesOperetionExport();
        String path = "./operations_" + new Date().toString() + ".xls";
        try {
            GenerateExcel.crearExcel(vectorDates, "Operations", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

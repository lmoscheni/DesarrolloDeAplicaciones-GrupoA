package ar.edu.unq.desapp.grupoa.model.System;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import ar.edu.unq.desapp.grupoa.helpers.exportation.GenerateExcel;
import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;

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

    public RegistrationOfOperationsCashFlow() {
        this.operations = new ArrayList<Operation>();
        this.vouchers = new ArrayList<Voucher>();
        this.consolidations = new ArrayList<Consolidation>();
    }
    
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

    public void registrateOperation(Operation operation,Account account) {
        this.operations.add(operation);
        operation.applyOperation(account);
    }

//    public void updateAccounts(){
//        for(Account acount : this.accounts) {
//            acount.updateTheAccountStatus();
//        }
//    }
//    
//    public void concolidationOfAccounts() {
//        this.updateAccounts();
//        double available = 0.0;
//        double accrued = 0.0;
//        for (Account account : this.accounts) {
//            available += account.getBalance();
//            accrued += account.getAccrued();
//        }
//        this.consolidations.add(new Consolidation(available, accrued, new Date()));
//    }
//    
//    public String generateRow(Operation operation) {
//        String row = operation.getDateOperation().toString() + 
//                            ", " + 
//                            operation.getOperationTypeEnum().getClass().toString() +
//                            ", " + 
//                            operation.getCategory().getName() + 
//                            ", " + " " + ", " 
//                            + operation.getShift().toString() +
//                            ", " + " " + ", " + 
//                            operation.getAmount();
//        return row;
//    }
//    
//    public Vector<String> datesOperetionExport(){ 
//        Vector<String> dates = new Vector<String>();
//        dates.add("Date, Type, Category, Subcategory, Shift, Apply to, Amount");
//        for(Operation operation: this.operations){
//            dates.add(this.generateRow(operation));
//        }
//        return dates;
//    }
//    
//    public void exportOperations(String path){
//        Vector<String> vectorDates = this.datesOperetionExport();
//        String exportPath = path + "operations_" + new Date().toString() + ".xls";
//        try {
//            GenerateExcel.crearExcel(vectorDates, "Operations", exportPath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}

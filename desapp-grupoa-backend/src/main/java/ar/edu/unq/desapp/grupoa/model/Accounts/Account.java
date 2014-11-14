package ar.edu.unq.desapp.grupoa.model.Accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;

/**
 * Class account
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@Entity
public class Account implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int id;
    
    protected double balance;

    protected List<Operation> operations;

    protected String name;

    public Account() {
        this.balance = 0;
        this.operations = new ArrayList<Operation>();
    }
    
    public Account(String name) {
        this.balance = 0;
        this.name = name;
        this.operations = new ArrayList<Operation>();
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccrued() {
        return 0.0;
    }

    public Date getCurrently() {
        return null;
    }

    // ***********************************************************************************************************
    // Methods of account
    // ***********************************************************************************************************

    public boolean isBankAccount() {
        return false;
    }

    public void increaseBalance(double amount) {
        this.balance += amount;
    }

    public void decreaseBalance(double amount) {
        this.balance -= amount;
    }

    public void registrateOperation(Operation operation) {
        this.operations.add(operation);
        operation.applyOperation(this);
    }

    public void deleteOperation(Operation operation) {
        this.operations.remove(operation);
        this.balance -= operation.getAmount();
    }
    
    public void updateTheAccountStatus() {
        
    }

}

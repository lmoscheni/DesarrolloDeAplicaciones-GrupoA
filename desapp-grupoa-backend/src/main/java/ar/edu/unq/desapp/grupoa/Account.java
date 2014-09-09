package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance;
    private List<Operation> operations;
    
    public Account(){
        this.balance = 0;
        this.operations = new ArrayList<Operation>();
    }
    
    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************
    
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    // ***********************************************************************************************************
    // Methods of account
    // ***********************************************************************************************************
    
    public void increaseBalance(int amount) {
        this.balance += amount;
    }

    public void decreaseBalance(int amount){
        this.balance -= amount;
    }

    public void registrateOperation(Operation operation){
        this.operations.add(operation);
        operation.applyOperation(this);
    }
    
    public void deleteOperation(Operation operation){
        this.operations.remove(operation);
        this.balance -= operation.getAmount();
    }
    
}

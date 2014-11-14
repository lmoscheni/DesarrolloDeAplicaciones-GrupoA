package ar.edu.unq.desapp.grupoa.model.Operation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.System.Shift;

/**
 * Class operation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@Entity
public class Operation implements Serializable{

    private static final long serialVersionUID = -2093366008375658799L;

    private Integer id;
    
    private double amount;

    private Category category;

    private String subcategory;
    
    private String concept;
    
    private Shift shift;
    
    private OperationTypeEnum operationType;

    private Date dateOperation;
    
    private Account account;

    public Operation() {
        this.dateOperation = new Date();
    }

    public Operation(double amount, Category category, String subcategory, Shift shift, OperationTypeEnum operationType, String concept, Account account) throws Exception {
        this.setAmount(amount);
        this.category = category;
        this.subcategory = subcategory;
        this.shift = shift;
        this.operationType = operationType;
        this.dateOperation = new Date();
        this.concept = concept;
        this.account = account;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws Exception {
        if(amount < 0){
            throw new Exception("Monto invalido");
        }else{
            this.amount = amount;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public void setOperationTypeEnum(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    // Methods
    public void applyOperation(Account account) {

        this.operationType.getOperationTypeEnum(this.operationType).chargeOperation(this, account);
    }

}

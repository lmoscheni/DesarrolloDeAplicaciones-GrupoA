package ar.edu.unq.desapp.grupoa;

/**
 * Class operation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Operation {

    private int amount;

    private Category category;

    private Shift shift;

    private OperationType operationType;

    public Operation() {
    }

    public Operation(int amount, Category category, Shift shift, OperationType operationType) {
        this.amount = amount;
        this.category = category;
        this.shift = shift;
        this.operationType = operationType;
    }

    // ******************************************************************************************************
    // Getters and setters
    // ******************************************************************************************************

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    // ******************************************************************************************************
    // Methods
    // ******************************************************************************************************

    public void applyOperation(Account account) {

        this.operationType.chargeOperation(this, account);
    }

}

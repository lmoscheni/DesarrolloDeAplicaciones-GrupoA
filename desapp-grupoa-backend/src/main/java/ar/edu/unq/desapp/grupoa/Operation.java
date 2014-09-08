package ar.edu.unq.desapp.grupoa;
/**
 * Class operation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public abstract class Operation {

    private int amount;
    private Category category;
    private Shift shift;
    
    public Operation(int amount, Category category, Shift shift){
        this.amount = amount;
        this.category = category;
        this.shift = shift;
    }

    //******************************************************************************************************
    //Getters and setters
    //******************************************************************************************************
    
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

    //******************************************************************************************************
    //Methods
    //******************************************************************************************************

    public abstract void performOperation(PaymentType paymentType);
    public abstract boolean isIncome();
    public abstract boolean isEgress();

}

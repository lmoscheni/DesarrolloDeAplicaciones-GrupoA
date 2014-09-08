package ar.edu.unq.desapp.grupoa;

public class Egress extends Operation {

    public Egress(){}
    
    public Egress(int amount, Category category, Shift shift) {
        super(amount, category, shift); 
    }

    @Override
    public void performOperation(PaymentType paymentType) {
        try {
            paymentType.registerOperation(this);
        } catch (Exception e) {
            new Exception("Uhh");
        }
    }

    @Override
    public boolean isIncome() {
        return false;
    }

    @Override
    public boolean isEgress() {
        return true;
    }

}

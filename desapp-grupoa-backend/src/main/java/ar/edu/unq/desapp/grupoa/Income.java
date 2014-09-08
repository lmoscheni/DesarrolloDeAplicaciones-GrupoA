package ar.edu.unq.desapp.grupoa;

public class Income extends Operation {

    public Income(int amount, Category category, Shift shift) {
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
    public boolean isEgress() {
        return false;
    }

    @Override
    public boolean isIncome() {
        return true;
    }
}

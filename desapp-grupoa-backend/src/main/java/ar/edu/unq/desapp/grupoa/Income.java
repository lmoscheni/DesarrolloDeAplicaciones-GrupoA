package ar.edu.unq.desapp.grupoa;

import mocks.Category;
import mocks.PaymentType;
import mocks.Shift;

public class Income extends Operation {

    public Income(int amount, Category category, Shift shift) {
        super(amount, category, shift);
    }

    @Override
    public void performOperation(PaymentType paymentType) {
        paymentType.registerOperation(this);
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

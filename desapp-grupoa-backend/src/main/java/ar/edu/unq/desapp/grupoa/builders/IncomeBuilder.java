package ar.edu.unq.desapp.grupoa.builders;

import mocks.Shift;
import ar.edu.unq.desapp.grupoa.Category;
import ar.edu.unq.desapp.grupoa.Income;

public class IncomeBuilder {

    public static IncomeBuilder aOperation() {
        return new IncomeBuilder();
    }
    
    private int amount;
    private Category category;
    private Shift shift;
    
    public Income build() {
        return new Income(amount, category, shift);
    }

    public IncomeBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }
    
    public IncomeBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }
    
    public IncomeBuilder withShift(Shift shift) {
        this.shift = shift;
        return this;
    }
}

package ar.edu.unq.desapp.grupoa.builders;

import ar.edu.unq.desapp.grupoa.Category;
import ar.edu.unq.desapp.grupoa.Egress;
import ar.edu.unq.desapp.grupoa.Shift;

public class EgressBuilder {

    public static EgressBuilder aOperation() {
        return new EgressBuilder();
    }
    
    private int amount;
    private Category category;
    private Shift shift;
    
    public Egress build() {
        return new Egress(amount, category, shift);
    }

    public EgressBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }
    
    public EgressBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }
    
    public EgressBuilder withShift(Shift shift) {
        this.shift = shift;
        return this;
    }
}

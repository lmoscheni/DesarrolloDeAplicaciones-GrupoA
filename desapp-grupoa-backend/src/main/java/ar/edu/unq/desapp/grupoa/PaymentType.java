package ar.edu.unq.desapp.grupoa;

public class PaymentType {
    public double available;
    
    public PaymentType() {
        available = 0.0;
    }
    
    public void registerOperation(Operation anOperation) throws Exception {
        throw new Exception("Its not defined");
    }
}

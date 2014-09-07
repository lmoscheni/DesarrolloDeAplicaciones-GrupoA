package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Class RegistrationOfOperationsCashFlow
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class RegistrationOfOperationsCashFlow {

    private List<Operation> operations;
    
    public RegistrationOfOperationsCashFlow(){
        this.operations = new ArrayList<Operation>();
    }
    
    //********************************************************************************************************
    //Getters and setters
    //********************************************************************************************************

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    //********************************************************************************************************
    //Methods of clas RegistrationOfOperationsCashFlow
    //********************************************************************************************************
    
    public void registrateOperation(Operation mockOperation) {
           this.operations.add(mockOperation);
    }

}

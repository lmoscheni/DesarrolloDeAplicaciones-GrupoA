package ar.edu.unq.desapp.grupoa.model.Operation;

public enum OperationTypeEnum {

    INCOME, EGRESS;
    
    public OperationType getOperationTypeEnum(OperationTypeEnum o){
        if(o.equals("INCOME")){
            return new Income();
        }else{
            return new Egress();
        }
    }
}

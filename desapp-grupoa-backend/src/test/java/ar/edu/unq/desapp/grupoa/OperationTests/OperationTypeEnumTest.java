package ar.edu.unq.desapp.grupoa.OperationTests;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;

public class OperationTypeEnumTest extends TestCase{

    public void testCreateEnumIncome() throws Exception {

        OperationType income = OperationTypeEnum.INCOME.getOperationTypeEnum(OperationTypeEnum.INCOME);

        assertTrue(income.isIncome());
    }
    
    public void testCreateEnumEgress() throws Exception {

        OperationType egress = OperationTypeEnum.EGRESS.getOperationTypeEnum(OperationTypeEnum.EGRESS);

        assertFalse(egress.isIncome());
    }
}

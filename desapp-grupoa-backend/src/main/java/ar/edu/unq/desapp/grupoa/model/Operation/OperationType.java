package ar.edu.unq.desapp.grupoa.model.Operation;

import java.io.Serializable;

import javax.persistence.Entity;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;

/**
 * Class operation type
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@Entity
public abstract class OperationType implements Serializable{

    private static final long serialVersionUID = 1015311019105432947L;

    public abstract void chargeOperation(Operation operation, Account account);

    public boolean isIncome() {
        return false;
    }
}

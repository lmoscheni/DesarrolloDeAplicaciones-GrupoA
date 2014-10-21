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

    //private String name;
    
    private Integer id;
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIncome() {
        return false;
    }

    public void chargeOperation(Operation operation, Account account){};
}

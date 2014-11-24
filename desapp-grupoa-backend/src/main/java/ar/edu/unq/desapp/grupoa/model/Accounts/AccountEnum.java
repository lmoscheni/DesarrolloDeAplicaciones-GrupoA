package ar.edu.unq.desapp.grupoa.model.Accounts;

import java.io.Serializable;


public enum AccountEnum implements Serializable{

    BankAccount,CashAccount,CurrentAccount;
    
    public static AccountEnum create(String account){
        AccountEnum returnValue = null;
        if(account.equals("Bank account") || account.equals("Cuenta bancaria") ){
            returnValue = BankAccount;
        }
        if(account.equals("Cash account") || account.equals("Cuenta en efectivo")){
            returnValue = CashAccount;
        }
        if(account.equals("Current account") || account.equals("Cuenta corriente")){
            returnValue = CurrentAccount;
        }
        return returnValue;
    }
}

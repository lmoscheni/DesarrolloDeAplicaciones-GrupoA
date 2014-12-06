package ar.edu.unq.desapp.grupoa.model.Accounts;

import java.io.Serializable;


public enum AccountEnum implements Serializable{

    BankAccount,CashAccount,CurrentAccount;
    
    public static AccountEnum create(String account){
        AccountEnum returnValue = null;
        if(account.equals("BankAccount") || account.equals("Cuenta bancaria") ){
            returnValue = BankAccount;
        }
        if(account.equals("CashAccount") || account.equals("Cuenta en efectivo")){
            returnValue = CashAccount;
        }
        if(account.equals("CurrentAccount") || account.equals("Cuenta corriente")){
            returnValue = CurrentAccount;
        }
        return returnValue;
    }
}

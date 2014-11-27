package ar.edu.unq.desapp.grupoa.services;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.parser.Parser;

public class OperationService extends GenericService<Operation>{

    /**
     * 
     */
    private static final long serialVersionUID = -4047486437268145200L;

    @Transactional
    public void saveOperation(String json, CategoryService categoryService, AccountService AS) throws Exception{
        Operation o = this.parseNewOperation(json,categoryService);
        Account a = AS.getAccount(o.getAccount().toString());
        a.registrateOperation(o);
        AS.update(a);
        save(o);
    }
    
    @Transactional
    public void updateOperation(Operation o, String jsonOperation, CategoryService categoryService) throws Exception{
        update(Parser.parseUpdateOperation(o,jsonOperation,categoryService));
    }
    
    @Transactional
    public void deleteOperation(Integer id, OperationService OS, AccountService AS){
        Operation o = OS.findById(new Integer(id));
        Account a = AS.getAccount(o.getAccount().toString());
        a.deleteOperation(o);
        AS.update(a);
        OS.delete(o);
    }
    
    //Other methods
    private Operation parseNewOperation(final String jsonOperation,CategoryService categoryService) throws Exception {
        return Parser.parseOperation(new Operation(),jsonOperation, categoryService);
    }
    
//    private Operation parseUpdateOperation(Operation o,final String jsonOperation,CategoryService categoryService) throws Exception {
//        return Parser.parseUpdateOperation(o,jsonOperation, categoryService);
//    }
}

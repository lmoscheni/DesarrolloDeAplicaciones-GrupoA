package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.services.AccountService;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class ReportWS {

    @Autowired
    private OperationService operationService;
    private CategoryService categoryService;
    private AccountService accountService;
    
    @GET
    @Path("/distributionExpensesIncome")
    @Produces("application/json")
    public Map<String,Double> getDistributionExpenses() throws Exception, JsonGenerationException, JsonMappingException, IOException{
        
        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
        List<Operation> operations = getOperationService().retriveAll();
        for(Operation operation : operations) {
            if(operation.getOperationTypeEnum().equals(OperationTypeEnum.INCOME)){
                String categoryName = operation.getCategory().getName();
                this.passingToMap(distributionExpenses, categoryName, operation);
            }
        }
      
        return distributionExpenses;
    }
    
    @GET
    @Path("/distributionExpensesEgress")
    @Produces("application/json")
    public Map<String,Double> getDistributionExpensesEgress() throws Exception, JsonGenerationException, JsonMappingException, IOException{
        
        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
        List<Operation> operations = getOperationService().retriveAll();
        for(Operation operation : operations) {
            if(operation.getOperationTypeEnum().equals(OperationTypeEnum.EGRESS)){
                String categoryName = operation.getCategory().getName();
                this.passingToMap(distributionExpenses, categoryName, operation);
            }
        }
      
        return distributionExpenses;
    }
    
    @GET
    @Path("/incomeByShift")
    @Produces("application/json")
    public Map<String,Double> incomeByShift() {
        Map<String,Double> incomesByShift = new HashMap<String, Double>();
        this.consolidationAfternoonShift(incomesByShift);
        this.consolidationMorningShift(incomesByShift);
        this.consolidationNightShift(incomesByShift);
        return incomesByShift;
    }
    
    @GET
    @Path("/distributionExpensesByCategory/{category}")
    @Produces("application/json")
    public Map<String,Double> getDistributionExpensesByCategory(@PathParam("category") final String nameCategory) throws Exception, JsonGenerationException, JsonMappingException, IOException{
        
        Category c = getCategoryService().findByName(nameCategory);
        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
        List<Operation> operationsOfCategory = this.getOperationsOfTheCategory(c);
        
        for(Operation operation : operationsOfCategory) {
            String categoryName = operation.getSubcategory();
            this.passingToMap(distributionExpenses, categoryName, operation);
        }
        
        return distributionExpenses;
    }
    
    @GET
    @Path("/accountDistribution")
    @Produces("application/json")
    public Map<String,Double> accountDistribution(){
        Map<String,Double> accountDistribution = new HashMap<String, Double>();
        List<Account> accounts = getAccountService().retriveAll();
        for(Account a : accounts){
            accountDistribution.put(a.getName(), a.getBalance());
        }
        return accountDistribution;
        
    }
    
    private List<Operation> getOperationsOfTheCategory(Category category) {
        List<Operation> operationsCategory = new ArrayList<Operation>();
        List<Operation> operations = getOperationService().retriveAll();
        for(Operation operation : operations) {
            if(operation.getCategory().getName().equals(category.getName())) {
                operationsCategory.add(operation);
            }
        }
        return operationsCategory;
    }
    
    private void passingToMap(Map<String,Double> map, String key, Operation operation){
        if (map.containsKey(key)) {
            Double oldValue = map.get(key);
            map.put(key, oldValue + operation.getAmount());
        }else { 
            map.put(key,operation.getAmount());
        }
    }
    
    private void consolidationNightShift(Map<String,Double> map){
        List<Account> accounts = getAccountService().retriveAll();
        for(Account a : accounts){
            Double mount = 0.0;
            String key = "Noche" + " " + a.getName();
            for(Operation o: a.operations){
                if(o.getShift().equals(Shift.Noche) && o.getOperationTypeEnum()
                        .equals(OperationTypeEnum.INCOME)){
                    mount += a.getBalance();
                }
            }
            map.put(key, mount);
        }
    }
    
    private void consolidationMorningShift(Map<String,Double> map){
        List<Account> accounts = getAccountService().retriveAll();
        for(Account a : accounts){
            Double mount = 0.0;
            String key = "Mañana" + " " + a.getName();
            for(Operation o: a.operations){
                if(o.getShift().equals(Shift.Mañana) && o.getOperationTypeEnum()
                        .equals(OperationTypeEnum.INCOME)){
                    mount += a.getBalance();
                }
            }
            map.put(key, mount);
        }
    }
    
    private void consolidationAfternoonShift(Map<String,Double> map){
        List<Account> accounts = getAccountService().retriveAll();
        for(Account a : accounts){
            Double mount = 0.0;
            String key = "Tarde" + " " + a.getName();
            for(Operation o: a.operations){
                if(o.getShift().equals(Shift.Tarde) && o.getOperationTypeEnum()
                        .equals(OperationTypeEnum.INCOME)){
                    mount += a.getBalance();
                }
            }
            map.put(key, mount);
        }
    }
    
    public OperationService getOperationService() {
        return operationService;
    }
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
    public CategoryService getCategoryService() {
        return categoryService;
    }
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
}

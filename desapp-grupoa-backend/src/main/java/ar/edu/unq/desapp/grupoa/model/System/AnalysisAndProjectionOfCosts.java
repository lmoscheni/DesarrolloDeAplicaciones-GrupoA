package ar.edu.unq.desapp.grupoa.model.System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;

public class AnalysisAndProjectionOfCosts {
    
    public List<Operation> operations;
    public List<Consolidation> consolidations;
    public List<Category> categorys;
    protected List<Account> accounts;
    
    public AnalysisAndProjectionOfCosts(List<Operation> operations,List<Consolidation> consolidations,List<Category> categorys) {
        this.operations = operations;
        this.consolidations = consolidations;
        this.categorys = categorys;
    }

    public Map<String,Double> distributionExpenses() {
        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
        
        for(Operation operation : this.operations) {
            String categoryName = operation.getCategory().getName();
            this.passingToMap(distributionExpenses, categoryName, operation);
        }
        
        return distributionExpenses;
    }
    
    public Map<String,Double> distributionOfExpendituresByCategory(Category category) {
        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
        List<Operation> operationsOfCategory = this.getOperationsOfTheCategory(category);
        
        for(Operation operation : operationsOfCategory) {
            String categoryName = operation.getSubcategory();
            this.passingToMap(distributionExpenses, categoryName, operation);
        }
        
        return distributionExpenses;
    }
    
    private void passingToMap(Map<String,Double> map, String key, Operation operation){
        if (map.containsKey(key)) {
            Double oldValue = map.get(key);
            map.put(key, oldValue + operation.getAmount());
        }else { 
            map.put(key,operation.getAmount());
        }
    }
    
    private List<Operation> getOperationsOfTheCategory(Category category) {
        List<Operation> operationsCategory = new ArrayList<Operation>();
        for(Operation operation : this.operations) {
            if(operation.getCategory().isTheSame(category)) {
                operationsCategory.add(operation);
            }
        }
        return operationsCategory;
    }
    
    public void incomeByShift() {
        //TODO
    }
    
    public Map<String,Double> accountDistribution(){
    	Map<String,Double> accountDistribution = new HashMap<String, Double>();
    	for(Account a : this.accounts){
    		accountDistribution.put(a.getName(), a.getAccrued());
    	}
		return accountDistribution;
    	
    }
    
    private Double consolidationNightShift(){
    	return 1.0;
    }
    
    private Double consolidationMorningShift(){
    	return 1.0;
    }
    
    private Double consolidationAfternoonShift(){
    	return 1.0;
    }
}
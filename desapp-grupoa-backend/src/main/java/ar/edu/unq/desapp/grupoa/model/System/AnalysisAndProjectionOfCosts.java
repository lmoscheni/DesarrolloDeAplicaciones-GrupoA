package ar.edu.unq.desapp.grupoa.model.System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;

public class AnalysisAndProjectionOfCosts {
    
    public List<Operation> operations;
    public List<Consolidation> consolidations;
    public List<Category> categorys;
    protected List<Account> accounts;
    
    public AnalysisAndProjectionOfCosts(){}
    
    public AnalysisAndProjectionOfCosts(List<Operation> operations,List<Consolidation> consolidations,List<Category> categorys) {
        this.operations = operations;
        this.consolidations = consolidations;
        this.categorys = categorys;
    }

//    public Map<String,Double> distributionExpenses() {
//        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
//        
//        for(Operation operation : this.operations) {
//            String categoryName = operation.getCategory().getName();
//            this.passingToMap(distributionExpenses, categoryName, operation);
//        }
//        
//        return distributionExpenses;
//    }
//    
//    public Map<String,Double> distributionOfExpendituresByCategory(Category category) {
//        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
//        List<Operation> operationsOfCategory = this.getOperationsOfTheCategory(category);
//        
//        for(Operation operation : operationsOfCategory) {
//            String categoryName = operation.getSubcategory();
//            this.passingToMap(distributionExpenses, categoryName, operation);
//        }
//        
//        return distributionExpenses;
//    }
//    
//    private void passingToMap(Map<String,Double> map, String key, Operation operation){
//        if (map.containsKey(key)) {
//            Double oldValue = map.get(key);
//            map.put(key, oldValue + operation.getAmount());
//        }else { 
//            map.put(key,operation.getAmount());
//        }
//    }
//    
//    private List<Operation> getOperationsOfTheCategory(Category category) {
//        List<Operation> operationsCategory = new ArrayList<Operation>();
//        for(Operation operation : this.operations) {
//            if(operation.getCategory().isTheSame(category)) {
//                operationsCategory.add(operation);
//            }
//        }
//        return operationsCategory;
//    }
//    
//    public Map<String,Double> incomeByShift() {
//    	Map<String,Double> incomesByShift = new HashMap<String, Double>();
//    	this.consolidationAfternoonShift(incomesByShift);
//    	this.consolidationMorningShift(incomesByShift);
//    	this.consolidationNightShift(incomesByShift);
//    	return incomesByShift;
//    }
//    
//    public Map<String,Double> accountDistribution(){
//    	Map<String,Double> accountDistribution = new HashMap<String, Double>();
//    	for(Account a : this.accounts){
//    		accountDistribution.put(a.getName(), a.getBalance());
//    	}
//		return accountDistribution;
//    	
//    }
//    
//    private void consolidationNightShift(Map<String,Double> map){
//    	for(Account a : this.accounts){
//    		Double mount = 0.0;
//    		String key = "Noche" + " " + a.getName();
//    		for(Operation o: a.operations){
//    			if(o.getShift().equals("Noche")){
//    				mount += a.getBalance();
//    			}
//    		}
//    		map.put(key, mount);
//    	}
//    }
//    
//    private void consolidationMorningShift(Map<String,Double> map){
//    	for(Account a : this.accounts){
//    		Double mount = 0.0;
//    		String key = "Mañana" + " " + a.getName();
//    		for(Operation o: a.operations){
//    			if(o.getShift().equals("Noche")){
//    				mount += a.getBalance();
//    			}
//    		}
//    		map.put(key, mount);
//    	}
//    }
//    
//    private void consolidationAfternoonShift(Map<String,Double> map){
//    	for(Account a : this.accounts){
//    		Double mount = 0.0;
//    		String key = "Mañana" + " " + a.getName();
//    		for(Operation o: a.operations){
//    			if(o.getShift().equals("Noche")){
//    				mount += a.getBalance();
//    			}
//    		}
//    		map.put(key, mount);
//    	}
//    }
}
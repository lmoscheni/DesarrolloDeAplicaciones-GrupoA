package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class ReportWS {

    @Autowired
    private OperationService operationService;
    private CategoryService categoryService;
    
    @GET
    @Path("/distributionExpenses")
    @Produces("application/json")
    public Map<String,Double> getDistributionExpenses() throws Exception, JsonGenerationException, JsonMappingException, IOException{
        
        Map<String,Double> distributionExpenses= new HashMap<String,Double>();
        List<Operation> operations = getOperationService().retriveAll();
        for(Operation operation : operations) {
            String categoryName = operation.getCategory().getName();
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
    
    
    
}

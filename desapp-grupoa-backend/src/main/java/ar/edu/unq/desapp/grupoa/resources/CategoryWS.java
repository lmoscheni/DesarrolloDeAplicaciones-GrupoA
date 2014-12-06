package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class CategoryWS {

    @Autowired
    private CategoryService categoryService;
    private OperationService operationService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Category> getAllCategories(){
        return getCategoryService().retriveAll();
    }
    
    @GET
    @Path("/get/{categoryId}")
    @Produces("application/json")
    public Category findCategory(@PathParam("categoryId") final String name) throws JsonGenerationException, JsonMappingException, IOException{
        return getCategoryService().findByName(name);
    }
    
    @GET
    @Path("/delete/{id}")
    public List<Category> deleteCategory(@PathParam("id") final String id) {
        Category c = getCategoryService().findById(new Integer(id));
        List<Operation> operations = getOperationService().retriveAll();
        boolean operationContainsCategory = false;
        for(Operation o : operations){
            if(c.getName().equals(o.getCategory().getName())){
                operationContainsCategory = true;
            }
        }
        
        if(!operationContainsCategory){
            getCategoryService().delete(c);
        }else{
            return new ArrayList<Category>();
        }
        return  getCategoryService().retriveAll();
    }
    
    @POST
    @Path("/save/")
    @Consumes("application/json")
    public Response saveCategory(@Multipart(value = "category", type = "application/json") final String name) {
        try {
            getCategoryService().saveCategory(new Category(name));
        } catch (Exception e) {
            return Response.status(500).build();
        }
            return Response.status(201).build();
        
    }
    
    @GET
    @Path("/modify/{id}/{name}")
    @Produces("application/json")
    public List<Category> modifyCategory(@PathParam("id") final int id,
    @PathParam("name") final String categoryName) {
        try {
            getCategoryService().updateCategory(id, categoryName);
        } catch (Exception e) {
            
        }
        return getCategoryService().retriveAll();
    }
    
    @POST
    @Path("/saveSubcategory/")
    @Consumes("application/json")
    public Response saveSubcategory(@Multipart(value = "category", type = "application/json") final String json) {
        try {
            getCategoryService().saveSubcategory(json);
        } catch (Exception e) {
            return Response.status(500).build();
        }
            return Response.status(200).build();
        
    }
    
    @GET
    @Path("/modifySubcategory/{id}/{name1}/{name2}")
    @Produces("application/json")
    public List<String> modifySubcategory(@PathParam("id") final int id,
    @PathParam("name1") final String subcategoryName,
    @PathParam("name2") final String newSubcategoryName){
        try {
            Category c = getCategoryService().findById(id);
            c.modifySubcategory(subcategoryName, newSubcategoryName);
            List<Operation> operations = getOperationService().retriveAll();
            for(Operation o : operations){
                if(o.getSubcategory().equals(subcategoryName)){
                    o.setSubcategory(newSubcategoryName);
                    getOperationService().update(o);
                }
            }
            getCategoryService().update(c);
            return c.subcategories;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    @GET
    @Path("/deleteSubcategory/{id}/{name}")
    @Produces("application/json")
    public List<String> deleteSubcategory(@PathParam("id") final int id,
    @PathParam("name") final String subcategoryName) {
        try {
            Category c = getCategoryService().findById(id);
            c.deleteSubcategory(subcategoryName);
            getCategoryService().update(c);
            return c.subcategories;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public OperationService getOperationService() {
        return operationService;
    }

    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
    
    
}
package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import ar.edu.unq.desapp.grupoa.parser.Parser;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

@Service
public class CategoryWS {

    @Autowired
    private CategoryService categoryService;
    
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
        getCategoryService().delete(c);
        return  getCategoryService().retriveAll();
    }
    
    @POST
    @Path("/save/")
    @Consumes("application/json")
    public Response saveCategory(@Multipart(value = "category", type = "application/json") final String name) {
        try {
        System.out.println(name);
        getCategoryService().save(new Category(name));
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
            return Response.status(201).build();
        
    }
    
    @POST
    @Path("/saveSubcategory/")
    @Consumes("application/json")
    public Response saveSubcategory(@Multipart(value = "category", type = "application/json") final String json) {
        try {
            getCategoryService().update(Parser.parseCategory(json, categoryService));
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
            return Response.status(201).build();
        
    }
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @POST
//    @Path("/createCategory")
//    @Consumes("application/json")
//    public Response createCategory(
//        @Multipart(value = "category2", type = "application/json") final String jsonCategory) {
//        try {
//            categoryService.createCategory(parseCategory(jsonCategory));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.serverError().build();
//        }
//        return Response.status(HTTP_OK_CREATED).build();
//    }
//    
//    @PUT
//    @Path("/updateCategory/{categoryId}")
//    @Consumes("application/json")
//    public Response updateCategory(@PathParam("categoryId") final String categoryId, final String jsonCategory) {
//        try {
//            Category category = parseCategory(jsonCategory);
//            category.setId(new Long(categoryId));
//            Category persistedCategory = categoryService.findCategory(new Long(categoryId));
//            return makeUpdate(persistedCategory, HTTP_OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.serverError().build();
//        }
//    }
//    
//    @DELETE
//    @Path("/{categoryId}")
//    public Response deleteCategory(@PathParam("categoryId") final String categoryId) {
//        Category category = categoryService.findCategory(new Long(categoryId));
//        return makeDelete(category, HTTP_DELETE);
//    }
//    
//    private Response makeUpdate(Category category, int responseCode) {
//        categoryService.updateCategory(category);
//        return Response.status(responseCode).build();
//    }
//    
//    private Response makeDelete(Category category, int responseCode) {
//        categoryService.deleteCategory(category);
//        return Response.status(responseCode).build();
//    }
//    
//    private Category parseCategory(final String jsonCategory) throws Exception{
//        Category newCategory = new Category();
//        ObjectMapper mapper = new ObjectMapper();
//        newCategory = mapper.readValue(jsonCategory, Category.class);
//        return newCategory;
//    }
//    
//    public ICategoryService getBookService() {
//        return categoryService;
//    }
//    
//    public void setBookService(final CategoryServiceImpl categoryService) {
//        this.categoryService = categoryService;
//    }
}
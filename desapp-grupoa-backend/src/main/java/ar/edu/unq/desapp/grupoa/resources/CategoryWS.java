package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

@Service
@Path("/categories")
public class CategoryWS {
    
    public static int HTTP_OK_CREATED = 201;
    
    public static int HTTP_OK = 200;
    
    public static int HTTP_DELETE = 204;

    private CategoryService categoryService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Category> getAllCategories() throws JsonGenerationException, JsonMappingException, IOException{
//    Category category = new Category("Ventas");
//
//    categoryService.save(category);

        List<Category> categorias = getCategoryService().retriveAll();
        return categorias;
    }
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
//    public CategoryWS() {}

//
//    @GET
//    @Path("/allCategories")
//    @Produces("application/json")
//    public List<Category> findAllCategories() {
//        return categoryService.findAllCategories();
//    }
//    
//    @GET
//    @Path("/getCategory/{categoryId}")
//    @Produces("application/json")
//    public Category findCategory(@PathParam("categoryId") final String bookId) {
//        return categoryService.findCategory(new Long(bookId));
//    }
//    
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
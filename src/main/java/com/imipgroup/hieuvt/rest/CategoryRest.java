package com.imipgroup.hieuvt.rest;

import com.imipgroup.hieuvt.entity.Category;
import com.imipgroup.hieuvt.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hieu.vutrong on 5/31/2015.
 */

@Component
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
public class CategoryRest {

    @Autowired
    CategoryService categoryService;

    protected final Logger log = LoggerFactory.getLogger(CategoryRest.class);

    @GET
    @Path("{id}")
    public Category getCategory(@PathParam("id") String id) {
        return categoryService.getCategory(new Integer(id));
    }

    @GET
    public List<Category> listCategoris() {
        return categoryService.listProducts();
    }

    @POST
    public Category createCategory(Category category) {
        return categoryService.createCategory(category);
    }

    @PUT
    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    @DELETE
    @Path("{id}")
    public void removeCategory(@PathParam("id") String id) {
        categoryService.removeCategory(new Integer(id));
    }

}

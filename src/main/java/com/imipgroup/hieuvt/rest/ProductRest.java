package com.imipgroup.hieuvt.rest;

import com.imipgroup.hieuvt.entity.Product;
import com.imipgroup.hieuvt.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
@Component
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})

public class ProductRest {

    @Autowired
    ProductService productService;

    protected final Logger log = LoggerFactory.getLogger(ProductRest.class);

    @GET
    @Path("{id}")
    public Product getProduct(@PathParam("id") String id) {
        return productService.getProduct( new Integer(id));
    }

    @GET
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @POST
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @PUT
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @DELETE
    @Path("{id}")
    public void removeProduct(@PathParam("id") String id) {
        productService.removeProduct(new Integer(id));
    }

    @GET
    @Path("/category")
    public List<Product> listProductByCategory(@QueryParam("categoryId") String categoryId){
        return productService.listProductByCategory(new Integer(categoryId));
    }

}
package com.imipgroup.hieuvt.rest;

import com.imipgroup.hieuvt.entity.Cart;
import com.imipgroup.hieuvt.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hieu.vutrong on 6/4/2015.
 */
@Component
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
public class CartRest {

    @Autowired
    private CartService cartService;

    protected final Logger log = LoggerFactory.getLogger(CartRest.class);

    @GET
    @Path("{id}")
    public Cart getCart(@PathParam("id") String id) {
        return cartService.getCart(new Integer(id));
    }

    @GET
    public List<Cart> listCarts() {
        return cartService.listCarts();
    }

    @POST
    public Cart createCart(Cart cart) {
        return cartService.createCart(cart);
    }

    @DELETE
    @Path("{id}")
    public void removeCart(@PathParam("id") String id) {
        cartService.removeCart(new Integer(id));
    }
}

package com.imipgroup.hieuvt.service;

import com.imipgroup.hieuvt.dao.CartDAO;
import com.imipgroup.hieuvt.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 6/4/2015.
 */

@Component
public class CartService {

    @Autowired
    private CartDAO cartDAO;

    public CartService() {

    }

    public List<Cart> listCarts() {
        return cartDAO.listCarts();
    }

    public Cart getCart(int cartId) {
        return cartDAO.getCart(cartId);
    }

    public Cart createCart(Cart cart){
        return cartDAO.createCart(cart);
    }

    public void removeCart(int cartId) {
        cartDAO.removeCart(cartId);
    }
}

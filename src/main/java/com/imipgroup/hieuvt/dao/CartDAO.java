package com.imipgroup.hieuvt.dao;

import com.imipgroup.hieuvt.entity.Cart;
import com.imipgroup.hieuvt.util.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 6/4/2015.
 */

@Component
public class CartDAO {

    public CartDAO() {

    }

    public Cart getCart(int cartId){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //Simple query
//        Order product = (Order) session.get(Order.class, productId);

        //A more general query
        Query query=session.createQuery("from Cart ca where ca.cartId=:cartId");
        query.setParameter("cartId", cartId);
        Cart cart = (Cart) query.uniqueResult();

        transaction.commit();
        session.close();
        return cart;
    }

    public Cart createCart(Cart cart){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(cart);

        transaction.commit();
        session.close();
        return cart;
    }

    public void removeCart(int orderId){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Cart cart = (Cart) session.get(Cart.class, orderId);
        session.delete(cart);

        transaction.commit();
        session.close();
    }

    public List<Cart> listCarts() {

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Cart ca");
        List<Cart> carts = query.list();
        transaction.commit();
        session.close();
        return carts;
    }
}

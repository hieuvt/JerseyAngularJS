package com.imipgroup.hieuvt.dao;

import com.imipgroup.hieuvt.entity.Product;
import com.imipgroup.hieuvt.util.DataUtil;
import com.imipgroup.hieuvt.util.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
@Component
public class ProductDAO {

    public ProductDAO() {
        DataUtil.getInstance();
    }

  /*  public BookVO getBookByName(String bookName){
        for (BookVO book: books){
            if (book.getBookName().equals(bookName)){
                return book;
            }
        }
        return null;
    }*/

    public Product getProduct(int productId){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //Simple query
//        Product product = (Product) session.get(Product.class, productId);

        //A more general query
        Query query=session.createQuery("from Product p where p.id=:productId");
        query.setParameter("productId", productId);
        Product product = (Product) query.uniqueResult();

        transaction.commit();
        session.close();
        return product;
    }

    public Product createProduct(Product product){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(product);

        transaction.commit();
        session.close();
        return product;
    }

    public Product updateProduct(Product product){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Product tmpProduct = (Product)session.get(Product.class, product.getProductId());
        tmpProduct.setDescription(product.getDescription());
        tmpProduct.setProductName(product.getProductName());
        tmpProduct.setCategory(product.getCategory());
        tmpProduct.setPrice(product.getPrice());

        transaction.commit();
        session.close();
        return tmpProduct;
    }

    public void removeProduct(int productId){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Product product = (Product) session.get(Product.class, productId);
        session.delete(product);

        transaction.commit();
        session.close();
    }

    public List<Product> listProducts() {

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Product p ");
        List<Product> products = query.list();
        transaction.commit();
        session.close();
        return products;
    }

    public List<Product> listProductByCategory(int categoryId){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Product p where p.category.catId =:categoryId");
        query.setParameter("categoryId", categoryId);
        List<Product> products = query.list();
        transaction.commit();
        session.close();
        return products;
    }
}

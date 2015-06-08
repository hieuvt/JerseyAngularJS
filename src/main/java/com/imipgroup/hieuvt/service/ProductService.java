package com.imipgroup.hieuvt.service;

import com.imipgroup.hieuvt.dao.ProductDAO;
import com.imipgroup.hieuvt.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 1/27/2015.
 */
@Component
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    public ProductService(){
    }

    public List<Product> listProducts() {
        return productDAO.listProducts();
    }

    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    public Product createProduct(Product product){
        return productDAO.createProduct(product);
    }

    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    public void removeProduct(int id) {
        productDAO.removeProduct(id);
    }

    public List<Product> listProductByCategory(int catId) {
        return productDAO.listProductByCategory(catId);
    }
}

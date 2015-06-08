package com.imipgroup.hieuvt.util;

import com.imipgroup.hieuvt.entity.Category;
import com.imipgroup.hieuvt.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hieu.vutrong on 1/27/2015.
 */
public class DataUtil {

    private static DataUtil instance = new DataUtil();

    public static DataUtil getInstance() {
        return instance;
    }

    private static final int NUM_BOOK = 5;
    public DataUtil(){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        List<Category> categories = Arrays.asList(
                new Category("Watersports"),
                new Category("Soccer"),
                new Category("Chess"),
                new Category("Basketball")
        );
        List<Product> products = Arrays.asList(
                new Product("Kayak", "A boat for one person", categories.get(0), 275),
                new Product("Lifejacket", "Protective and fashionable", categories.get(0), 48.95),
                new Product("Soccer Ball", "FIFA-approved size and weight", categories.get(1), 19.5),
                new Product("Corner Flags", "Give your playing field a professional touch", categories.get(1), 34.95),
                new Product("Stadium", "Flat-packed 35,000-seat stadium", categories.get(1), 79500),
                new Product("Thinking Cap", "Improve your brain efficiency by 75%", categories.get(2), 16),
                new Product("Unsteady Chair", "Secretly give your opponent a disadvantage", categories.get(2), 29.95),
                new Product("Human Chess Board", "A fun game for the family", categories.get(2), 75),
                new Product("Bling-Bling King", "Gold-plated, diamond-studded King", categories.get(2), 1200)
        );

        for (Product p: products){
            session.save(p);
        }
//        for (Category c: categories){
//            session.save(c);
//        }


        transaction.commit();
        session.close();
    }
}

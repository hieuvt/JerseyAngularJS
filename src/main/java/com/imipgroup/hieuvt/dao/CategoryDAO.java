package com.imipgroup.hieuvt.dao;

import com.imipgroup.hieuvt.entity.Category;
import com.imipgroup.hieuvt.util.DataUtil;
import com.imipgroup.hieuvt.util.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 5/31/2015.
 */
@Component
public class CategoryDAO {

    public CategoryDAO() {
        DataUtil.getInstance();
    }

    public Category getCategory(int catId){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //Simple query
//        Category category = (Category) session.get(Category.class, catId);

        //A more general query
        Query query=session.createQuery("from Category c where c.id=:catId");
        query.setParameter("catId", catId);
        Category category = (Category) query.uniqueResult();

        transaction.commit();
        session.close();
        return category;
    }

    public Category createCategory(Category category){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(category);

        transaction.commit();
        session.close();
        return category;
    }

    public Category updateCategory(Category category){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Category tmpCat = (Category)session.get(Category.class, category.getCatId());
        tmpCat.setCatName(category.getCatName());

        transaction.commit();
        session.close();
        return tmpCat;
    }

    public void removeCategory(int catId){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Category category = (Category) session.get(Category.class, catId);
        session.delete(category);

        transaction.commit();
        session.close();
    }

    public List<Category> listCategories(){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Category c");
        List<Category> categories = query.list();
        transaction.commit();
        session.close();
        return categories;
    }
}

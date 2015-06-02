package com.imipgroup.hieuvt.service;

import com.imipgroup.hieuvt.dao.CategoryDAO;
import com.imipgroup.hieuvt.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 5/31/2015.
 */
@Component
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public CategoryService(){
    }

    public List<Category> listProducts() {
        return categoryDAO.listCategories();
    }

    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    public Category createCategory(Category category){
        return categoryDAO.createCategory(category);
    }

    public Category updateCategory(Category category) {
        return categoryDAO.updateCategory(category);
    }

    public void removeCategory(int id) {
        categoryDAO.removeCategory(id);
    }
}

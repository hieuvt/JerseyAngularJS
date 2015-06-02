package com.imipgroup.hieuvt.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by hieu.vutrong on 5/28/2015.
 */

@Entity
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int catId;

    @Column
    private String catName;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    @JoinColumn
//    private Set<Product> products;

    public Category(){

    }

    public Category(String catName){
        setCatName(catName);
    }

    public int getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
}

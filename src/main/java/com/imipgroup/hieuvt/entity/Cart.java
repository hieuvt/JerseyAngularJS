package com.imipgroup.hieuvt.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by hieu.vutrong on 6/4/2015.
 */

@Entity
public class Cart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private Set<LineItem> lineItems;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private boolean giftwrap;

    @Column
    private String status = "Pending";

    public Cart(){

    }

    public int getCartId() {
        return cartId;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGiftwrap() {
        return giftwrap;
    }

    public void setGiftwrap(boolean giftwrap) {
        this.giftwrap = giftwrap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

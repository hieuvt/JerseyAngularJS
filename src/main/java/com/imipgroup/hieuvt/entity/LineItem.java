package com.imipgroup.hieuvt.entity;

import javax.persistence.*;

/**
 * Created by hieu.vutrong on 6/4/2015.
 */
@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lineItemId;

    @ManyToOne
    private Product product;

    @Column
    private int quantity;

    public LineItem() {

    }

    public int getLineItemId() {
        return lineItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

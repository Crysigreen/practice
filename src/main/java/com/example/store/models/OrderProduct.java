package com.example.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_product")
public class OrderProduct extends  BaseEntity{
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Product getProduct(){ return product; }

    public void setProduct(Product product) { this.product = product; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}

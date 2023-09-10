package com.example.store.models;

import jakarta.persistence.*;
import com.example.store.models.Client;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;

    private Double price;

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public List<ProductCategory> getCategories() {
        return productCategories;
    }
    public void setCategories(List<ProductCategory> categories) {
        this.productCategories = categories;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}

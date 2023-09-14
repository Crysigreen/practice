package com.example.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.example.store.models.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderProduct> orderProducts;

    public Product() {
    }

    public Product(String name, Double price, Category category, Set<OrderProduct> orderProducts) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.orderProducts = orderProducts;
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
    public Category getCategory(){ return category; }
    public void setCategory(Category category) { this.category = category;}

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}

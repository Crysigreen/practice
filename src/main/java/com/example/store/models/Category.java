package com.example.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategories;

    // Constructors, getters, and setters

    protected Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductCategory> getProducts() {
        return productCategories;
    }

    public void setProducts(List<ProductCategory> products) {
        this.productCategories = products;
    }
}

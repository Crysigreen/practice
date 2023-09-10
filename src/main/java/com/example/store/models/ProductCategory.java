package com.example.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Геттеры, сеттеры и другие поля

    public ProductCategory() {
    }

    public ProductCategory(Product product, Category category) {
        this.category = category;
        this.product = product;
    }


    public Product getProduct(){ return product; }
    public void setProduct(Product product) { this.product = product; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}


package com.example.store.dtos;

import com.example.store.models.Category;
import com.example.store.models.OrderProduct;


import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Long categoryId;


    // Constructors, getters, and setters

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name,Double price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

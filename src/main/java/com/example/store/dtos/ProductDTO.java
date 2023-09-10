package com.example.store.dtos;

import com.example.store.models.Category;
import com.example.store.models.OrderProduct;
import com.example.store.models.ProductCategory;

import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private List<Integer> categoryIds;


    // Constructors, getters, and setters

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, List<Integer> categoryIds) {
        this.id = id;
        this.name = name;
        this.categoryIds = categoryIds;
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

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}

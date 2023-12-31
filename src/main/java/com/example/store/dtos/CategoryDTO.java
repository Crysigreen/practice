package com.example.store.dtos;



import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;
//    private List<ProductCategory> productCategories;

    // Constructors, getters, and setters

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
//        this.productCategories = productCategories;
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

}

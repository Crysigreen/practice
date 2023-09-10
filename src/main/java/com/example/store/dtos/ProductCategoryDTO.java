package com.example.store.dtos;

public class ProductCategoryDTO {
    private Long id;
    private ProductDTO productDTO;
    private CategoryDTO categoryDTO;


    public ProductCategoryDTO(){

    }
    public ProductCategoryDTO(Long id, ProductDTO productDTO, CategoryDTO categoryDTO){
        this.id = id;
        this.productDTO = productDTO;
        this.categoryDTO = categoryDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() { return productDTO; }

    public void setProduct(ProductDTO productDTO){this.productDTO = productDTO; }

    public CategoryDTO getCategory(){ return categoryDTO; }

    public void setCategory(CategoryDTO categoryDTO){ this.categoryDTO = categoryDTO; }

}

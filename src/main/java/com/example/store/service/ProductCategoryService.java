package com.example.store.service;

import com.example.store.dtos.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService<ID> {

    List<ProductCategoryDTO> getAllProductCategories();

    ProductCategoryDTO getProductCategoryById(Long productCategoryId);

    ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDto);

//    ProductCategoryDTO updateProductCategory(Long productCategoryId, ProductCategoryDTO productCategoryDto);

    void deleteProductCategory(Long productCategoryId);

}

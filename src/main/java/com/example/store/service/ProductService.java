package com.example.store.service;

import com.example.store.dtos.ProductDTO;

import java.util.List;

public interface ProductService<ID> {
    List<ProductDTO> getProductsByCategory(Long categoryId);
    ProductDTO createProduct(ProductDTO product);
    List<ProductDTO> getAllProducts();
    ProductDTO updateProduct(Long productId, ProductDTO productDto);
    void deleteProduct(Long productId);
}

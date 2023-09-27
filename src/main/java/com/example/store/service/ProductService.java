package com.example.store.service;

import com.example.store.dtos.ProductCategoryDTO;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Product;

import java.util.List;

public interface ProductService<ID> {
    List<ProductCategoryDTO> getAllProductsInCategory(Long categoryId);
    ProductDTO createProduct(ProductDTO product);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> findProductsOrderedByClient(Long clientId);
    ProductDTO updateProduct(Long productId, ProductDTO productDto);
    void deleteProduct(Long productId);
}

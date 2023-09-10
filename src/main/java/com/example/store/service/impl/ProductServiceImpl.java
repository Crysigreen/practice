package com.example.store.service.impl;
import com.example.store.models.Category;
import com.example.store.models.ProductCategory;
import com.example.store.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.store.dtos.ClientDTO;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Product;
import com.example.store.repositories.ProductRepository;
import com.example.store.service.ProductService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService<Integer> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());

        List<ProductCategory> productCategories = new ArrayList<>();
        for (Integer categoryId : productDTO.getCategoryIds()) {  // Update the loop variable type to Integer
            Category category = categoryRepository.findById(categoryId.longValue()).orElse(null);  // Convert the Integer to Long
            if (category != null) {
                ProductCategory productCategory = new ProductCategory();
                productCategory.setProduct(product);
                productCategory.setCategory(category);
                productCategories.add(productCategory);
            }
        }
        product.setCategories(productCategories);

        product = productRepository.save(product);

        ProductDTO createdProductDTO = new ProductDTO();
        createdProductDTO.setId((long) product.getId());
        createdProductDTO.setName(product.getName());
        createdProductDTO.setCategoryIds(productDTO.getCategoryIds());

        return createdProductDTO;
    }
    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map((s) -> modelMapper.map(s, ProductDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        List<Product> products = productRepository.findAllByCategories(category);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDto) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setName(productDto.getName());
            return  modelMapper.map(productRepository.save(existingProduct),ProductDTO.class);
        }
        return null;
    }

}

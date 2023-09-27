package com.example.store.service.impl;
import com.example.store.dtos.ProductCategoryDTO;
import com.example.store.models.Category;
import com.example.store.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Product;
import com.example.store.repositories.ProductRepository;
import com.example.store.service.ProductService;
import org.modelmapper.ModelMapper;

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
        product.setPrice(productDTO.getPrice());

        Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategoryId());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            product.setCategory(category);
            Product saveProduct = productRepository.save(product);

            return modelMapper.map(saveProduct, ProductDTO.class);
            
        } else {
            throw new EntityNotFoundException("Category not found"); // Обработка случая, если категория не найдена
        }
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
    public List<ProductCategoryDTO> getAllProductsInCategory(Long categoryId) {
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        List<ProductCategoryDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductCategoryDTO.class))
                .collect(Collectors.toList());

        return productDTOs;
    }

    @Override
    public List<ProductDTO> findProductsOrderedByClient(Long clientId) {

        List<Product> products = productRepository.findProductsOrderedByClient(clientId);
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
            existingProduct.setPrice(productDto.getPrice());

            Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
            if (categoryOptional.isPresent()){
                Category category = categoryOptional.get();
                existingProduct.setCategory(category);
            }
            //Product updateProduct = productRepository.save(existingProduct);

            return  modelMapper.map(productRepository.save(existingProduct),ProductDTO.class);
        }
        return null;
    }

}

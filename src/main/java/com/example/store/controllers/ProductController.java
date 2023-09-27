package com.example.store.controllers;

import com.example.store.dtos.ClientDTO;
import com.example.store.dtos.ProductCategoryDTO;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Category;
import com.example.store.models.Product;
import com.example.store.repositories.CategoryRepository;
import com.example.store.repositories.ProductRepository;
import com.example.store.service.ClientService;
import com.example.store.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/ordered-by-client/{clientId}")
    public ResponseEntity<List<ProductDTO>> getProductsOrderedByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(productService.findProductsOrderedByClient(clientId));
    }

    @GetMapping("/product/category/{categoryId}")
    public ResponseEntity<List<ProductCategoryDTO>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductCategoryDTO> products = productService.getAllProductsInCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/product/{Id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long Id) {
        productService.deleteProduct(Id);
        return ResponseEntity.ok("Product with ID " + Id + " has been deleted.");
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Optional<ProductDTO> productOptional = Optional.ofNullable(productService.updateProduct(id,productDTO));
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.example.store.service.impl;

import com.example.store.dtos.CategoryDTO;
import com.example.store.dtos.ProductCategoryDTO;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Product;
import com.example.store.models.ProductCategory;
import com.example.store.repositories.ProductCategoryRepository;
import com.example.store.service.ProductCategoryService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductCategoryServiceImpl implements ProductCategoryService<Integer> {

    private ProductCategoryRepository productCategoryRepository;

    private ModelMapper modelMapper;


    @Override
    public List<ProductCategoryDTO> getAllProductCategories() {
        return productCategoryRepository.findAll().stream().map((s) -> modelMapper.map(s, ProductCategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDTO getProductCategoryById(Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new NoSuchElementException("Product Category not found with ID: " + productCategoryId));
        return convertToDto(productCategory);
    }

    @Override
    public ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDto) {
        ProductCategory productCategory = convertToEntity(productCategoryDto);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return convertToDto(savedProductCategory);
    }

//    @Override
//    public ProductCategoryDTO updateProductCategory(Long productCategoryId, ProductCategoryDTO productCategoryDTO) {
//        Optional<ProductCategory> productCategory = productCategoryRepository.findById(productCategoryId);
//        if (productCategory.isPresent()) {
//            ProductCategory existingProductCategory = productCategory.get();
//            existingProductCategory.setProduct(productCategoryDTO.getProduct());
//            existingProductCategory.setCategory(productCategoryDTO.getCategory());
//            return  modelMapper.map(productCategoryRepository.save(existingProductCategory), ProductCategoryDTO.class);
//        }
//        return null;
//
//        ProductCategory existingProductCategory = productCategoryRepository.findById(productCategoryId)
//                .orElseThrow(() -> new NoSuchElementException("Product Category not found with ID: " + productCategoryId));
//
//        // Update the existing product category with the new data
//        existingProductCategory.setProduct(productCategoryDto.getProduct());
//        existingProductCategory.setCategory(productCategoryDto.getCategory());
//
//        ProductCategory updatedProductCategory = productCategoryRepository.save(existingProductCategory);
//        return convertToDto(updatedProductCategory);
//
//    }
//    @Override
//    public ProductCategoryDTO updateProductCategory(Long productCategoryId, ProductCategoryDTO productCategoryDto) {
//        ProductCategory existingProductCategory = productCategoryRepository.findById(productCategoryId)
//                .orElseThrow(() -> new NoSuchElementException("Product Category not found with ID: " + productCategoryId));
//
//        // Обновляем только те поля, которые указаны в DTO
//        if (productCategoryDto.getProduct() != null) {
//            existingProductCategory.setProduct(productCategoryDto.getProduct());
//        }
//        if (productCategoryDto.getCategory() != null) {
//            existingProductCategory.setCategory(productCategoryDto.getCategory());
//        }
//
//        ProductCategory updatedProductCategory = productCategoryRepository.save(existingProductCategory);
//        return convertToDto(updatedProductCategory);
//    }

    @Override
    public void deleteProductCategory(Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new NoSuchElementException("Product Category not found with ID: " + productCategoryId));

        productCategoryRepository.delete(productCategory);
    }

    // Приватный метод для преобразования ProductCategory в ProductCategoryDto
    private ProductCategoryDTO convertToDto(ProductCategory productCategory) {
        return modelMapper.map(productCategory, ProductCategoryDTO.class);
    }

    // Приватный метод для преобразования ProductCategoryDto в ProductCategory
    private ProductCategory convertToEntity(ProductCategoryDTO productCategoryDto) {
        return modelMapper.map(productCategoryDto, ProductCategory.class);
    }
}

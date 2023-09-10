package com.example.store.service;

import com.example.store.dtos.CategoryDTO;

import java.util.List;

public interface CategoryService<ID> {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long categoryId);
    CategoryDTO createCategory(CategoryDTO categoryDto);
    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDto);
    void deleteCategory(Long categoryId);
}

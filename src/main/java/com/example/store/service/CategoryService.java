package com.example.store.service;

import com.example.store.dtos.CategoryDTO;
import com.example.store.models.Category;

import java.util.List;

public interface CategoryService<ID> {
    List<CategoryDTO> getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDto);
    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDto);
    void deleteCategory(Long categoryId);
}

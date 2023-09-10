package com.example.store.service.impl;

import com.example.store.dtos.CategoryDTO;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Category;
import com.example.store.repositories.CategoryRepository;
import com.example.store.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService<Integer> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map((s) -> modelMapper.map(s, CategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return modelMapper.map(category, CategoryDTO.class);
        }
        return null;
    }
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }
    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            return modelMapper.map(categoryRepository.save(category),CategoryDTO.class);
        }
        return null;
    }
    @Override
    public void deleteCategory(Long categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        }
    }



}

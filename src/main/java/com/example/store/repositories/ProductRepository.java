package com.example.store.repositories;

import com.example.store.models.Category;
import com.example.store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllById(Iterable<Long> ids);
    List<Product> findAllByCategories(Category category);
    // Custom queries if needed
}

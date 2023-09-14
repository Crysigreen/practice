package com.example.store.repositories;

import com.example.store.models.Category;
import com.example.store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") Long categoryId);

    // Custom queries if needed
}

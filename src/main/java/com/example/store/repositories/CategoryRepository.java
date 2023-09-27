package com.example.store.repositories;

import com.example.store.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT DISTINCT cat FROM Category cat " +
            "JOIN cat.product p " +
            "JOIN p.orderProducts op " +
            "JOIN op.order o " +
            "JOIN o.client c " +
            "WHERE c.id = :clientId")
    List<Category> getCategoriesOrderedByClient(@Param("clientId") Long clientId);



}

package com.example.store.repositories;

import com.example.store.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT DISTINCT c FROM Client c " +
            "JOIN c.orders o " +
            "JOIN o.orderProducts op " +
            "JOIN op.product p " +
            "WHERE p.category.id = :categoryId")
    List<Client> getClientsWithOrdersInCategory(@Param("categoryId") Long categoryId);



}

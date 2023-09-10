package com.example.store.dtos;

import com.example.store.models.Order;

import java.util.List;

public class ClientDTO {
    private Long id;
    private String name;
    private String email;



    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String email, String role, OrderDTO order) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

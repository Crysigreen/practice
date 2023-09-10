package com.example.store.dtos;

import java.util.List;
import java.util.Optional;

public class OrderDTO {
    private Long id;
    private Long clientId;
    private List<Long> productIds;

    // Constructors, getters, and setters

    public OrderDTO() {
    }

    public OrderDTO(Long id, Long clientId, List<Long> productIds) {
        this.id = id;
        this.clientId = clientId;
        this.productIds = productIds;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }





}

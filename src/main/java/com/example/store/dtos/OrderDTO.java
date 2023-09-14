package com.example.store.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class OrderDTO {
    private Long id;
    private Long clientId;
    private List<Long> productIds;
    private LocalDateTime dateTimeOrder;
    private String status;

    // Constructors, getters, and setters

    public OrderDTO() {
    }

    public OrderDTO(Long id,Long clientId, List<Long> productIds, LocalDateTime dateTimeOrder, String status) {
        this.id = id;
        this.clientId = clientId;
        this.productIds = productIds;
        this.dateTimeOrder = dateTimeOrder;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient() { return clientId; }

    public void setClient(Long clientId) { this.clientId = clientId;}

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> ProductIds) {
        this.productIds = ProductIds;
    }

    public LocalDateTime getDateTimeOrder() { return dateTimeOrder; }

    public void setDateTimeOrder(LocalDateTime dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

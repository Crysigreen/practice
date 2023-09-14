package com.example.store.dtos;

import com.example.store.models.Order;
import com.example.store.models.Product;

import java.util.List;

public class OrderProductDTO {
    private Long id;
    private Long orderId;
    private Long productId;

    public OrderProductDTO() {
    }

    public OrderProductDTO(Long id, Long orderId, Long productId) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}

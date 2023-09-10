package com.example.store.dtos;

import com.example.store.models.Order;
import com.example.store.models.Product;

import java.util.List;

public class OrderProductDTO {
    private Long id;
    private OrderDTO orderDTO;
    private ProductDTO productDTO;

    public OrderProductDTO() {
    }

    public OrderProductDTO(Long id, OrderDTO orderDTO, ProductDTO productDTO) {
        this.id = id;
        this.orderDTO = orderDTO;
        this.productDTO = productDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct(){ return productDTO; }

    public void setProduct(ProductDTO productDTO) { this.productDTO = productDTO; }
    public OrderDTO getOrder() { return orderDTO; }
    public void setOrder(OrderDTO orderDTO) { this.orderDTO = orderDTO; }

}

package com.example.store.service;

import com.example.store.dtos.OrderDTO;
import com.example.store.models.Order;

import java.util.List;


public interface OrderService<ID> {
    OrderDTO createOrder(OrderDTO product);
    List<OrderDTO> getAllOrders();
    OrderDTO updateOrder(Long orderId, OrderDTO orderDTO);
    void deleteOrder(Long orderId);
}

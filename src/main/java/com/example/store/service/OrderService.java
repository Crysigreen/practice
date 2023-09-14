package com.example.store.service;

import com.example.store.dtos.OrderDTO;
import com.example.store.models.Order;

import java.util.List;
import java.util.Optional;


public interface OrderService<ID> {
    OrderDTO createOrder(OrderDTO product);
    List<OrderDTO> getOrdersForClient(Long id);
    List<OrderDTO> getAllOrders();
    Optional<OrderDTO> updateOrder(Long orderId, OrderDTO orderDTO);
    void deleteOrder(Long orderId);
}

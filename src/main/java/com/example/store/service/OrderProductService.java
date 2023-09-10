package com.example.store.service;

import com.example.store.dtos.ClientDTO;
import com.example.store.dtos.OrderProductDTO;

import java.util.List;

public interface OrderProductService<ID> {
    OrderProductDTO createOrderProduct (OrderProductDTO orderProductDTO);

    List<OrderProductDTO> getAll();

//    OrderProductDTO updateOrderProduct (Long id, OrderProductDTO orderProductDTO);

    void delete(Long id);
}

package com.example.store.service.impl;

import com.example.store.dtos.OrderDTO;
import com.example.store.dtos.OrderProductDTO;
import com.example.store.models.Order;
import com.example.store.models.OrderProduct;
import com.example.store.repositories.OrderProductRepository;
import com.example.store.service.OrderProductService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderProductServiceImpl implements OrderProductService<Integer> {
    private OrderProductRepository orderProductRepository;
    private ModelMapper modelMapper;

    @Override
    public OrderProductDTO createOrderProduct(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = modelMapper.map(orderProductDTO, OrderProduct.class);
        return modelMapper.map(orderProductRepository.save(orderProduct),OrderProductDTO.class);
    }
    @Override
    public List<OrderProductDTO> getAll() {
        return orderProductRepository.findAll().stream().map((s) -> modelMapper.map(s, OrderProductDTO.class)).collect(Collectors.toList());
    }

//    @Override
//    public OrderProductDTO updateOrderProduct(Long id, OrderProductDTO orderProductDTO) {
//        Optional<OrderProduct> orderProduct = orderProductRepository.findById(id);
//        if (orderProduct.isPresent()) {
//            OrderProduct existingOrderProduct = orderProduct.get();
//            existingOrderProduct.setProduct(orderProductDTO.getProduct());
//            existingOrderProduct.setOrder(orderProductDTO.getOrder());
//            return modelMapper.map(orderProductRepository.save(existingOrderProduct),OrderProductDTO.class);
//        }
//        return null;
//    }

    @Override
    public void delete(Long id) {
        Optional<OrderProduct> optionalOrderProduct = orderProductRepository.findById(id);
        orderProductRepository.delete(optionalOrderProduct.get());
    }


}

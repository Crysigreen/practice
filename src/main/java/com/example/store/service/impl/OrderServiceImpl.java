package com.example.store.service.impl;

import com.example.store.dtos.OrderDTO;
import com.example.store.models.Client;
import com.example.store.models.Order;
import com.example.store.models.OrderProduct;
import com.example.store.models.Product;
import com.example.store.repositories.ClientRepository;
import com.example.store.repositories.OrderProductRepository;
import com.example.store.repositories.OrderRepository;
import com.example.store.repositories.ProductRepository;
import com.example.store.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService<Integer> {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        order.setClient(clientRepository.findById(orderDTO.getClientId()).orElse(null));
        order = orderRepository.save(order);

        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());
        for (Product product : products) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProductRepository.save(orderProduct);
        }

        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map((s) -> modelMapper.map(s, OrderDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            Order existingOrder = order.get();
            return modelMapper.map(orderRepository.save(existingOrder),OrderDTO.class);
        }
        return null;
    }
    @Override
    public void deleteOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        orderRepository.delete(optionalOrder.get());
    }
}

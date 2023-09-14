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
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

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

        Order order = new Order();
        order.setStatus(orderDTO.getStatus());
        order.setDateTimeOrder(orderDTO.getDateTimeOrder());

        Optional<Client> clientOptional = clientRepository.findById(orderDTO.getClient());

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            order.setClient(client);
        } else {
            throw new EntityNotFoundException("Client not found"); // Обработка случая, если клиент не найден
        }

        List<Long> productIds = orderDTO.getProductIds();
        Set<OrderProduct> orderProducts = new HashSet<>();
        for (Long productId : productIds) {
            Optional<Product> productOptional = productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                OrderProduct orderProduct = new OrderProduct(order, product);
                orderProducts.add(orderProduct);
            } else {
                throw new EntityNotFoundException("Product not found");
            }
        }

        order.setOrderProducts(orderProducts);

        Order savedOrder = orderRepository.save(order);

        OrderDTO createdOrderDTO = new OrderDTO();
        createdOrderDTO.setId(savedOrder.getId());
        createdOrderDTO.setStatus(savedOrder.getStatus());
        createdOrderDTO.setDateTimeOrder(savedOrder.getDateTimeOrder());
        createdOrderDTO.setClient(savedOrder.getClient().getId());
        createdOrderDTO.setProductIds(productIds);

        return createdOrderDTO;

    }

    @Override
    public List<OrderDTO> getOrdersForClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        List<Order> orders = orderRepository.findAllByClient(client);

        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setClient(order.getClient().getId());
            orderDTO.setDateTimeOrder(order.getDateTimeOrder());
            orderDTO.setStatus(order.getStatus());
            List<Long> productIds = order.getOrderProducts().stream()
                    .map(orderProduct -> orderProduct.getProduct().getId())
                    .collect(Collectors.toList());
            orderDTO.setProductIds(productIds);

            orderDTOs.add(orderDTO);
        }

        return orderDTOs;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll(); // Получаем все заказы из базы данных


        Type listType = new TypeToken<List<OrderDTO>>() {}.getType();

        List<OrderDTO> orderDTO = modelMapper.map(orders, listType);

        return orderDTO;
    }

    @Override
    public Optional<OrderDTO> updateOrder(Long id, OrderDTO orderDTO) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            Order existingOrder = order.get();
            modelMapper.map(orderDTO, existingOrder);
            return Optional.ofNullable(modelMapper.map(orderRepository.save(existingOrder), OrderDTO.class));
        }
        return null;
    }
    @Override
    public void deleteOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        orderRepository.delete(optionalOrder.get());
    }
}

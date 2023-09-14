package com.example.store.controllers;

import com.example.store.dtos.ClientDTO;
import com.example.store.dtos.OrderDTO;
import com.example.store.models.Client;
import com.example.store.models.Order;
import com.example.store.repositories.ClientRepository;
import com.example.store.repositories.OrderRepository;
import com.example.store.service.ClientService;
import com.example.store.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/order")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> getOrderById() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/order/client/{Id}")
    public ResponseEntity<List<OrderDTO>> getOrdersForClient(@PathVariable Long Id) {
        List<OrderDTO> orders = orderService.getOrdersForClient(Id);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        Optional<OrderDTO> updatedOrder = orderService.updateOrder(id, orderDTO);
        if (updatedOrder.isPresent()) {
            return ResponseEntity.ok(updatedOrder.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }




}

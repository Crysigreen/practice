package com.example.store.controllers;

import com.example.store.dtos.ClientDTO;
import com.example.store.dtos.OrderDTO;
import com.example.store.models.Client;
import com.example.store.models.Order;
import com.example.store.repositories.ClientRepository;
import com.example.store.service.ClientService;
import com.example.store.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class OrderController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderService orderService;


    @PostMapping("/order")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }



}

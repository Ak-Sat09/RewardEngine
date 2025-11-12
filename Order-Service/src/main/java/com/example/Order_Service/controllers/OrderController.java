package com.example.Order_Service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Order_Service.dtos.Order;
import com.example.Order_Service.producer.OrderProducer;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> sendOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return ResponseEntity.ok("Order sent to Kafka: " + order.getId());
    }
}
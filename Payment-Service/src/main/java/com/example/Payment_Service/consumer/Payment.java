package com.example.Payment_Service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.Payment_Service.dtos.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Payment {

    @KafkaListener(topics = "orders", groupId = "order_group")
    public void consumeOrder(String orderJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(orderJson, Order.class);
        System.out.println("Order received: " + order);
    }

}

package com.example.Order_Service.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.Order_Service.dtos.Order;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "orders";

    public void sendOrder(Order order) {
        kafkaTemplate.send(TOPIC, order);
        System.out.println("Order sent: " + order);
    }
}

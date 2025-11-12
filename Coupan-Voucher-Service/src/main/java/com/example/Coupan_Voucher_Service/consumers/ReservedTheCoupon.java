package com.example.Coupan_Voucher_Service.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.Coupan_Voucher_Service.events.Order;
import com.example.Coupan_Voucher_Service.repo.CouponRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReservedTheCoupon {

    @Autowired
    private CouponRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "orders", groupId = "order_group")
    public void consumeOrder(String orderJson) throws Exception {
        Order order = mapper.readValue(orderJson, Order.class);

        Long couponId = order.getId(); // Correct ID

        repository.findById(couponId).ifPresent(coupon -> {
            if (coupon.isReserved()) {
                System.out.println("Coupon already reserved or sold!");
                return;
            }

            // Reserve the coupon
            coupon.setReserved(true);
            repository.save(coupon);

            System.out.println("Coupon reserved, Coupon ID: " + couponId);
        });
    }
}

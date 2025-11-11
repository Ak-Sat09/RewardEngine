package com.example.Coupan_Voucher_Service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "couponandvouchers") // table name lowercase standard
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    private Double price;

    private Long ownerId;

    private Long buyerId;

    // private LocalDate expiryDate;

}

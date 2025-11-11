package com.example.Coupan_Voucher_Service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Coupan_Voucher_Service.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

}

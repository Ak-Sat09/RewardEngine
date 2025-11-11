package com.example.Coupan_Voucher_Service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Coupan_Voucher_Service.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("SELECT c.buyerId FROM Coupon c WHERE c.id = :couponId")
    Long findBuyerIdByCouponId(@Param("couponId") Long couponId);
}

package com.example.Coupan_Voucher_Service.services.fetechServices;

import java.util.List;
import java.util.Optional;

import com.example.Coupan_Voucher_Service.dtos.CouponResponseDTO;
import com.example.Coupan_Voucher_Service.entities.Coupon;

public interface CouponFetch {
    Optional<Coupon> getById(Long id, String token);

    List<CouponResponseDTO> getAll();

    String DeleteById(Long Id);

}

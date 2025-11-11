package com.example.Coupan_Voucher_Service.services.creationService;

import com.example.Coupan_Voucher_Service.dtos.CouponCreateDTO;
import com.example.Coupan_Voucher_Service.dtos.CouponResponseDTO;

public interface CouponCreate {

    CouponResponseDTO createCoupon(CouponCreateDTO dto, String token);
}

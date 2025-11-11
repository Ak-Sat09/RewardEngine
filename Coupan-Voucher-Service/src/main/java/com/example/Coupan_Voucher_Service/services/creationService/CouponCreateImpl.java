package com.example.Coupan_Voucher_Service.services.creationService;

import org.springframework.stereotype.Service;
import com.example.Coupan_Voucher_Service.dtos.CouponCreateDTO;
import com.example.Coupan_Voucher_Service.dtos.CouponResponseDTO;
import com.example.Coupan_Voucher_Service.entities.Coupon;
import com.example.Coupan_Voucher_Service.repo.CouponRepository;
import lombok.RequiredArgsConstructor;

@Service("normal")
@RequiredArgsConstructor
public class CouponCreateImpl implements CouponCreate {

    private final CouponRepository repository;

    @Override
    public CouponResponseDTO createCoupon(CouponCreateDTO dto) {

        // 1. Build entity
        Coupon coupon = Coupon.builder()
                .code(dto.code())
                .description(dto.description())
                .build();

        // 2. Save to DB
        Coupon saved = repository.save(coupon);

        // 3. Return DTO
        return new CouponResponseDTO(
                saved.getId(),
                "AKS****",
                saved.getDescription());
    }
}

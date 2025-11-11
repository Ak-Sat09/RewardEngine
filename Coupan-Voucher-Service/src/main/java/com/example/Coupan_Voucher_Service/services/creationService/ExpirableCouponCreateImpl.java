// package com.example.Coupan_Voucher_Service.services.creationService;

// import org.springframework.stereotype.Service;

// import com.example.Coupan_Voucher_Service.dtos.CouponCreateDTO;
// import com.example.Coupan_Voucher_Service.dtos.CouponResponseDTO;
// import com.example.Coupan_Voucher_Service.entities.Coupon;
// import com.example.Coupan_Voucher_Service.repo.CouponRepository;

// import lombok.RequiredArgsConstructor;

// @Service("expirable")
// @RequiredArgsConstructor
// public class ExpirableCouponCreateImpl implements CouponCreate {

// private final CouponRepository repository;

// @Override
// public CouponResponseDTO createCoupon(CouponCreateDTO dto) {
// var coupon = Coupon.builder()
// .code(dto.code())
// .description(dto.description())
// .expiryDate(dto.expiryDate())
// .build();

// var saved = repository.save(coupon);

// return new CouponResponseDTO(saved.getId(), saved.getCode(),
// saved.getDescription());
// }
// }

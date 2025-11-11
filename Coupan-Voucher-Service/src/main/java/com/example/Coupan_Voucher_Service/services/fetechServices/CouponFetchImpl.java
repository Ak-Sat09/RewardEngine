package com.example.Coupan_Voucher_Service.services.fetechServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Coupan_Voucher_Service.dtos.CouponResponseDTO;
import com.example.Coupan_Voucher_Service.entities.Coupon;
import com.example.Coupan_Voucher_Service.repo.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponFetchImpl implements CouponFetch {

    private final CouponRepository repository;
    private final com.example.Coupan_Voucher_Service.config.JwtUtils jwtUtils;

    @Override
    public Optional<Coupon> getById(Long id, String token) {
        Long userId = Long.parseLong(jwtUtils.getUserIdFromToken(token));

        // Fetch coupon
        Optional<Coupon> optionalCoupon = repository.findById(id);
        if (optionalCoupon.isEmpty()) {
            return Optional.empty();
        }

        Coupon coupon = optionalCoupon.get();

        // Check if buyerId exists and matches token userId
        Long buyerId = repository.findBuyerIdByCouponId(id);
        if (buyerId == null || !buyerId.equals(userId)) {
            // Mask code if not owner/buyer
            coupon.setCode("AKS****");
        }

        return Optional.of(coupon);
    }

    @Override
    public List<CouponResponseDTO> getAll() {
        // fetch all Coupon entities
        List<Coupon> coupons = repository.findAll();

        // map each Coupon to CouponResponseDTO with masked code
        return coupons.stream()
                .map(coupon -> new CouponResponseDTO(
                        coupon.getId(),
                        "AKS****", // masking as you wrote
                        coupon.getDescription(),
                        coupon.getPrice(),
                        coupon.getOwnerId()))
                .toList();
    }

    @Override
    public String DeleteById(Long Id) {
        repository.deleteById(Id);
        return "Coupon Deleted";
    }

}

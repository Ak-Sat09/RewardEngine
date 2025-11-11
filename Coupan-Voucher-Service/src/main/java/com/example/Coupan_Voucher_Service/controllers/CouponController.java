package com.example.Coupan_Voucher_Service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coupan_Voucher_Service.dtos.CouponCreateDTO;
import com.example.Coupan_Voucher_Service.dtos.CouponResponseDTO;
import com.example.Coupan_Voucher_Service.entities.Coupon;
import com.example.Coupan_Voucher_Service.services.creationService.CouponCreateImpl;
import com.example.Coupan_Voucher_Service.services.fetechServices.CouponFetchImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponCreateImpl service;
    private final CouponFetchImpl fetchImpl;

    @PostMapping
    public ResponseEntity<CouponResponseDTO> createCopon(@RequestBody CouponCreateDTO dto,
            @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer", "").trim();
        return ResponseEntity.ok(service.createCoupon(dto, token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Coupon>> getCouponById(
            @PathVariable Long id,
            @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.replace("Bearer", "").trim();
        return ResponseEntity.ok(fetchImpl.getById(id, token));
    }

    @GetMapping
    public ResponseEntity<List<CouponResponseDTO>> getAllCoupons() {
        return ResponseEntity.ok(fetchImpl.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteviaId(@PathVariable Long id) {
        return ResponseEntity.ok(fetchImpl.DeleteById(id));
    }

}

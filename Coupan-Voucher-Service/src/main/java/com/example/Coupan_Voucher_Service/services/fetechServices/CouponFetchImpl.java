package com.example.Coupan_Voucher_Service.services.fetechServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Coupan_Voucher_Service.entities.Coupon;
import com.example.Coupan_Voucher_Service.repo.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponFetchImpl implements CouponFetch {

    private final CouponRepository repository;

    @Override
    public Optional<Coupon> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Coupon> getAll() {
        List<Coupon> coupons = repository.findAll();
        return coupons;
    }

    @Override
    public String DeleteById(Long Id) {
        repository.deleteById(Id);
        return "Coupon Deleted";
    }

}

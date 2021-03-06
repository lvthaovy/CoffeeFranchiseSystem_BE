package com.enclave.backend.api;

import com.enclave.backend.dto.DiscountDTO;
import com.enclave.backend.entity.Discount;
import com.enclave.backend.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/discount")
public class DiscountAPI {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/")
    public Discount createDiscount(@RequestBody DiscountDTO dto) {
        return discountService.createDiscount(dto);
    }

    @PutMapping("/{code}")
    public Discount updateDiscount(@RequestBody Discount discount) {
        return discountService.updateDiscount(discount);
    }

    @GetMapping("/all")
    public List<Discount> getDiscounts() {
        return discountService.getDiscounts();
    }

    @GetMapping("/{code}")
    public Discount getDiscountByCode(@PathVariable("code") String code) {
        return discountService.getDiscountByCode(code);
    }

    @GetMapping("/{code}/validate")
    public Discount validateDiscount(@PathVariable("code") String code) {
        Date currentDate = new Date();
        return discountService.validateDiscount(code, currentDate);
    }
}

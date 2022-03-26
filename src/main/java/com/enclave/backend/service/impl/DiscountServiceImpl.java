package com.enclave.backend.service.impl;

import com.enclave.backend.converter.DiscountConverter;
import com.enclave.backend.dto.DiscountDTO;
import com.enclave.backend.entity.Discount;
import com.enclave.backend.repository.DiscountRepository;
import com.enclave.backend.service.DiscountService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private DiscountConverter discountConverter;

    @Override
    public Discount createDiscount(DiscountDTO discountDTO) {
        Discount discount = discountConverter.toEntity(discountDTO);

        String generatedString = RandomStringUtils.randomAlphabetic(6);
        discount.setCode(generatedString);

        return discountRepository.save(discount);
    }

    @Override
    public Discount updateDiscount(Discount discount) {
        Discount oldDiscount = discountRepository.findById(discount.getCode()).orElseThrow(() -> new IllegalArgumentException("Invalide discount code: " + discount.getCode()));
        oldDiscount.setStartedAt(discount.getStartedAt());
        oldDiscount.setEndedAt(discount.getEndedAt());
        oldDiscount.setTitle(discount.getTitle());
        oldDiscount.setPercent(discount.getPercent());
        return discountRepository.save(oldDiscount);
    }

    @Override
    public Discount validateDiscount(String code, Date currentDate) {

        Discount discount = getDiscountByCode(code);
        Date startedAt = discount.getStartedAt();
        Date endedAt = discount.getEndedAt();

        currentDate = new Date();

        if (startedAt.equals(currentDate) || endedAt.equals(currentDate)) {
            discount.setStatus("HAPPENING");
        }
        if (startedAt.before(currentDate) && endedAt.after(currentDate)) {
            discount.setStatus("HAPPENING");
        }
        if (startedAt.after(currentDate)) {
            discount.setStatus("UP COMING");
        }
        if (startedAt.before(currentDate)) {
            discount.setStatus("EXPIRED");
        }
        System.out.println(discount.getStatus());
        return discount;
    }

    @Override
    public Discount getDiscountByCode(String code) {
        return discountRepository.findById(code).orElseThrow(() -> new IllegalArgumentException("Invalid discount code: " + code));
    }

    @Override
    public List<Discount> getDiscounts() {
        return discountRepository.findAll();
    }
}

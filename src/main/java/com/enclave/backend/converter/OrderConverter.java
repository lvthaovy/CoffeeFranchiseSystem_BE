package com.enclave.backend.converter;

import com.enclave.backend.dto.OrderDTO;
import com.enclave.backend.entity.Order;
import com.enclave.backend.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderConverter {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Order toEntity(OrderDTO dto) {
        Order entity = new Order();
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setTotalPrice(dto.getTotalPrice());
//        entity.setDiscount(dto.getDiscount_code());
        entity.setCanceledBy(null);
        entity.setStatus(Order.Status.CREATED);
        return entity;
    }
}

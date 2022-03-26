package com.enclave.backend.converter;

import com.enclave.backend.dto.OrderDTO;
import com.enclave.backend.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public Order toEntity(OrderDTO dto) {
        Order entity = new Order();
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setCanceledBy(null);
        entity.setStatus("CREATED");
        return entity;
    }
}

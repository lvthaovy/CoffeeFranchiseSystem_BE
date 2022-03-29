package com.enclave.backend.converter;

import com.enclave.backend.dto.OrderDetailDTO;
import com.enclave.backend.entity.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter {
    public OrderDetail toEntity(OrderDetailDTO dto) {
        OrderDetail entity = new OrderDetail();
        entity.setQuantity(dto.getQuantity());
        return entity;
    }
}

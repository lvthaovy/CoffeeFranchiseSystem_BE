package com.enclave.backend.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private String orderId;
    private short productId;
    private short quantity;
    private double subtotal;
}

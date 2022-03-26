package com.enclave.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {
    //    private String id;
    private String discount_code;
    private double totalPrice;
    private Date createdAt;
    private short createdByEmpId;
    private short canceledByEmpId;
}

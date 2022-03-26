package com.enclave.backend.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private short id;
    private String name;
    private short categoryId;
    private double price;
    private String image;
//    private String status;
}

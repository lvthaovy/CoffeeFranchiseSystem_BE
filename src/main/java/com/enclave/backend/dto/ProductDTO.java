package com.enclave.backend.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private short id;
    private String name;
    private short categoryId;
    private float price;
    private String image;
}
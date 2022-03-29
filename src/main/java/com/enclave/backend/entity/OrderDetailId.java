package com.enclave.backend.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    private String orderId;
    private short productId;
}

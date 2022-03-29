package com.enclave.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne
    @MapsId("orderId")
    private Order order;

    @OneToOne
    @MapsId("productId")
    private Product product;

    @Column
    private short quantity;

    public double calculateSubtotal() {
        return getQuantity() * getProduct().getPrice();
    }
}

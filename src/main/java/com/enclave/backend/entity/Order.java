package com.enclave.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column
    private String id;

    @ManyToOne
    @JoinColumn(name = "discount_code")
    private Discount discount;

    @Column
    private double totalPrice;

    @Column
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "canceledBy")
    private Employee canceledBy;

    @Column
    private String status;
}

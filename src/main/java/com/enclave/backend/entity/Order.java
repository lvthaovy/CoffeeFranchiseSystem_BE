package com.enclave.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

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
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    public enum Status {
        CREATED, CANCELED
    }

}

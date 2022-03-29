package com.enclave.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

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
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    public enum Status{
        CREATED, CANCELED
    }
}

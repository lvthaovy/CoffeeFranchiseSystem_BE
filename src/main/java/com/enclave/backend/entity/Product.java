package com.enclave.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    @Column
    private String name;

    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private String image;

    @Column
    private double price;
    @OneToOne(mappedBy = "product")
    private OrderDetail orderDetail;

    public enum Status {
        AVAILABLE, UNAVAILABLE
    }
}

package com.enclave.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name = "discount")
public class Discount {

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @Column
    private String code;

    @Column
    private String title;

    @Column
    private double percent;

    @Column
    private Date startedAt;

    @Column
    private Date endedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "discount")
    private Set<Order> orders;

    public enum Status {
        UPCOMING, HAPPENING, EXPIRED
    }
}

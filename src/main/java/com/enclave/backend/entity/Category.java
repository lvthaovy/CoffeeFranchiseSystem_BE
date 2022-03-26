package com.enclave.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
}

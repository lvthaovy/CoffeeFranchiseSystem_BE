package com.enclave.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    @Column
    private String name;

    @Column
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private Set<Employee> employees = new HashSet<>();

    @Column
    private String status;
}

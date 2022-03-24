package com.enclave.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    @Column
    private String phone;

    @Column
    private String username;

    @ManyToOne
//    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
//    @JoinColumn(name = "role_id")
    private Role role;
}

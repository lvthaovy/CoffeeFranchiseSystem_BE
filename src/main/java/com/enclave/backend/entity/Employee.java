package com.enclave.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")
public class Employee extends AbstractUser {

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    @Column
    private String phone;

    @Column
    private String username;

    public enum Status {
        ACTIVE, INACTIVE
    }

    @ManyToOne
//    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
//    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "createdBy")
    private Set<Order> orderCreate;

    @JsonIgnore
    @OneToMany(mappedBy = "canceledBy")
    private Set<Order> orderCancel;
}

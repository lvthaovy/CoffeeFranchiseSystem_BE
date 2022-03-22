package com.enclave.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private  String address;

//    @OneToMany(mappedBy = "branch")
//    private List<Employee> employees = new ArrayList<>();
}

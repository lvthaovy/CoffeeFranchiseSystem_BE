package com.enclave.backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AbstractUser {

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String gender;

    @Column
    private String address;

    @Column
    private String avatar;

    @Column
    private Date birth;

}

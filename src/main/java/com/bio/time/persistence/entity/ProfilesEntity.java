package com.bio.time.persistence.entity;

import com.bio.time.consts.ERoleConsts;
import jakarta.persistence.*;


@Entity
@Table(name="profiles")

public class ProfilesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ERoleConsts code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ERoleConsts getCode() {
        return code;
    }

    public void setCode(ERoleConsts code) {
        this.code = code;
    }
}

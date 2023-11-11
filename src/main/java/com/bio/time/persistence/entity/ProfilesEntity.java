package com.bio.time.persistence.entity;

import com.bio.time.consts.ERoleConsts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="profiles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfilesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ERoleConsts code;
}

package com.bio.time.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_document_type")
    private Integer idDocumentType;
    private String nit;
    @Column(name = "name")
    private String name;
    private String lastname;
    private String email;
    private String cellphone;
    private String username;
    private String password;
    @Column(name = "id_profile")
    private Integer idProfile;
    @Column(name = "id_status")
    private Integer idStatus;
    @JsonIgnore
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    //@ManyToMany(fetch = FetchType.EAGER, targetEntity = ProfilesEntity.class, cascade = CascadeType.PERSIST)
    //@JoinTable(name = "profiles", joinColumns = @JoinColumn(name = "id_profile"), inverseJoinColumns = @JoinColumn(name = "id"))
    //private Set<ProfilesEntity> roles;

    @Column(name = "opt_recovery")
    private String optRecovery;
    @Column(name = "terms_conditions")
    private Integer termsConditions;
}



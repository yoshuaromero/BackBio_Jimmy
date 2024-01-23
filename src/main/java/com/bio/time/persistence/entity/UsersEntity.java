package com.bio.time.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="users")

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
    @Column(name = "optRecovery")
    private String optRecovery;
    @Column(name = "termsConditions")
    private Integer termsConditions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(Integer idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getOptRecovery() {
        return optRecovery;
    }

    public void setOptRecovery(String optRecovery) {
        this.optRecovery = optRecovery;
    }

    public Integer getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(Integer termsConditions) {
        this.termsConditions = termsConditions;
    }
}



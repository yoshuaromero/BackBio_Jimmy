package com.bio.time.domain.dto;


public class InsertUsersDto {
    private String name;
    private String nit;
    private String lastname;
    private String email;
    private String cellphone;
    private String password;
    private Integer visualDisability;
    private String username;
    private Integer idProfile;
    private Integer idPaymentMethod;
    private Integer termsConditions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVisualDisability() {
        return visualDisability;
    }

    public void setVisualDisability(Integer visualDisability) {
        this.visualDisability = visualDisability;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public Integer getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(Integer idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public Integer getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(Integer termsConditions) {
        this.termsConditions = termsConditions;
    }
}

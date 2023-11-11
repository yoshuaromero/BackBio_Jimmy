package com.bio.time.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class UsersDto {
    private Integer id;
    private Integer idDocumentType;
    private String nit;
    private String name;
    private String lastname;
    private String email;
    private String cellphone;
    private String username;
    private String password;
    private Integer idProfile;
    private Integer idStatus;
    @JsonIgnore
    private LocalDateTime createdDate;
    private String optRecovery;
    private Integer termsConditions;
}

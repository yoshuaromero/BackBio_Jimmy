package com.bio.time.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}

package com.bio.time.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponseDto extends AuthTokensDto {

        private String token;
        private Integer userId;
        private String username;
        private String email;
        private String cellphone;
        private String name;
        private String lastname;
        private Integer idProfile;
        private Integer visualDisability;
        private Integer idStatus;
        private Integer idPaymentMethod;

        public JwtResponseDto(String token, Integer userId, String username, String email, String cellphone, String name,
                              String lastname, Integer idProfile, Integer idStatus) {
                this.token = token;
                this.userId = userId;
                this.username = username;
                this.email = email;
                this.cellphone = cellphone;
                this.name = name;
                this.lastname = lastname;
                this.idProfile = idProfile;
                this.idStatus = idStatus;
        }
}
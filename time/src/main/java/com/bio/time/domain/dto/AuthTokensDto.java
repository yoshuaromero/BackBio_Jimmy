package com.bio.time.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthTokensDto {

    private String username;
    private String accessToken;
    //private String refreshToken;
}

package com.bio.time.domain.dto;

public class RecoveryPasswordDto {
    private String email;
    private String user;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

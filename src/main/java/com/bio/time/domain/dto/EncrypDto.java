package com.bio.time.domain.dto;



import java.time.LocalDateTime;

public class EncrypDto {
    private String opt;
    private LocalDateTime date;

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

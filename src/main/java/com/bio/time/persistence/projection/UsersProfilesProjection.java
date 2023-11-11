package com.bio.time.persistence.projection;

import com.bio.time.persistence.entity.UsersEntity;

import java.time.LocalDateTime;

public interface UsersProfilesProjection {
    Integer getIdUser();
    String getName();
    String getLastName();
    String getEmail();
    String getCellphone();
    String getUsername();
    String getPassword();
    Integer getVisualDisability();
    Integer getIdProfile();
    Integer getIdStatus();
    LocalDateTime getCreatedDate();
    Integer getIdPaymentMethod();
    String getDescription();
    String getCode();
}

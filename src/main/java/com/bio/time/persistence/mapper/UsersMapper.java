package com.bio.time.persistence.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.bio.time.domain.dto.UsersDto;
import com.bio.time.persistence.entity.UsersEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersEntity toUsersEntitya(UsersDto logsDto);
    //@InheritInverseConfiguration
    UsersDto toUsersDto(UsersEntity UsersEntity);

}

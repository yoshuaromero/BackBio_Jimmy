package com.bio.time.persistence.mapper;

import com.bio.time.domain.dto.ProfilesDto;
import com.bio.time.domain.dto.UsersDto;
import com.bio.time.persistence.entity.ProfilesEntity;
import com.bio.time.persistence.entity.UsersEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfilesMapper {
    ProfilesDto toProfilesDto(ProfilesEntity profilesEntity);

}

package com.bio.time.persistence.mapper.user;

import com.bio.time.domain.dto.user.MenuProfileStageDto;
import com.bio.time.persistence.projection.MenuProfileStageProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    List<MenuProfileStageDto> toMenuProfileStageDtoList(List<MenuProfileStageProjection> projection);

}

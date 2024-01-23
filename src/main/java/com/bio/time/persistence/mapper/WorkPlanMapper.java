package com.bio.time.persistence.mapper;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.persistence.entity.WorkPlanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkPlanMapper {
    WorkPlanEntity toWorkPlanEntity(CreateWorkPlanDto createWorkPlanDto);
    WorkPlanDto toWorkPlanDto(WorkPlanEntity workPlanEntity);

}

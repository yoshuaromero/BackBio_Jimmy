package com.bio.time.persistence.mapper;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.persistence.entity.WorkPlanEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkPlanMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    WorkPlanEntity toWorkPlanEntity(CreateWorkPlanDto createWorkPlanDto);
    WorkPlanEntity toWorkPlanDto(WorkPlanDto workPlanDto);
    WorkPlanDto toWorkPlanDto(WorkPlanEntity workPlanEntity);
    List<WorkPlanDto> toListAllPlanWork(Iterable<WorkPlanEntity> all);
}

package com.bio.time.persistence.mapper;

import com.bio.time.domain.dto.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.domain.dto.WorkPlanTaskDto;
import com.bio.time.persistence.entity.WorkPlanEntity;
import com.bio.time.persistence.entity.WorkPlanTaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkPlanTaskMapper {
    WorkPlanTaskEntity toWorkPlanTaskEntity(CreateWorkPlanTaskDto createWorkPlanTaskDto);
    WorkPlanTaskDto toWorkPlanTaskDto(WorkPlanTaskEntity workPlanTaskEntity);
    List<WorkPlanTaskDto> toListAllPlanWorkTask(Iterable<WorkPlanTaskEntity> all);


}

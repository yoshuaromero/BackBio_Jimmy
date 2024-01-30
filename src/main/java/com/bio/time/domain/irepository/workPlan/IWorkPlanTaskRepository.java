package com.bio.time.domain.irepository.workPlan;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.workPlan.WorkPlanTaskDto;

import java.util.List;
import java.util.Optional;

public interface IWorkPlanTaskRepository {
    WorkPlanTaskDto save(CreateWorkPlanTaskDto createWorkPlanTaskDto);
    List<WorkPlanTaskDto> listAll();
    Optional<WorkPlanTaskDto> findById(Integer groupId);

}

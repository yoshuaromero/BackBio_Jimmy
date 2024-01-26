package com.bio.time.domain.irepository;

import com.bio.time.domain.dto.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.WorkPlanTaskDto;

import java.util.List;

public interface IWorkPlanTaskRepository {
    WorkPlanTaskDto save(CreateWorkPlanTaskDto createWorkPlanTaskDto);
    List<WorkPlanTaskDto> listAll();
}

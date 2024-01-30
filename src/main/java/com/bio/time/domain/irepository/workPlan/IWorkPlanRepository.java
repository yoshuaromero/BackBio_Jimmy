package com.bio.time.domain.irepository.workPlan;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;

import java.util.List;

public interface IWorkPlanRepository {
    WorkPlanDto save(Integer userId, CreateWorkPlanDto createWorkPlanDto);

    WorkPlanDto update(Integer userId, WorkPlanDto workPlanDto);

    List<WorkPlanDto> listAll();

    boolean existWorkPlanById(Integer idWorkPlan);

}

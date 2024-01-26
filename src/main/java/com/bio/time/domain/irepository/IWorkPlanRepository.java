package com.bio.time.domain.irepository;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;

import java.util.List;

public interface IWorkPlanRepository {
    WorkPlanDto save(Integer userId, CreateWorkPlanDto createWorkPlanDto);

    WorkPlanDto update(Integer userId, WorkPlanDto workPlanDto);

    List<WorkPlanDto> listAll();

    boolean existWorkPlanById(Integer idWorkPlan);

}

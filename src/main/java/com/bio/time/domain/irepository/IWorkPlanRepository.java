package com.bio.time.domain.irepository;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;

public interface IWorkPlanRepository {
    WorkPlanDto save(Integer userId, CreateWorkPlanDto createWorkPlanDto);

}

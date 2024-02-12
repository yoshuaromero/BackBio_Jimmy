package com.bio.time.domain.irepository.workPlan;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.persistence.projection.WorkPlanProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWorkPlanRepository {
    WorkPlanDto save(Integer userId, CreateWorkPlanDto createWorkPlanDto);

    WorkPlanDto update(Integer userId, WorkPlanDto workPlanDto);

    List<WorkPlanProjection> listAll(int offset, int limit);

    boolean existWorkPlanById(Integer idWorkPlan);

    WorkPlanDto replyWorkPlan(Integer userId, Integer companyId, Integer workPlanId);
}

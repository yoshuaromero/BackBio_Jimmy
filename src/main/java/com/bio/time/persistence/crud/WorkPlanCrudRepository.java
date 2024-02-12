package com.bio.time.persistence.crud;

import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.persistence.entity.WorkPlanEntity;
import com.bio.time.persistence.projection.WorkPlanProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkPlanCrudRepository extends CrudRepository<WorkPlanEntity, Integer> {
    @Query(value = "CALL prc_reply_work_plan(:userId, :companyId, :workPlanId)", nativeQuery = true)
    WorkPlanDto replyWorkPlan(@Param("userId") Integer userId, @Param("companyId") Integer companyId, @Param("workPlanId") Integer workPlanId);

    @Query(value = "CALL prc_get_work_plan_and_companies(:offset, :limit) ", nativeQuery = true)
    //@Procedure(name = "prc_get_work_plan_and_companies")
    List<WorkPlanProjection> getAllProyection(@Param("offset") int offset,@Param("limit")  int limit);
}

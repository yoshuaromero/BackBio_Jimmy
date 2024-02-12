package com.bio.time.persistence.repository;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.irepository.workPlan.IWorkPlanRepository;
import com.bio.time.persistence.crud.WorkPlanCrudRepository;
import com.bio.time.persistence.entity.WorkPlanEntity;
import com.bio.time.persistence.mapper.WorkPlanMapper;
import com.bio.time.persistence.projection.WorkPlanProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class WorkPlanRepository implements IWorkPlanRepository {

    @Autowired WorkPlanMapper workPlanMapper;
    @Autowired WorkPlanCrudRepository workPlanCrudRepository;
    @Override
    public WorkPlanDto save(Integer userId,CreateWorkPlanDto createWorkPlanDto){
        WorkPlanEntity entity = workPlanMapper.toWorkPlanEntity(createWorkPlanDto);
        entity.setCreateBy(userId);
        WorkPlanEntity entityResult = workPlanCrudRepository.save(entity);
        return workPlanMapper.toWorkPlanDto(entityResult);
    }
    @Override
    public List<WorkPlanProjection> listAll(int offset, int limit){
        return workPlanCrudRepository.getAllProyection(offset, limit);
    }
    @Override
    public WorkPlanDto update(Integer userId, WorkPlanDto workPlanDto){
        WorkPlanEntity entity = workPlanMapper.toWorkPlanDto(workPlanDto);
        entity.setCreateBy(userId);
        WorkPlanEntity entityResult = workPlanCrudRepository.save(entity);
        return workPlanMapper.toWorkPlanDto(entityResult);
    }

    @Override
    public boolean  existWorkPlanById(Integer idWorkPlan) {
        return workPlanCrudRepository.existsById(idWorkPlan);
    }
    @Override
    public WorkPlanDto replyWorkPlan(Integer userId, Integer companyId, Integer workPlanId){
        return workPlanCrudRepository.replyWorkPlan(userId, companyId, workPlanId);
    }

}

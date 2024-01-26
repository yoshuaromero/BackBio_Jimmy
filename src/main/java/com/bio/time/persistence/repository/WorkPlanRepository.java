package com.bio.time.persistence.repository;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.domain.irepository.IWorkPlanRepository;
import com.bio.time.persistence.crud.WorkPlanCrudRepository;
import com.bio.time.persistence.entity.WorkPlanEntity;
import com.bio.time.persistence.mapper.WorkPlanMapper;
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
    public List<WorkPlanDto> listAll(){
        return workPlanMapper.toListAllPlanWork(workPlanCrudRepository.findAll());
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
}

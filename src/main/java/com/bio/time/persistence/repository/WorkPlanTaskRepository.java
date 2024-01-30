package com.bio.time.persistence.repository;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.workPlan.WorkPlanTaskDto;
import com.bio.time.domain.irepository.workPlan.IWorkPlanTaskRepository;
import com.bio.time.persistence.crud.WorkPlanTaskCrudRepository;
import com.bio.time.persistence.entity.WorkPlanTaskEntity;
import com.bio.time.persistence.mapper.WorkPlanTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkPlanTaskRepository implements IWorkPlanTaskRepository {
    @Autowired
    public WorkPlanTaskMapper workPlanTaskMapper;

    @Autowired
    public WorkPlanTaskCrudRepository workPlanTaskCrudRepository;

    @Override
    public WorkPlanTaskDto save(CreateWorkPlanTaskDto createWorkPlanTaskDto) {

        WorkPlanTaskEntity entity = workPlanTaskMapper.toWorkPlanTaskEntity(createWorkPlanTaskDto);
        WorkPlanTaskEntity entityResult = workPlanTaskCrudRepository.save(entity);
        return workPlanTaskMapper.toWorkPlanTaskDto(entityResult);
    }

    @Override
    public List<WorkPlanTaskDto> listAll() {
        return workPlanTaskMapper.toListAllPlanWorkTask(workPlanTaskCrudRepository.findAll());
    }

    @Override
    public Optional<WorkPlanTaskDto> findById(Integer itemId) {
        Optional<WorkPlanTaskEntity> entity = workPlanTaskCrudRepository.findById(itemId);
        return entity.map(a -> workPlanTaskMapper.toWorkPlanTaskDto(a));
    }
}

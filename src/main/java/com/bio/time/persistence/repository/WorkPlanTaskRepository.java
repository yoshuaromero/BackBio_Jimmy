package com.bio.time.persistence.repository;

import com.bio.time.domain.dto.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.WorkPlanTaskDto;
import com.bio.time.domain.irepository.IWorkPlanTaskRepository;
import com.bio.time.persistence.crud.WorkPlanTaskCrudRepository;
import com.bio.time.persistence.entity.WorkPlanTaskEntity;
import com.bio.time.persistence.mapper.WorkPlanTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<WorkPlanTaskDto> listAll() {
        return workPlanTaskMapper.toListAllPlanWorkTask(workPlanTaskCrudRepository.findAll());
    }
}

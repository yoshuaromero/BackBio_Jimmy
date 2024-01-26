package com.bio.time.persistence.crud;

import com.bio.time.persistence.entity.WorkPlanEntity;
import com.bio.time.persistence.entity.WorkPlanTaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkPlanTaskCrudRepository extends CrudRepository<WorkPlanTaskEntity, Integer> {
}

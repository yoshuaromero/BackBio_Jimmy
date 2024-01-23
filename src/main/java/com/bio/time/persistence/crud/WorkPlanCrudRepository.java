package com.bio.time.persistence.crud;

import com.bio.time.persistence.entity.WorkPlanEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkPlanCrudRepository extends CrudRepository<WorkPlanEntity, Integer> {
}

package com.bio.time.domain.service;

import com.bio.time.domain.dto.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.domain.dto.WorkPlanTaskDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.persistence.repository.WorkPlanRepository;
import com.bio.time.persistence.repository.WorkPlanTaskRepository;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkPlanTaskService {
    @Autowired
    WorkPlanTaskRepository workPlanTaskRepository;
    @Autowired
    WorkPlanRepository workPlanRepository;
    public WorkPlanTaskDto postCreate( Integer userId, CreateWorkPlanTaskDto data) throws HttpGenericException {

        if (userId==null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");

        if (data.getActivityName().isEmpty() || data.getActivityName().trim().equals(""))
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Nombre de plan no válido");

        boolean  validExist = workPlanRepository.existWorkPlanById(data.getIdWorkPlan());
        if (!validExist)
            throw new HttpGenericException(HttpStatus.NOT_FOUND,"Debe crear primero el plan de trabajo");

        return workPlanTaskRepository.save(data);
    }
    @Transactional(readOnly = true)
    public List<WorkPlanTaskDto> getList(Integer userId,Integer itemId) {

        return workPlanTaskRepository.listAll();
    }
}

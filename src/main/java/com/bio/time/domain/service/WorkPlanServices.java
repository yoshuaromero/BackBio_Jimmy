package com.bio.time.domain.service;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.IWorkPlanRepository;
import com.bio.time.persistence.repository.WorkPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkPlanServices {

    @Autowired private IWorkPlanRepository workPlanRepository;
    @Transactional
    public WorkPlanDto postCreate(Integer userId, CreateWorkPlanDto data) throws HttpGenericException {

        if (userId==null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");

        if (data.getWorkPlanName().isEmpty() || data.getWorkPlanName().trim().equals(""))
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Nombre de plan no válido");

        return workPlanRepository.save(userId, data);
    }
}

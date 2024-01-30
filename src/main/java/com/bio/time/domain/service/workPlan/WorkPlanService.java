package com.bio.time.domain.service.workPlan;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.workPlan.IWorkPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkPlanService {

    @Autowired private IWorkPlanRepository workPlanRepository;
    @Transactional
    public WorkPlanDto postCreate(Integer userId, CreateWorkPlanDto data) throws HttpGenericException {

        if (userId==null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");

        if (data.getCompanyId() == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Debe seleccionar una compañia válida");

        if (data.getWorkPlanName().isEmpty() || data.getWorkPlanName().trim().equals(""))
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Nombre de plan no válido");

        return workPlanRepository.save(userId, data);
    }

    @Transactional(readOnly = true)
    public List<WorkPlanDto> getlist(Integer userId) throws  HttpGenericException {
        if (userId==null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        return workPlanRepository.listAll();
    }

    @Transactional
    public WorkPlanDto putUpdate(Integer userId, WorkPlanDto workPlanDto) throws  HttpGenericException {
        if (userId==null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        return workPlanRepository.update(userId, workPlanDto);
    }
}

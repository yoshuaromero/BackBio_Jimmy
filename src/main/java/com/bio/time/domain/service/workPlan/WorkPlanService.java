package com.bio.time.domain.service.workPlan;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.workPlan.IWorkPlanRepository;
import com.bio.time.persistence.crud.WorkPlanCrudRepository;
import com.bio.time.persistence.projection.WorkPlanProjection;
import com.bio.time.persistence.repository.WorkPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkPlanService {

    @Autowired
    private IWorkPlanRepository workPlanRepository;

    @Transactional
    public WorkPlanDto postCreate(Integer userId, CreateWorkPlanDto data) throws HttpGenericException {

        if (userId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");

        if (data.getCompanyId() == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Debe seleccionar una compañia válida");

        if (data.getWorkPlanName().isEmpty() || data.getWorkPlanName().trim().equals(""))
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Nombre de plan no válido");

        return workPlanRepository.save(userId, data);
    }

    @Transactional //(readOnly = true)
    //public List<WorkPlanProjection> getlist(Integer userId) throws HttpGenericException {
    public Page<WorkPlanProjection> getlist(Integer userId, int page, int size) throws HttpGenericException {
        Pageable pageable = PageRequest.of(page-1, size);
        if (userId == null) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        }
        //int offset = page * size;
        List<WorkPlanProjection> resultList = workPlanRepository.listAll(page, size);

        return new PageImpl<>(resultList, pageable, resultList.size());
    }

    @Transactional
    public WorkPlanDto putUpdate(Integer userId, WorkPlanDto workPlanDto) throws HttpGenericException {
        if (userId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        return workPlanRepository.update(userId, workPlanDto);
    }

    @Transactional
    public WorkPlanDto getReplyWorkTask(Integer userId, Integer companyId, Integer workPlanId) throws HttpGenericException {
        if (userId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        if (companyId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Debe seleccionar una empresa para replicar el plan de trabajo");
        if (workPlanId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "debe seleccionar un plan de trabajo para replicarlo");

        return workPlanRepository.replyWorkPlan(userId, companyId, workPlanId);

    }
}

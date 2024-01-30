package com.bio.time.domain.service.company;

import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.dto.company.CompanyDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.company.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    @Transactional
    public CompanyDto postCreate(Integer userId, CompanyDto data) throws HttpGenericException {

        if (userId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");

        return companyRepository.save(userId, data);
    }

    @Transactional(readOnly = true)
    public List<CompanyDto> getlist(Integer userId) throws HttpGenericException {
        if (userId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        return companyRepository.listAll();
    }

    public CompanyDto putUpdate(Integer userId, CompanyDto companyDto) throws  HttpGenericException {
        if (userId == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Este usuario no se encuentra registrado");
        return companyRepository.update(userId, companyDto);
    }
}

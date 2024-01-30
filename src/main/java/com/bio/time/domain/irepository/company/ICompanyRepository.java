package com.bio.time.domain.irepository.company;

import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.dto.company.CompanyDto;

import java.util.List;

public interface ICompanyRepository {
    CompanyDto save(Integer userId, CompanyDto companyDto);
    List<CompanyDto> listAll();
    CompanyDto update(Integer userId, CompanyDto companyDto);
}

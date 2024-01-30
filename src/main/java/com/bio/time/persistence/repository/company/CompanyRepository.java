package com.bio.time.persistence.repository.company;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.company.CompanyDto;
import com.bio.time.domain.irepository.company.ICompanyRepository;
import com.bio.time.persistence.crud.CompanyCrudRespository;
import com.bio.time.persistence.crud.LogsCrudRepository;
import com.bio.time.persistence.entity.CompanyEntity;
import com.bio.time.persistence.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository  implements ICompanyRepository {

    @Autowired
    private LogsCrudRepository logsCrudRepository;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyCrudRespository companyCrudRespository;
    @Override
    public CompanyDto save(Integer userId, CompanyDto companyDto){
        CompanyEntity entity = companyMapper.toCompanyEntity(companyDto);
        entity.setCreateBy(userId);
        CompanyEntity entityResult = companyCrudRespository.save(entity);
        return companyMapper.toCompanyDto(entityResult);
    }
    @Override
    public List<CompanyDto> listAll(){
        return companyMapper.toListAllCompany(companyCrudRespository.findAll());
    }

    @Override
    public CompanyDto update(Integer userId, CompanyDto companyDto){
        CompanyEntity entity = companyMapper.toCompanyEntity(companyDto);
        entity.setCreateBy(userId);
        CompanyEntity entityResult = companyCrudRespository.save(entity);
        return companyMapper.toCompanyDto(entityResult);
    }
}

package com.bio.time.persistence.mapper;

import com.bio.time.domain.dto.company.CompanyDto;
import com.bio.time.persistence.entity.CompanyEntity;
import com.bio.time.persistence.entity.WorkPlanEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyEntity toCompanyEntity(CompanyDto companyDto);

    CompanyDto toCompanyDto(CompanyEntity entityResult);

    List<CompanyDto> toListAllCompany(Iterable<CompanyEntity> all);
}

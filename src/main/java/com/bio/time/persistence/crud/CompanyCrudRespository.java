package com.bio.time.persistence.crud;

import com.bio.time.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyCrudRespository  extends CrudRepository<CompanyEntity, Integer> {

}

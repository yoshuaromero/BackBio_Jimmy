package com.bio.time.persistence.crud;

import com.bio.time.persistence.entity.LogsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LogsCrudRepository extends CrudRepository<LogsEntity, Integer>{
        @Query(value = "call prc_log_user_login(:P_NUMBER_ID)", nativeQuery = true)
        Optional<Integer> getId(@Param("P_NUMBER_ID") String user);

}

package com.bio.time.persistence.repository;

import com.bio.time.domain.irepository.ILogsRepository;
import com.bio.time.persistence.crud.LogsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LogsRepository implements ILogsRepository {

    @Autowired
    private LogsCrudRepository logsCrudRepository;
    @Override
    public Optional<Integer> getId(String user) {
        return logsCrudRepository.getId(user);
    }
}

package com.bio.time.domain.service;

import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.ILogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LogsService{
    @Autowired
    private ILogsRepository logsRepository;
    @Transactional(readOnly = true)
    public Integer getId(String user) throws HttpGenericException {
        Optional<Integer> name = logsRepository.getId(user);
        if (name.isEmpty())
            throw new HttpGenericException(HttpStatus.CONTINUE, "No existe información sobre el usuario");
        return name.get();
    }
}

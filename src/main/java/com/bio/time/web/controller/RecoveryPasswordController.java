package com.bio.time.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.bio.time.domain.dto.OptDto;
import com.bio.time.domain.dto.RecoveryPasswordDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.RecoveryPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/recovery")
public class RecoveryPasswordController {

    @Autowired RecoveryPasswordService recoveryPasswordService;
    @PostMapping("/password")
    public ResponseEntity<?> recoveryPassword(@RequestBody RecoveryPasswordDto recoveryPasswordDto) throws HttpGenericException, JsonProcessingException {
        recoveryPasswordService.findEmailForRecovery(recoveryPasswordDto);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @PostMapping("/validate")
    public Map<String, String> validateOpt(@RequestBody OptDto optDto) throws HttpGenericException, JsonProcessingException {
        return recoveryPasswordService.findValidateOpt(optDto);
    }

}

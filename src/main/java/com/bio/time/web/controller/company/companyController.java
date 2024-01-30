package com.bio.time.web.controller.company;

import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.dto.company.CompanyDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.LogsService;
import com.bio.time.domain.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class companyController {

    @Autowired
    private LogsService logsService;

    @Autowired
    private CompanyService companyService;
    @PostMapping("/create")
    public ResponseEntity<CompanyDto> postCreate(@RequestBody CompanyDto companyDto, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(companyService.postCreate(userId, companyDto));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CompanyDto>> getCreate(Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(companyService.getlist(userId));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<CompanyDto> putUpdate(@RequestBody CompanyDto companyDto, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(companyService.putUpdate(userId, companyDto));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

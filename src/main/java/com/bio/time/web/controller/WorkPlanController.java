package com.bio.time.web.controller;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.LogsService;
import com.bio.time.domain.service.workPlan.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/workPlan")
public class WorkPlanController {

    @Autowired
    private LogsService logsService;
    @Autowired
    private WorkPlanService workPlanService;

    @GetMapping("/list")
    public ResponseEntity<List<WorkPlanDto>> getCreate(Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanService.getlist(userId));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<WorkPlanDto> postCreate(@RequestBody CreateWorkPlanDto createWorkPlanDto, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanService.postCreate(userId, createWorkPlanDto));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<WorkPlanDto> putUpdate(@RequestBody WorkPlanDto workPlanDto, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanService.putUpdate(userId, workPlanDto));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}

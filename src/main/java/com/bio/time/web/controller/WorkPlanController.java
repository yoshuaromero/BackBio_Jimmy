package com.bio.time.web.controller;

import com.bio.time.domain.dto.CreateWorkPlanDto;
import com.bio.time.domain.dto.WorkPlanDto;
import com.bio.time.domain.service.LogsService;
import com.bio.time.domain.service.WorkPlanServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    private WorkPlanServices workPlanServices;

    @GetMapping("/list")
    public ResponseEntity<List<WorkPlanDto>> getCreate(Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanServices.getlist(userId));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<WorkPlanDto> postCreate(@RequestBody CreateWorkPlanDto createWorkPlanDto, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanServices.postCreate(userId, createWorkPlanDto));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<WorkPlanDto> putUpdate(@RequestBody WorkPlanDto workPlanDto, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanServices.putUpdate(userId, workPlanDto));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}

package com.bio.time.web.controller;

import com.bio.time.domain.dto.CreateWorkPlanTaskDto;
import com.bio.time.domain.dto.WorkPlanTaskDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.LogsService;
import com.bio.time.domain.service.WorkPlanTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/workPlanTask")
public class WorkPlanTasksController {
    @Autowired private LogsService logsService;
    @Autowired private WorkPlanTaskService workPlanTaskService;
    @PostMapping("/create")
    public ResponseEntity<WorkPlanTaskDto> postCreate(@RequestBody CreateWorkPlanTaskDto createWorkPlanTaskDto, Authentication auth) throws HttpGenericException {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanTaskService.postCreate(userId, createWorkPlanTaskDto));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<WorkPlanTaskDto>> getCreate(@RequestParam Integer itemId, Authentication auth) throws HttpGenericException {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanTaskService.getList( userId, itemId));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

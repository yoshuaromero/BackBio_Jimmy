package com.bio.time.web.controller.workPlan;

import com.bio.time.domain.dto.workPlan.CreateWorkPlanDto;
import com.bio.time.domain.dto.workPlan.WorkPlanDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.LogsService;
import com.bio.time.domain.service.workPlan.WorkPlanService;
import com.bio.time.persistence.projection.WorkPlanProjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/workPlan")
public class WorkPlanController {

    @Autowired
    private LogsService logsService;
    @Autowired
    private WorkPlanService workPlanService;

    @GetMapping("/list")
    public ResponseEntity<Page<WorkPlanProjection>> getCreate(Authentication auth, @RequestParam(defaultValue = "1") int page,
                                                              @RequestParam(defaultValue = "10") int size) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            Page<WorkPlanProjection> resultPage = workPlanService.getlist(userId, page, size);

            return ResponseEntity.ok(resultPage);
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

    @GetMapping("/reply")
    public ResponseEntity<WorkPlanDto> getReplyworktask(@RequestParam Integer companyId,@RequestParam Integer workPlanId, Authentication auth) throws Exception {
        try {
            Integer userId = logsService.getId(auth.getName());
            return ResponseEntity.ok(workPlanService.getReplyWorkTask(userId, companyId, workPlanId));
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}

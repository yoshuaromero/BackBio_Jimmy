package com.bio.time.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class WorkPlanTaskDto {
    private Integer id;
    private Integer idWorkPlan;
    @JsonProperty
    @Max(value = 999, message = "El tamaño máximo es de 3 caracteres")
    private Integer order;
    @Size(max = 200, message = "El tamaño máximo para la actividad es de 100 caracteres")
    private String activityName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdWorkPlan() {
        return idWorkPlan;
    }

    public void setIdWorkPlan(Integer idWorkPlan) {
        this.idWorkPlan = idWorkPlan;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}

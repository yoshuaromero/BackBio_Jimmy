package com.bio.time.domain.dto;

public class CreateWorkPlanTaskDto {

    private Integer id;
    private Integer idWorkPlan;
    private Integer order;
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

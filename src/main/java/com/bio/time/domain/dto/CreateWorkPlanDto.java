package com.bio.time.domain.dto;

public class CreateWorkPlanDto {
    private String item;
    private String workPlanName;
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

}

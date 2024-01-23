package com.bio.time.domain.dto;

import java.time.LocalDateTime;

public class WorkPlanDto {
    private Integer id;
    private String item;
    private String workPlanName;
    private Integer createBy;
    private LocalDateTime created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreated() {
        return created;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}

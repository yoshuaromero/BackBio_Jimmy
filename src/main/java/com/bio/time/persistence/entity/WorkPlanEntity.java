package com.bio.time.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name="work_plan")

public class WorkPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String item;
    @Column(name = "work_plan_name")
    private String workPlanName;
    @Column(name = "created", insertable = false, updatable = false)
    private LocalDateTime created;
    @Column(name = "create_by")
    private Integer createBy;

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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

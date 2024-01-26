package com.bio.time.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="work_plan_task")
public class WorkPlanTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_work_plan")
    private Integer idWorkPlan;
    @Column(name = "orden")

    private Integer order;
    @Size(max = 200, message = "El tamaño máximo para la actividad es de 100 caracteres")
    @Column(name = "activity_name")
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

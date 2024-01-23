package com.bio.time.persistence.entity;


import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name="logs")

public class LogsEntity {
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;
    private String user;
    @Column(name = "user_description")
    private String userDescription;
    private String action;
    @Column(name = "action_description")
    private String actionDescription;
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

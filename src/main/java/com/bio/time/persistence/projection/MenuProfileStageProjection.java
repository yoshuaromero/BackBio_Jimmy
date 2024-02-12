package com.bio.time.persistence.projection;

public interface MenuProfileStageProjection {
    Integer getMenuId();
    Integer getParentId();
    Integer getOrder();
    String getNameRoute();
    String getTitle();
    String getIcon();
    String getPathRoute();
    Integer getStageId();
}
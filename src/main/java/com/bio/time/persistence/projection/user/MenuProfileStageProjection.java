package com.bio.time.persistence.projection.user;

public interface MenuProfileStageProjection {
    Integer getMenuId();
    Integer getParentId();
    Integer getOrder();
    String getNameRoute();
    String getTitle();
    String getIcon();
    String getPathRoute();
}

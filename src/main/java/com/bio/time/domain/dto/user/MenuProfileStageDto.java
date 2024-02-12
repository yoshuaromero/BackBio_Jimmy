package com.bio.time.domain.dto.user;

import com.bio.time.persistence.projection.MenuProfileStageProjection;

public class MenuProfileStageDto implements MenuProfileStageProjection {
    private Integer menuId;
    private Integer parentId;
    private Integer order;
    private String nameRoute;
    private String title;
    private String icon;
    private String pathRoute;
    private Integer stageId;

        public Integer getMenuId() {
                return menuId;
        }

        public void setMenuId(Integer menuId) {
                this.menuId = menuId;
        }

        public Integer getParentId() {
                return parentId;
        }

        public void setParentId(Integer parentId) {
                this.parentId = parentId;
        }

        public Integer getOrder() {
                return order;
        }

        public void setOrder(Integer order) {
                this.order = order;
        }

        public String getNameRoute() {
                return nameRoute;
        }

        public void setNameRoute(String nameRoute) {
                this.nameRoute = nameRoute;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getIcon() {
                return icon;
        }

        public void setIcon(String icon) {
                this.icon = icon;
        }

        public String getPathRoute() {
                return pathRoute;
        }

        public void setPathRoute(String pathRoute) {
                this.pathRoute = pathRoute;
        }

        public Integer getStageId() {
                return stageId;
        }

        public void setStageId(Integer stageId) {
                this.stageId = stageId;
        }
}

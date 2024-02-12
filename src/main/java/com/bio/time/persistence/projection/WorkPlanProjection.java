package com.bio.time.persistence.projection;

import java.time.LocalDateTime;

public interface WorkPlanProjection {

   Integer getId();
   String getItem();
   String getWorkPlanName();
   Integer getCreateBy();
   Integer getStatus();
   Integer getCompanyId();
   LocalDateTime getCreated();
   String getCompanyName();
}

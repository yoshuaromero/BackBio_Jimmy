package com.bio.time.persistence.crud.user;

import com.bio.time.persistence.entity.MenuEntity;
import com.bio.time.persistence.projection.MenuProfileStageProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuCrudRepository extends CrudRepository<MenuEntity, Integer> {
    @Query(value = "CALL PRC_LIST_MENUS_BY_PROFILE(:P_USER_ID)", nativeQuery = true)
    List<MenuProfileStageProjection> listMenusByProfile(@Param("P_USER_ID") Integer userId);
}

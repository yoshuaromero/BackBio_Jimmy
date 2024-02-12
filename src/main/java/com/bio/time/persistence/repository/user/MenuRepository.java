package com.bio.time.persistence.repository.user;

import com.bio.time.domain.dto.user.MenuProfileStageDto;
import com.bio.time.domain.irepository.user.IMenuRepository;
import com.bio.time.persistence.crud.user.MenuCrudRepository;
import com.bio.time.persistence.mapper.user.MenuMapper;
import com.bio.time.persistence.projection.MenuProfileStageProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepository implements IMenuRepository {

    @Autowired
    private MenuCrudRepository menuCrudRepository;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<MenuProfileStageDto> listMenusByProfile(int userId) {
        List<MenuProfileStageProjection> projection = menuCrudRepository.listMenusByProfile(userId);
        return menuMapper.toMenuProfileStageDtoList(projection);
    }
}

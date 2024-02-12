package com.bio.time.domain.irepository.user;

import com.bio.time.domain.dto.user.MenuProfileStageDto;

import java.util.List;

public interface IMenuRepository {
    List<MenuProfileStageDto> listMenusByProfile(int userId);

}

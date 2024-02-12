package com.bio.time.domain.service.user;

import com.bio.time.domain.dto.user.MenuProfileStageDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.user.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private IMenuRepository iMenuRepository;
    @Transactional(readOnly = true)
    public List<MenuProfileStageDto> listMenusByProfile(int userId) throws HttpGenericException {
        try {
            List<MenuProfileStageDto> listMenus = iMenuRepository.listMenusByProfile(userId);
            if (listMenus.isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "No existen menús para este perfil");
            return listMenus;
        } catch (Exception err) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, err.getMessage());
        }
    }
}

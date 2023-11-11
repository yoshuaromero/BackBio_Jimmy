package com.bio.time.domain.irepository;

import com.bio.time.domain.dto.UsersDto;
import com.bio.time.persistence.projection.UsersProfilesProjection;
import com.bio.time.persistence.projection.UsersProfilesProjection;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface IUsersRepository {
    void save(UsersDto data);

    boolean existCellphone(String cellphone);

    boolean existEmail(String email);

    boolean existUsername(String username);

    Optional<UsersDto> findByUsername(String data);
    Optional<UsersDto> findByEmail(String data);
    Optional<UsersProfilesProjection> findByUsernameAuth(String data);

    Optional<UsersDto> findById(Integer Id);
    Optional<User> findOneByUsername(String username);


}

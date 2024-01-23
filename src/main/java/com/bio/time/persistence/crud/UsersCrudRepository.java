package com.bio.time.persistence.crud;

import com.bio.time.persistence.entity.UsersEntity;
import com.bio.time.persistence.projection.UsersProfilesProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersCrudRepository extends CrudRepository<UsersEntity, Integer> {

    boolean existsByCellphone(String cellphone);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
    Optional<UsersEntity> findByUsername(String data);
    Optional<UsersEntity> findByEmail(String data);

    @Query(value = "select u.id as id_user, u.name, u.lastName, u.email, u.cellphone, u.username, u.password, " +
            "u.visual_disability as visualDisability, u.idProfile, u.idStatus, " +
            "u.created_date as u.createdDate, u.id_payment_method as idPaymentMethod, p.description " +
            "from users u" +
            "inner join profiles p on p.id = u.idProfile " +
            "where username = :data", nativeQuery = true)
    Optional<UsersProfilesProjection> findByUsernameAuth(@Param("data") String data);

    Optional<UsersEntity> findTopByUsername(String username);
}

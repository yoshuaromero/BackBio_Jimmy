package com.bio.time.persistence.crud;

import com.bio.time.persistence.entity.ProfilesEntity;
import com.bio.time.persistence.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfilesCrudRepository extends CrudRepository<ProfilesEntity, Integer> {
    Optional<ProfilesEntity> findById(Integer data);
}

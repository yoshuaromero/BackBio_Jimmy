package com.bio.time.persistence.repository;

import com.bio.time.persistence.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Integer> {
    Optional<UsersEntity> findById(Integer Id);

    Optional<UsersEntity> findByUsername(String username);
}

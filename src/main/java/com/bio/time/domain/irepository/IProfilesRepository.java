package com.bio.time.domain.irepository;

import com.bio.time.persistence.entity.ProfilesEntity;

import java.util.Optional;

public interface IProfilesRepository {
    Optional<ProfilesEntity> findById(Integer idProfile);
}

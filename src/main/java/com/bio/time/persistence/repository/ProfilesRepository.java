package com.bio.time.persistence.repository;

import com.bio.time.domain.irepository.IProfilesRepository;
import com.bio.time.persistence.crud.ProfilesCrudRepository;
import com.bio.time.persistence.entity.ProfilesEntity;
import com.bio.time.persistence.mapper.ProfilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProfilesRepository implements IProfilesRepository {

    @Autowired
    private ProfilesMapper profilesMapper;
    @Autowired private ProfilesCrudRepository profilesCrudRepository;
    @Override
    public Optional<ProfilesEntity> findById(Integer idProfile){
        return profilesCrudRepository.findById(idProfile);
    }

}

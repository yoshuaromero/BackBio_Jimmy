package com.bio.time.persistence.repository;

import com.bio.time.domain.dto.UsersDto;
import com.bio.time.domain.irepository.IUsersRepository;
import com.bio.time.persistence.crud.UsersCrudRepository;
import com.bio.time.persistence.entity.UsersEntity;
import com.bio.time.persistence.mapper.UsersMapper;
import com.bio.time.persistence.projection.UsersProfilesProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository implements IUsersRepository {

    @Autowired private UsersMapper usersMapper;
    @Autowired private UsersCrudRepository usersCrudRepository;
    @Override
    public void save(UsersDto data){
        UsersEntity entity = usersMapper.toUsersEntitya(data);
        usersCrudRepository.save(entity);
    }

    @Override
    public boolean existCellphone(String cellphone){
        return usersCrudRepository.existsByCellphone(cellphone);
    }

    @Override
    public boolean existEmail(String email){
        return usersCrudRepository.existsByEmail(email);
    }

    @Override
    public boolean existUsername(String username){
        return usersCrudRepository.existsByUsername(username);
    }
    @Override
    public Optional<UsersDto> findByUsername(String data){
        Optional<UsersEntity> entity = usersCrudRepository.findByUsername(data);
        return entity.map(e ->usersMapper.toUsersDto(e));
    }
    @Override
    public Optional<UsersDto> findByEmail(String data){
        Optional<UsersEntity> entity = usersCrudRepository.findByEmail(data);
        return entity.map(e ->usersMapper.toUsersDto(e));
    }
    @Override
    public Optional<UsersProfilesProjection> findByUsernameAuth(String data){
        return usersCrudRepository.findByUsernameAuth(data);

    }
    @Override
    public Optional<UsersDto> findById(Integer Id){
        Optional<UsersEntity> entity = usersCrudRepository.findById(Id);
        return entity.map(e ->usersMapper.toUsersDto(e));
        //return usersCrudRepository.findById(Id);
    }

    public Optional<User> findOneByUsername(String username) {
        Optional<UsersEntity> userEntity = usersCrudRepository.findTopByUsername(username);
        return userEntity.map(u -> new User(u.getUsername(), u.getPassword(), List.of()));
    }
}

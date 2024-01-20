package com.bio.time.web.controller;

import com.bio.time.domain.dto.InsertUsersDto;
import com.bio.time.domain.dto.UsersDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody InsertUsersDto data) throws HttpGenericException {
        try {
            return ResponseEntity.ok(usersService.create(data));
        } catch (HttpGenericException error) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Optional<UsersDto>> getUser(@Param("username") String username) throws HttpGenericException {
        try {
            return ResponseEntity.ok(usersService.getUser(username));
        } catch (HttpGenericException error) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, error.getMessage());
        }
    }
}

package com.bio.time.web.controller;

import com.bio.time.domain.dto.JwtResponseDto;
import com.bio.time.domain.dto.LoginRequestDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.service.AuthServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired public AuthServices authServices;
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) throws HttpGenericException, Exception {

        try {
            authServices.validationStatus(loginRequestDto, request, response);
            return ResponseEntity.ok(authServices.getDataStart(loginRequestDto, request, response));
        } catch (Exception error) {
            throw error;
        }
    }
}

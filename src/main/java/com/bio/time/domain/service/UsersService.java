package com.bio.time.domain.service;

import com.bio.time.domain.dto.InsertUsersDto;
import com.bio.time.domain.dto.UsersDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.irepository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired private IUsersRepository usersRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    //@Transactional
    public UsersDto create(InsertUsersDto data) throws HttpGenericException {
        try {
            // Validaciones de campos vacios
            if (data.getCellphone().isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo número telefónico es es requerido");
            if (data.getEmail().isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo correo electrónico es es requerido");
            if (data.getPassword().isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo contraseña es requerida");
            if (data.getName().isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo nombre es requrido");
            if (data.getLastname().isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo apellido es requrido");
            if (data.getUsername().isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo usuarios es requerido");
            if (data.getIdProfile() == null)
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo perfil es requerido");
            if (data.getIdPaymentMethod() == null)
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo método de pago es obligatorio");
            if (data.getTermsConditions() == null || data.getTermsConditions() == 0)
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Los terminos y condiciones deben ser aceptados");

            // Validaciones de duplicados
            if (usersRepository.existCellphone(data.getCellphone()))
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El celular ya esta registrado en el sistemas, lo invitamos a recuperar la contraseña");
            if (usersRepository.existEmail(data.getEmail()))
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El correo electrónico ya esta registrado en el sistemas, lo invitamos a recuperar la contraseña");
            if (usersRepository.existUsername(data.getUsername()))
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El usuario ya esta registrado en el sistemas, lo invitamos a recuperar la contraseña");

            // Insertar datos del usuario
            UsersDto dataUsers = new UsersDto();
            dataUsers.setCellphone(data.getCellphone());
            dataUsers.setEmail(data.getEmail().toUpperCase());
            dataUsers.setName(data.getName().toUpperCase());
            dataUsers.setLastname(data.getLastname().toUpperCase());
            dataUsers.setUsername(data.getUsername().toUpperCase());
            dataUsers.setPassword(passwordEncoder.encode(data.getPassword()));
            dataUsers.setIdProfile(data.getIdProfile());
            dataUsers.setCellphone(data.getCellphone());
            dataUsers.setIdStatus(1);
            dataUsers.setTermsConditions(data.getTermsConditions());
            usersRepository.save(dataUsers);
            return dataUsers;
        } catch (HttpGenericException e) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public Optional<UsersDto> getUser(String username) throws HttpGenericException {
        if (username.isEmpty())
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El username no puede ser vacío");
        return usersRepository.findByUsername(username);
    }
}
package com.bio.time.domain.service;

import com.bio.time.domain.dto.JwtResponseDto;
import com.bio.time.domain.dto.LoginRequestDto;
import com.bio.time.domain.dto.UsersDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.persistence.repository.ProfilesRepository;
import com.bio.time.persistence.repository.UserRepository;
import com.bio.time.persistence.repository.UsersRepository;
import com.bio.time.web.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Transactional(readOnly = true)
    public Integer validationStatus(LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (loginRequestDto.getUsername() == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo usuario es requerido");

        if (loginRequestDto.getPassword() == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El campo usuario es requerido");

        Optional<UsersDto> userOptional = usersRepository.findByUsername(loginRequestDto.getUsername());
        if (userOptional.isEmpty())
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Usuario y/o contraseña incorrecto(a), por favor verifique la información");

        UsersDto user = userOptional.get();
        if (user.getIdStatus() != 1)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Usuario y/o contraseña incorrecto(a), por favor verifique la información");

        return 1;
    }

    @Transactional
    public JwtResponseDto getDataStart(LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) throws HttpGenericException, IOException {
        try {
            Optional<UsersDto> userdata = usersRepository.findByUsername(loginRequestDto.getUsername());
            UsernamePasswordAuthenticationToken userPasswd = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
            authManager.authenticate(userPasswd);

            String jwt = jwtUtil.generateToken(userdata.get().getUsername(), userdata.get().getId());

            Optional<UsersDto> dataOptional = usersRepository.findByUsername(userdata.get().getUsername());
            if (dataOptional.isEmpty())
                throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Credenciales incorrectas");
            UsersDto data = dataOptional.get();

            JwtResponseDto resultLogin = (new JwtResponseDto(jwt, data.getId(), data.getUsername(), data.getEmail(),
                    data.getCellphone(), data.getName(), data.getLastname(), data.getIdProfile(),
                    data.getIdStatus()));

            return resultLogin;
        } catch (BadCredentialsException e) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Usuario y/o Contraseña incorrecto(a), por favor verifique la información");
        } catch (Exception err) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, err.getMessage());
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*UsersProfilesProjection usersProfilesProjection = usersRepository.findByUsernameAuth(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        ProfilesEntity profilesEntity = profilesRepository.findById(usersProfilesProjection.getIdProfile())
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        UsersEntity usersEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        Collection<? extends GrantedAuthority> authorities = usersEntity.getRoles()
                .stream()
                .map(users -> new SimpleGrantedAuthority("ROLE_".concat(users.getCode().name())))
                .collect(Collectors.toSet());

        return new User(usersEntity.getUsername(),
                usersEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }*/
        Optional<User> user = usersRepository.findOneByUsername(username);
        if (user.isEmpty()) throw new UsernameNotFoundException("Not Found User into DB");
        return user.get();
    }
}

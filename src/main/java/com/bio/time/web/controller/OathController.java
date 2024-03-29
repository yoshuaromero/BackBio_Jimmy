package com.bio.time.web.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.bio.time.domain.dto.TokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;

@RestController
@RequestMapping("oauth")
@CrossOrigin
public class OathController {
    @Value("${google.clientId}") String googleClientId;
    //@Value("${secretPsw}") String secretPsw;

    //@Autowired PasswordEncoder passwordEncoder;
    //@Autowired AuthenticationManager authenticationManager;
    //@Autowired JwtProvider jwtProvider;
    //@Autowired UsuarioService usuarioService;
    //@Autowired RolService rolService;
    @PostMapping("/google")
    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        /*Usuario usuario = new Usuario();
        if(usuarioService.existsEmail(payload.getEmail()))
            usuario = usuarioService.getByEmail(payload.getEmail()).get();
        else
            usuario = saveUsuario(payload.getEmail());
        TokenDto tokenRes = login(usuario);*/
        return new ResponseEntity(payload, HttpStatus.OK);
    }

    /*@PostMapping("/facebook")
    public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
        final String [] fields = {"email", "picture"};
        User user = facebook.fetchObject("me", User.class, fields);
        Usuario usuario = new Usuario();
        if(usuarioService.existsEmail(user.getEmail()))
            usuario = usuarioService.getByEmail(user.getEmail()).get();
        else
            usuario = saveUsuario(user.getEmail());
        TokenDto tokenRes = login(usuario);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    private TokenDto login(Usuario usuario){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setValue(jwt);
        return tokenDto;
    }

    private Usuario saveUsuario(String email){
        Usuario usuario = new Usuario(email, passwordEncoder.encode(secretPsw));
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolUser);
        usuario.setRoles(roles);
        return usuarioService.save(usuario);
    }
*/
}

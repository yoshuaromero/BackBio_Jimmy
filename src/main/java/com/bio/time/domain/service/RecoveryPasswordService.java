package com.bio.time.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bio.time.domain.dto.OptDto;
import com.bio.time.domain.dto.RecoveryPasswordDto;
import com.bio.time.domain.dto.UsersDto;
import com.bio.time.domain.exception.HttpGenericException;
import com.bio.time.domain.util.StringUtil;
import com.bio.time.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecoveryPasswordService {

    @Autowired UsersRepository usersRepository;
    @Autowired StringUtil stringUtil;
    @Value("${email.username}") String emailFrom;
    @Autowired SendNotificationService sendNotificationService;

    //@Transactional(readOnly = true)
    public void findEmailForRecovery(RecoveryPasswordDto recoveryPasswordDto) throws HttpGenericException, JsonProcessingException {
        SimpleMailMessage email = new SimpleMailMessage();
        if (recoveryPasswordDto.getUser() == null && recoveryPasswordDto.getEmail() == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Se debe enviar el usuario o el correo.");
        UsersDto usersDto = null;
        if (recoveryPasswordDto.getUser() != null){
            usersDto = usersRepository.findByUsername(recoveryPasswordDto.getUser()).orElseThrow(() -> new UsernameNotFoundException("El usuario " + recoveryPasswordDto.getUser() + " no existe."));
            email.setTo(usersDto.getEmail());
        } else {
            usersDto = usersRepository.findByEmail(recoveryPasswordDto.getEmail()).orElseThrow(() -> new UsernameNotFoundException("El usuario " + recoveryPasswordDto.getEmail() + " no existe."));
        }
        Map<String, String> opt = stringUtil.generateOPT(4);
        usersDto.setOptRecovery(opt.get("encrypt"));
        this.saveRecovery(usersDto);
        email.setTo(recoveryPasswordDto.getEmail());
        email.setFrom("emailFrom");
        email.setSubject("Mensaje para la recuperación de contraseña.");
        email.setText(String.format("Con este código %s usted podrá recuperar su contraseña de la aplicación.", opt.get("opt")) );
        sendNotificationService.sendEmail(email);
    }
    @Transactional
    public void saveRecovery(UsersDto data) throws HttpGenericException {
        try {
            usersRepository.save(data);
        } catch (Exception e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Map<String, String> findValidateOpt(OptDto optDto) throws HttpGenericException, JsonProcessingException {
        Map<String, String> data = new HashMap<>();
        UsersDto usersDto = usersRepository.findById(optDto.getUserId()).orElseThrow(() -> new UsernameNotFoundException("El usuario " + optDto.getUserId() + " no existe."));
        if (usersDto.getOptRecovery() == null)
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Debe recuperar la contraseña");
        String encrypDto = stringUtil.decryptOpt(usersDto.getOptRecovery());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(encrypDto, HashMap.class);
        List<Object> dateList = (List<Object>) jsonMap.get("date");
        int year = (int) dateList.get(0);
        int month = (int) dateList.get(1);
        int day = (int) dateList.get(2);
        int hour = (int) dateList.get(3);
        int minute = (int) dateList.get(4);
        int second = (int) dateList.get(5);
        int nano = (int) dateList.get(6);

        if (!jsonMap.get("opt").equals(optDto.getOpt())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El código suministrado no corresponde al generado");
        }
        Map<String, String> pw = stringUtil.generatePassword(10);
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second, nano);
        if(LocalDateTime.now().isAfter(dateTime.plusHours(1))){
            throw new HttpGenericException(HttpStatus.NOT_FOUND, "Supero el tiempo de la clave temporal");
        }
        usersDto.setPassword(pw.get("encrypt"));
        usersDto.setOptRecovery(null);
        this.saveRecovery(usersDto);
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(usersDto.getEmail());
        email.setFrom("emailFrom");
        email.setSubject("Mensaje con contraseña temporal.");
        email.setText(String.format("La contraseña temporal es %s, realice cambio de la contraseña.", pw.get("pwd")));
        sendNotificationService.sendEmail(email);
        data.put("data", "ok");
        return data;
    }
}

package com.bio.time.web.controller;

import com.bio.time.domain.service.SendNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMail")
public class SendNotificationController {
    
    @Autowired SendNotificationService sendNotificationService;
    @PostMapping("/v1")
    public ResponseEntity<?> sendMail(){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("comercialitbss@gmail.com");
        email.setFrom("yrom532@gmail.com");
        email.setSubject("Mensaje de prueba1");
        email.setText("No responder este mensaje es una prueba");
        sendNotificationService.sendEmail(email);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}

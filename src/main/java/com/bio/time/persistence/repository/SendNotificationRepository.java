package com.bio.time.persistence.repository;

import com.bio.time.domain.irepository.ISendNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository
public class SendNotificationRepository implements ISendNotificationRepository {

    @Autowired private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(SimpleMailMessage email){
        javaMailSender.send(email);
    }

}

package com.bio.time.domain.service;

import com.bio.time.domain.irepository.ISendNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendNotificationService {

    @Autowired ISendNotificationRepository iSendNotificationRepository;
    public void sendEmail(SimpleMailMessage email) {
        iSendNotificationRepository.sendEmail(email);
    }

}

package com.bio.time.domain.irepository;

import org.springframework.mail.SimpleMailMessage;

public interface ISendNotificationRepository {
    void sendEmail(SimpleMailMessage email);
}

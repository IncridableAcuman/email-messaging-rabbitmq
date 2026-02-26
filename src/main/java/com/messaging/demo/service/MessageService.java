package com.messaging.demo.service;

import com.messaging.demo.dto.EmailPayload;
import com.messaging.demo.dto.EmailResponse;
import com.messaging.demo.util.MailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MailUtil mailUtil;

    public EmailResponse sendMail(EmailPayload payload){
        mailUtil.handleEmailMessage(payload);
        return new EmailResponse(
                payload.getTo(),
                payload.getSubject(),
                payload.getBody(),
                LocalDateTime.now()
        );
    }
}

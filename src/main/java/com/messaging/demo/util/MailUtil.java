package com.messaging.demo.util;

import com.messaging.demo.config.RabbitMQConfig;
import com.messaging.demo.dto.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailUtil {

    private final JavaMailSender javaMailSender;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleEmailMessage(EmailPayload payload){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(payload.getTo());
        message.setSubject(payload.getSubject());
        message.setText(payload.getBody());
        javaMailSender.send(message);
    }
}

package com.messaging.demo.procuder;

import com.messaging.demo.config.RabbitMQConfig;
import com.messaging.demo.dto.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    public void queueEmail(EmailPayload payload){
        rabbitTemplate
                .convertAndSend(
                        RabbitMQConfig.QUEUE_EXCHANGE,
                        RabbitMQConfig.ROUTING_KEY,
                        payload
                );
    }
}

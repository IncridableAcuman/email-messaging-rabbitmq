package com.messaging.demo.dto;

import java.time.LocalDateTime;

public record EmailResponse(
        String to,
        String subject,
        String text,
        LocalDateTime time
) {
}

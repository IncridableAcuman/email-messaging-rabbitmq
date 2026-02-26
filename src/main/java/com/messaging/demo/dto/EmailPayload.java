package com.messaging.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailPayload {
    private String to;
    private String subject;
    private String body;
}

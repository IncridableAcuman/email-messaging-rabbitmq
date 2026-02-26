package com.messaging.demo.controller;

import com.messaging.demo.dto.EmailPayload;
import com.messaging.demo.dto.EmailResponse;
import com.messaging.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    @PostMapping("/send")
    public ResponseEntity<EmailResponse> sendMessage(@RequestBody EmailPayload payload){
        return ResponseEntity.ok(messageService.sendMail(payload));
    }
}

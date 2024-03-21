package com.racemus.eurocontrol.idltojavaclientnats;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final NatsPublisher natsPublisher;

    @GetMapping("/test")
    public ResponseEntity<String> triggerPublish() {
        try {
            natsPublisher.publisher();
            return ResponseEntity.ok("Message sent");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send message");
        }
    }
}

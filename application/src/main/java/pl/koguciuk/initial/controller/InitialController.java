package pl.koguciuk.initial.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.koguciuk.initial.example.MessageLogger;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class InitialController {

    private final MessageLogger messageLogger;

    @GetMapping("/logMessage")
    public ResponseEntity<?> logMessage() {
        messageLogger.logMessage("There is some message logger at: " + LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

}

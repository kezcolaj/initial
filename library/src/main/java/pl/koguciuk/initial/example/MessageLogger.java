package pl.koguciuk.initial.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageLogger {

    public void logMessage(String message) {
        log.info(message);
    }
}

package pl.koguciuk.initial.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pl.koguciuk.initial.example.MessageLogger;

@Configuration
public class LibraryConfig {

    @Bean
    @Primary
    public MessageLogger messageLogger() {
        return new MessageLogger();
    }
}

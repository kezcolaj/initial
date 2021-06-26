package pl.koguciuk.initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import pl.koguciuk.initial.security.config.ApplicationSecurityConfig;
import pl.koguciuk.initial.security.config.LibraryConfig;

@SpringBootApplication
@ComponentScan({
        "pl.koguciuk.initial.*"
})
@Import({
        LibraryConfig.class,
        ApplicationSecurityConfig.class
})
public class InitialApplication {

    public static void main(String[] args) {
        SpringApplication.run(InitialApplication.class, args);
    }

}

package pl.koguciuk.initial.configuration;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Map;

@Configuration
@Testcontainers
public class PostgresContextConfiguration implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.1");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        postgreSQLContainer.start();

        TestPropertyValues.of(Map.of(
                "spring.datasource.url", postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username", postgreSQLContainer.getUsername(),
                "spring.datasource.password", postgreSQLContainer.getPassword()
        )).applyTo(applicationContext);
    }
}

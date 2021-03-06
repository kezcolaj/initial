package pl.koguciuk.initial.integration.security.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import pl.koguciuk.initial.configuration.DemoIntegrationTest
import spock.lang.Specification

@DemoIntegrationTest
class PasswordEncoderIT extends Specification {

    @Autowired
    PasswordEncoder passwordEncoder

    def "should encode and decode password"() {
        given:
            def plainPassword = "some_password"

        when:
            def encodedPassword = passwordEncoder.encode(plainPassword)

        then:
            encodedPassword != null
    }
}

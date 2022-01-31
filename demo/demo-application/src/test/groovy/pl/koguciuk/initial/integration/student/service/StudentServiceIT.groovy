package pl.koguciuk.initial.integration.student.service

import org.springframework.beans.factory.annotation.Autowired
import pl.koguciuk.initial.configuration.DemoIntegrationTest
import pl.koguciuk.initial.student.service.StudentService
import spock.lang.Specification

@DemoIntegrationTest
class StudentServiceIT extends Specification {

    @Autowired
    StudentService service

    def "Should get student by id"() {
        given:
            def id = 1

        when:
            def result = service.getStudent(id)

        then:
            result.studentId == id
    }
}

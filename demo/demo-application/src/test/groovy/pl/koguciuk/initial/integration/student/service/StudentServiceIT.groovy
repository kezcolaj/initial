package pl.koguciuk.initial.integration.student.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.koguciuk.initial.student.service.StudentService
import spock.lang.Specification

@SpringBootTest
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

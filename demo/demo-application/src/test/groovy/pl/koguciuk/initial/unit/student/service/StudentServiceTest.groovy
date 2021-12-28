package pl.koguciuk.initial.unit.student.service

import pl.koguciuk.initial.student.service.StudentService
import spock.lang.Specification

class StudentServiceTest extends Specification {

    StudentService service

    def setup() {
        service = new StudentService()
    }

    def "should get student by id"() {
        given:
            def id = 1

        when:
            def result = service.getStudent(id)

        then:
            result.studentId == id
    }
}

package pl.koguciuk.demo.api.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.koguciuk.demo.api.student.dto.StudentDTO;

@RequestMapping(StudentResource.STUDENT_PATH)
public interface StudentResource {

    String STUDENT_PATH = "api/v1/students";

    @GetMapping(path = "{studentId}")
    StudentDTO getStudent(@PathVariable("studentId") Integer studentId);
}

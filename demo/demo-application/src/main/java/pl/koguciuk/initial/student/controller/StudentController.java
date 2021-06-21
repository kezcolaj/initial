package pl.koguciuk.initial.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.koguciuk.demo.api.student.StudentResource;
import pl.koguciuk.demo.api.student.dto.StudentDTO;
import pl.koguciuk.initial.student.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentResource {

    private final StudentService studentService;

    @Override
    public StudentDTO getStudent(Integer studentId) {
        return studentService.getStudent(studentId);
    }
}

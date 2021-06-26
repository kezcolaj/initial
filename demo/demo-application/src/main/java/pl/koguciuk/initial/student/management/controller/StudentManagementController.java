package pl.koguciuk.initial.student.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.koguciuk.demo.api.student.management.StudentManagementResource;
import pl.koguciuk.demo.api.student.dto.StudentDTO;
import pl.koguciuk.initial.student.management.service.StudentManagementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentManagementController implements StudentManagementResource {

    private final StudentManagementService studentManagementService;

    @Override
    public List<StudentDTO> getStudents() {
        return studentManagementService.getStudents();
    }

    @Override
    public void insertStudent(StudentDTO studentDTO) {
        studentManagementService.insertStudent(studentDTO);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentManagementService.deleteStudent(studentId);
    }

    @Override
    public void updateStudent(Integer studentId, StudentDTO studentDTO) {
        studentManagementService.updateStudent(studentId, studentDTO);
    }
}

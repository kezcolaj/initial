package pl.koguciuk.demo.api.student.management;

import org.springframework.web.bind.annotation.*;
import pl.koguciuk.demo.api.student.dto.StudentDTO;

import java.util.List;

@RequestMapping(StudentManagementResource.STUDENT_MANAGEMENT_PATH)
public interface StudentManagementResource {

    String STUDENT_MANAGEMENT_PATH = "management/api/v1/students";

    @GetMapping
    List<StudentDTO> getStudents();

    @PostMapping
    void insertStudent(@RequestBody StudentDTO studentDTO);

    @DeleteMapping(path = "{studentId}")
    void deleteStudent(@PathVariable("studentId") Integer studentId);

    @PutMapping(path = "{studentId}")
    void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody StudentDTO studentDTO);
}

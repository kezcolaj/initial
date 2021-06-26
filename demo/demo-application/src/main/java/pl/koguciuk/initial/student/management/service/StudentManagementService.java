package pl.koguciuk.initial.student.management.service;

import org.springframework.stereotype.Service;
import pl.koguciuk.demo.api.student.dto.StudentDTO;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentManagementService {

    private static final List<StudentDTO> STUDENT_LIST = Arrays.asList(
            StudentDTO.builder().studentId(1).name("Jan Kowalski").build(),
            StudentDTO.builder().studentId(2).name("Tomasz Nowak").build(),
            StudentDTO.builder().studentId(3).name("Anna Krawczyk").build()
    );

    public List<StudentDTO> getStudents() {
        return STUDENT_LIST;
    }

    public void insertStudent(StudentDTO studentDTO) {
        System.out.println(studentDTO);
    }

    public void deleteStudent(Integer studentId) {
        System.out.println(studentId);
    }

    public void updateStudent(Integer studentId, StudentDTO studentDTO) {
        System.out.printf("%s %s%n", studentId, studentDTO);
    }
}

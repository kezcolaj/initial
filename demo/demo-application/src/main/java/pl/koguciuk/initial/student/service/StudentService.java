package pl.koguciuk.initial.student.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.koguciuk.demo.api.student.dto.StudentDTO;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private static final List<StudentDTO> STUDENT_LIST = Arrays.asList(
            StudentDTO.builder().studentId(1).name("Jan Kowalski").build(),
            StudentDTO.builder().studentId(2).name("Tomasz Nowak").build(),
            StudentDTO.builder().studentId(3).name("Anna Krawczyk").build()
    );

    public StudentDTO getStudent(Integer id) {
        return STUDENT_LIST.stream()
                .filter(t -> id.equals(t.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with id " + id + " not found"));
    }
}

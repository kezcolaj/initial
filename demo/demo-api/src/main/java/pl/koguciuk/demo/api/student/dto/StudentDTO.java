package pl.koguciuk.demo.api.student.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StudentDTO {

    Integer studentId;
    String name;
}

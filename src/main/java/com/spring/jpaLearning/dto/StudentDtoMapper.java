package com.spring.jpaLearning.dto;

import com.spring.jpaLearning.entities.Student;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentDtoMapper implements Function<Student, StudentDTO> {
    @Override
    public StudentDTO apply(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getTeacher(), student.getSubjects());
    }
}

package com.spring.jpaLearning.dto;

import com.spring.jpaLearning.entities.Teacher;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherDtoMapper implements Function<Teacher, TeacherDTO> {
    @Override
    public TeacherDTO apply(Teacher teacher) {
        return new TeacherDTO(teacher.getId(), teacher.getName(), teacher.getStudents());
    }
}

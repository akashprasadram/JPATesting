package com.spring.jpaLearning.dto;

import com.spring.jpaLearning.entities.Subject;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SubjectDtoMapper implements Function<Subject, SubjectDTO> {
    @Override
    public SubjectDTO apply(Subject subject) {
        return new SubjectDTO(subject.getId(), subject.getName(), subject.getStudent());
    }
}

package com.spring.jpaLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpaLearning.entities.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}

package com.spring.jpaLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpaLearning.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}

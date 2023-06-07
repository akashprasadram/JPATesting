package com.spring.jpaLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpaLearning.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}

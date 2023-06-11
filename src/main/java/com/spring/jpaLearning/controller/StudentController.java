package com.spring.jpaLearning.controller;

import java.util.ArrayList;
import java.util.List;

import com.spring.jpaLearning.dto.StudentDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpaLearning.dto.StudentDTO;
import com.spring.jpaLearning.entities.Student;
import com.spring.jpaLearning.repo.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private StudentDtoMapper studentDtoMapper;

	
	@PostMapping("/")
	public StudentDTO addStudent(@RequestBody Student student) {
		return studentDtoMapper.apply(studentRepo.save(student));
	}
	
	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable("id") int id) {
		return studentDtoMapper.apply(studentRepo.findById(id).orElseGet(Student::new));
	}
	
	@GetMapping("/")
	public List<StudentDTO> getAllStudent()
	{
		return studentRepo.findAll().stream().map(studentDtoMapper).toList();
	}

}

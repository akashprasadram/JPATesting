package com.spring.jpaLearning.controller;


import java.util.ArrayList;
import java.util.List;

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
	
	@PostMapping("/")
	public StudentDTO addStudent(@RequestBody Student s)
	{
		System.out.println("Student="+s);
		Student student1=studentRepo.save(s);
		
		StudentDTO student=new StudentDTO();
		student.setId(student1.getId());
		student.setName(student1.getName());
		student.setSubjects(student1.getSubjects());
		student.setTeacher(student1.getTeacher());
		
		return student;
	}
	
	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable("id") int id)
	{
		Student student1=studentRepo.findById(id).get();
		
		StudentDTO student=new StudentDTO();
		student.setId(student1.getId());
		student.setName(student1.getName());
		student.setSubjects(student1.getSubjects());
		student.setTeacher(student1.getTeacher());
		System.out.println(student);
		return student;
	}
	
	@GetMapping("/")
	public List<StudentDTO> getAllStudent()
	{
		List<Student> students1=studentRepo.findAll();
		List<StudentDTO> students=new ArrayList<>();
		for(Student s:students1)
		{
			StudentDTO s1=new StudentDTO();
			s1.setId(s.getId());
			s1.setName(s.getName());
			s1.setSubjects(s.getSubjects());
			s1.setTeacher(s.getTeacher());
			students.add(s1);
		}
		return students;
	}

}

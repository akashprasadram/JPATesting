package com.spring.jpaLearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpaLearning.dto.TeacherDTO;
import com.spring.jpaLearning.entities.Teacher;
import com.spring.jpaLearning.repo.TeacherRepo;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherRepo teacherRepo;
	
	@PostMapping("/")
	public TeacherDTO addTeacher(@ModelAttribute("Teacher") Teacher t)
	{
		System.out.println("Teacher="+t);
		Teacher teacher1=teacherRepo.save(t);
		
		TeacherDTO teacher=new TeacherDTO();
		teacher.setId(teacher1.getId());
		teacher.setName(teacher1.getName());
		teacher.setStudents(teacher1.getStudents());
		
		return teacher;
	}
	
	@GetMapping("/{id}")
	public TeacherDTO getTeacherById(@PathVariable("id") int id)
	{
		Teacher teacher1=teacherRepo.findById(id).get();
		
		TeacherDTO teacher=new TeacherDTO();
		teacher.setId(teacher1.getId());
		teacher.setName(teacher1.getName());
		teacher.setStudents(teacher1.getStudents());
		System.out.println(teacher);
		return teacher;
	}
	
	@GetMapping("/")
	public List<TeacherDTO> getAllTeacher()
	{
		List<Teacher> teachers1=teacherRepo.findAll();
		List<TeacherDTO> teachers=new ArrayList<>();
		for(Teacher t:teachers1)
		{
			TeacherDTO t1=new TeacherDTO();
			t1.setId(t.getId());
			t1.setName(t.getName());
			t1.setStudents(t.getStudents());
			teachers.add(t1);
		}
		return teachers;
	}
}

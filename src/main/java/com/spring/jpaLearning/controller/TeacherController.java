package com.spring.jpaLearning.controller;

import java.util.ArrayList;
import java.util.List;

import com.spring.jpaLearning.dto.TeacherDtoMapper;
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

	@Autowired
	private TeacherDtoMapper teacherDtoMapper;

	@PostMapping("/")
	public TeacherDTO addTeacher(@ModelAttribute("Teacher") Teacher teacher) {
		return teacherDtoMapper.apply(teacherRepo.save(teacher));
	}
	
	@GetMapping("/{id}")
	public TeacherDTO getTeacherById(@PathVariable("id") int id) {
		return teacherDtoMapper.apply(teacherRepo.findById(id).orElseGet(Teacher::new));
	}
	
	@GetMapping("/")
	public List<TeacherDTO> getAllTeacher() {
		return teacherRepo.findAll().stream().map(teacherDtoMapper).toList();
	}
}

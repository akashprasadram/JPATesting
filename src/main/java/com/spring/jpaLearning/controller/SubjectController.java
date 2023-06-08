package com.spring.jpaLearning.controller;

import java.util.ArrayList;
import java.util.List;

import com.spring.jpaLearning.dto.SubjectDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.jpaLearning.dto.SubjectDTO;
import com.spring.jpaLearning.entities.Subject;
import com.spring.jpaLearning.repo.SubjectRepo;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectRepo subjectRepo;

	@Autowired
	private SubjectDtoMapper subjectDtoMapper;
	
	@PostMapping("/")
	public SubjectDTO addSubject(@ModelAttribute("Subject") Subject subject) {
		return subjectDtoMapper.apply(subjectRepo.save(subject));
	}
	
	@GetMapping("/{id}")
	public SubjectDTO getSubjectById(@PathVariable("id") int id) {
		return subjectDtoMapper.apply(subjectRepo.findById(id).orElseGet(Subject::new));
	}
	
	@GetMapping("/")
	public List<SubjectDTO> getAllSubject() {
		return subjectRepo.findAll().stream().map(subjectDtoMapper).toList();
	}
}

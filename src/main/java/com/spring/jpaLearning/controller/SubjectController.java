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


import com.spring.jpaLearning.dto.SubjectDTO;
import com.spring.jpaLearning.entities.Subject;
import com.spring.jpaLearning.repo.SubjectRepo;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectRepo subjectRepo;
	
	@PostMapping("/")
	public SubjectDTO addSubject(@ModelAttribute("Subject") Subject s)
	{
		System.out.println("Subject="+s);
		Subject subject1=subjectRepo.save(s);
		
		SubjectDTO subject=new SubjectDTO();
		subject.setId(subject1.getId());
		subject.setName(subject1.getName());
		subject.setStudent(subject1.getStudent());
		
		return subject;
	}
	
	@GetMapping("/{id}")
	public SubjectDTO getSubjectById(@PathVariable("id") int id)
	{
		Subject subject1=subjectRepo.findById(id).get();
		
		SubjectDTO subject=new SubjectDTO();
		subject.setId(subject1.getId());
		subject.setName(subject1.getName());
		subject.setStudent(subject1.getStudent());
		
		return subject;
	}
	
	@GetMapping("/")
	public List<SubjectDTO> getAllSubject()
	{
		List<Subject> subjects1=subjectRepo.findAll();
		
		List<SubjectDTO> subjects=new ArrayList<>();
		
		for(Subject s:subjects1) {
			SubjectDTO subject=new SubjectDTO();
			subject.setId(s.getId());
			subject.setName(s.getName());
			subject.setStudent(s.getStudent());
			subjects.add(subject);
		}
		return subjects;
	}
}

package com.spring.jpaLearning.dto;

import com.spring.jpaLearning.entities.Student;

public class SubjectDTO {
	private int id;
	private String name;
	
	Student student;

	public SubjectDTO() {
		super();
	}

	public SubjectDTO(int id, String name, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "SubjectDTO [id=" + id + ", name=" + name + ", student=" + student + "]";
	}

	
}

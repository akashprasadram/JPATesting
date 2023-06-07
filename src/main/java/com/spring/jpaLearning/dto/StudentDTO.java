package com.spring.jpaLearning.dto;

import java.util.List;

import com.spring.jpaLearning.entities.Subject;
import com.spring.jpaLearning.entities.Teacher;



public class StudentDTO {
	private int id;
	private String name;
	Teacher teacher;
	
	List<Subject> subjects;

	public StudentDTO() {
		super();
	}

	public StudentDTO(int id, String name, Teacher teacher, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.subjects = subjects;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", teacher=" + teacher + ", subjects=" + subjects + "]";
	}


	
}

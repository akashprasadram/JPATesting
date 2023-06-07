package com.spring.jpaLearning.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.jpaLearning.entities.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


public class TeacherDTO {

	private int id;
	private String name;
	
	private List<Student> students;

	public TeacherDTO() {
		super();
	}

	public TeacherDTO(int id, String name, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "TeacherDTO [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

}

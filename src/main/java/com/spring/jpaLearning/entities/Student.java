package com.spring.jpaLearning.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	Teacher teacher;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "student")
	List<Subject> subjects;

	public Student() {
		super();
	}

	public Student(int id, String name, Teacher teacher, List<Subject> subjects) {
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
		return "Student [id=" + id + ", name=" + name + ", teacher=" + teacher + ", subjects=" + subjects + "]";
	}
	
}

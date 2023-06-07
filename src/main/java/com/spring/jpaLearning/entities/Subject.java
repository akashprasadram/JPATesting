package com.spring.jpaLearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	
	@ManyToOne
	@JsonIgnore
	Student student;

	public Subject() {
		super();
	}

	public Subject(int id, String name, Student student) {
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
		return "Subject [id=" + id + ", name=" + name + "]";
	}
}

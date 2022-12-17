package com.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	private String cname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sclasses")
	private List<Subject> subjects = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "tclasses")
	private List<Teacher> teachers = new ArrayList<>();;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classes")
	private List<Student> students = new ArrayList<>();

	
	public Classes() {
	}

	public Classes(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject subjects) {
		this.subjects.add(subjects);
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher teachers) {
		this.teachers.add(teachers);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students.add(students);
	}
	
	
	
	
}

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tId;
	
	private String tname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	private List<Subject> subjects = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="teacher_classes", joinColumns = @JoinColumn(name="tId"), inverseJoinColumns = @JoinColumn(name="cId"))
	private List<Classes> tclasses = new ArrayList<>();

	public Teacher() {
	}

	public Teacher(String tname) {
		super();
		this.tname = tname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject subjects) {
		this.subjects.add(subjects);
	}

	public List<Classes> getClasses() {
		return tclasses;
	}

	public void setClasses(Classes classes) {
		this.tclasses.add(classes);
	}
	
	
}


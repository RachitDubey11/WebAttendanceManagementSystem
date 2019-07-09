package com.projectspring.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component("semdept")
@Entity
public class Semdept {
	
@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
private int idSem;

@Transient
@OneToMany(cascade= {CascadeType.ALL})
private Set<Percent> percent;

public Set<Percent> getPercent() {
	return percent;
}
public void setPercent(Set<Percent> percent) {
	this.percent = percent;
}
public Set<Attendance> getAttendance() {
	return attendance;
}
public void setAttendance(Set<Attendance> attendance) {
	this.attendance = attendance;
}
public List<TeacherSemdeptSubject> getTeacherSemdeptSubject() {
	return teacherSemdeptSubject;
}
public void setTeacherSemdeptSubject(List<TeacherSemdeptSubject> teacherSemdeptSubject) {
	this.teacherSemdeptSubject = teacherSemdeptSubject;
}


@Transient
@OneToMany(cascade= {CascadeType.ALL})
private Set<Attendance> attendance;


@OneToMany(fetch=FetchType.EAGER,mappedBy="semdept",cascade= {CascadeType.ALL})
private List<Student> student;


public List<Student> getStudent() {
	return student;
}
public void setStudent(List<Student> student) {
	this.student = student;
}
 
@ManyToMany(mappedBy="semdept",cascade= {CascadeType.ALL})
private List <Subject> subject=new ArrayList<>();


/*@ManyToMany(mappedBy="semdept",cascade= {CascadeType.ALL})
private List <Teacher> teacher=new ArrayList<>();*/

@Transient
@OneToMany(cascade= {CascadeType.ALL})
private List<TeacherSemdeptSubject> teacherSemdeptSubject;


/*public List<Teacher> getTeacher() {
	return teacher;
}
public void setTeacher(List<Teacher> teacher) {
	this.teacher = teacher;
}*/

public List<Subject> getSubject() {
	return subject;
}
public void setSubject(List<Subject> subject) {
	this.subject = subject;
}

public int getIdSem() {
	return idSem;
}
public void setIdSem(int idSem) {
	this.idSem = idSem;
}
public String getSemName() {
	return semName;
}
public void setSemName(String semName) {
	this.semName = semName;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
private String semName;
private String dept;
}

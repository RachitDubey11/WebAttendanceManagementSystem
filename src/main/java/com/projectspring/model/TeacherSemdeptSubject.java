package com.projectspring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component("teachersemdeptsubject")
@Entity
public class TeacherSemdeptSubject {
	@Override
	public String toString() {
		return "TeacherSemdeptSubject [id=" + id + ", subject=" + subject + ", semdept=" + semdept + ", teacher="
				+ teacher + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne
    private Subject subject;
    @ManyToOne
    private Semdept semdept;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Year year;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Semdept getSemdept() {
		return semdept;
	}
	public void setSemdept(Semdept semdept) {
		this.semdept = semdept;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}

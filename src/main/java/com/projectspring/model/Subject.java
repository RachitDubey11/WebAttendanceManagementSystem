package com.projectspring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Subject {	

	@Transient
@OneToMany(cascade= {CascadeType.ALL})
private Set<Attendance> attendance;

	@Transient	
@OneToMany(cascade= {CascadeType.ALL})
private Set<Percent> percent;
	
	public Set<Percent> getPercent() {
	return percent;
}

public void setPercent(Set<Percent> percent) {
	this.percent = percent;
}

	public List<Semdept> getSemdept() {
		return semdept;
	}

	public void setSemdept(List<Semdept> semdept) {
		this.semdept = semdept;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name = "Semdept_Subject", 
	         joinColumns = { @JoinColumn(name = "code") },  
	         inverseJoinColumns = { @JoinColumn(name = "idSem") })
	private List <Semdept> semdept=new ArrayList<>();
	
	
	@Transient
	@OneToMany(cascade= CascadeType.ALL)
	private List<TeacherSemdeptSubject> teacherSemdeptSubject;
	
	
	
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

	public int getCode() {
		return code;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@NotEmpty
	@Pattern(regexp="[^0-9]+")
	@Column(nullable=false)
	private String subjectName;
	
}

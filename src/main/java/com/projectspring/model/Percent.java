package com.projectspring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Percent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPercent;
	

	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="student_idStudent")
	private Student student;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idSem")
	private Semdept semdept;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="code")
	private Subject subject;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	private Year year;
	
	public Student getStudent() {
		return student;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Semdept getSemdept() {
		return semdept;
	}
	public void setSemdept(Semdept semdept) {
		this.semdept = semdept;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getIdPercent() {
		return idPercent;
	}
	public void setIdPercent(int idPercent) {
		this.idPercent = idPercent;
	}
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		this.attend = attend;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	@Column( nullable=false)
	private int attend;
	@Column( nullable=false)
	private int total;
	@Column( nullable=false)
	private float percentage;
	@Column( nullable=false)	
	private String quarter;

	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

}

package com.projectspring.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Attendance {

	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="student_idStudent")
	private Student student;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idMonth")
	private Month month;
	
	@ManyToOne
	private Year year;
	
	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="code")
	private Subject subject;
	
	@Override
	public String toString() {
		return "Attendance [subject=" + subject + ",student=" + student + " ,semdept=" + semdept + ", idAttendance=" + idAttendance + ", aDate="
				+ aDate + ", status=" + status + "]";
	}
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idSem")
	private Semdept semdept;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aDate == null) ? 0 : aDate.hashCode());
		result = prime * result + idAttendance;
		result = prime * result + ((semdept == null) ? 0 : semdept.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public int getIdAttendance() {
		return idAttendance;
	}
	public void setIdAttendance(int idAttendance) {
		this.idAttendance = idAttendance;
	}
	
	
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAttendance;
	@Column( nullable=false)
	@Temporal(TemporalType.DATE)
	private Date aDate;
	@Column( nullable=false)
	private String status;
	@Column( nullable=false)
	private String quarter;

	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
}

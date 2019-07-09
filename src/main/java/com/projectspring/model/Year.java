package com.projectspring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Year {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idYear;
	
	@Column( nullable=false)
	private int yearName;
	
	public int getYearName() {
		return yearName;
	}

	public void setYearName(int yearName) {
		this.yearName = yearName;
	}

	@Transient
	@OneToMany(cascade= {CascadeType.ALL})
	private List<Student> student;

	@Transient
	@OneToMany(cascade= {CascadeType.ALL})
	private List<Attendance> attendance;
	
	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	@Transient
	@OneToMany(cascade= {CascadeType.ALL})
	private List<TeacherSemdeptSubject> teachersemdeptsubject;
	
	@Transient
	@OneToMany(cascade= {CascadeType.ALL})
	private List<Percent> percent;
	
	public List<Percent> getPercent() {
		return percent;
	}

	public void setPercent(List<Percent> percent) {
		this.percent = percent;
	}

	public List<TeacherSemdeptSubject> getTeachersemdeptsubject() {
		return teachersemdeptsubject;
	}

	public void setTeachersemdeptsubject(List<TeacherSemdeptSubject> teachersemdeptsubject) {
		this.teachersemdeptsubject = teachersemdeptsubject;
	}

	public int getIdYear() {
		return idYear;
	}

	public void setIdYear(int idYear) {
		this.idYear = idYear;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

}

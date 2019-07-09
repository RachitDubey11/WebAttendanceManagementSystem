package com.projectspring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTeacher;

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="login_idLogin")
	private User user;
	
@Transient
@OneToMany(cascade= {CascadeType.ALL})
private List<TeacherSemdeptSubject> teacherSemdeptSubject;

	
	
	
	public List<TeacherSemdeptSubject> getTeacherSemdeptSubject() {
	return teacherSemdeptSubject;
}
public void setTeacherSemdeptSubject(List<TeacherSemdeptSubject> teacherSemdeptSubject) {
	this.teacherSemdeptSubject = teacherSemdeptSubject;
}
	public Integer getIdTeacher() {
		return idTeacher;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	@NotEmpty
	@Pattern(regexp="[^0-9]+")
	@Column( nullable=false)
	private String teacherName;
	
	@Email
	private  String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Min(value = 1000000000)
	private Long phoneNumber;
	
}

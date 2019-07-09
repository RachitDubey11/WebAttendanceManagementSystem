package com.projectspring.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component("student")
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer idStudent;

	@Transient
	@OneToMany(cascade= {CascadeType.ALL})
	private Set<Percent> percent;

	@ManyToOne
	private Year year;
	
	public Set<Percent> getPercent() {
		return percent;
	}
	public void setPercent(Set<Percent> percent) {
		this.percent = percent;
	}
	public List<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", semdept=" + semdept + ", attendance=" + attendance + ", user="
				+ user + ", studentName=" + studentName + "]";
	}


	@ManyToOne
	@JoinColumn(name="idSem")
	private Semdept semdept;





@Transient
@OneToMany(cascade= CascadeType.ALL)
private List<Attendance> attendance;	


	public Semdept getSemdept() {
		return semdept;
	}
	public void setSemdept(Semdept semdept) {
		this.semdept = semdept;
	}


	@OneToOne(fetch=FetchType.EAGER,cascade= {CascadeType.ALL})
	@JoinColumn(name="login_idLogin")
	private User user;
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}
	public String getStudentName() {
		return studentName;
	}
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
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}


	@NotEmpty
	@Pattern(regexp="[^0-9]+")
	@Column( nullable=false)
	private String studentName;
	
	@Email
	private  String email;
	@Min(value = 1000000000)
	private Long phoneNumber;

}

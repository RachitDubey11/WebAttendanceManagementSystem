package com.projectspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
@Entity
public class Month {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMonth;
	
	
	@OneToMany(mappedBy="month",cascade= CascadeType.ALL)
	private List<Attendance> attendance;	

	@Override
	public String toString() {
		return "Month [idMonth=" + idMonth + ", attendance=" + attendance + ", monthName=" + monthName + "]";
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	public int getIdMonth() {
		return idMonth;
	}

	public void setIdMonth(int idMonth) {
		this.idMonth = idMonth;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	
	@Column( nullable=false)
	private String monthName;

}

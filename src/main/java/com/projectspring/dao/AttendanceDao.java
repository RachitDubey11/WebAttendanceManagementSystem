package com.projectspring.dao;

import java.util.Date;
import java.util.List;

import com.projectspring.model.Attendance;
import com.projectspring.model.Month;
import com.projectspring.model.Percent;
import com.projectspring.model.Semdept;
import com.projectspring.model.TeacherSemdeptSubject;
import com.projectspring.model.Year;

public interface AttendanceDao {
	public void create(Attendance attendance,int idStudent);
	public void create(int idSem,int code,int month,String date,int idStudent);

	public void createAbsent(Attendance attendance,int idStudent);
	public void createAbsent(int idSem,int code,int month,String date,int idStudent);

	
    public void checkInPercentStatusOfPresent(int idSem,int code,int idStudent,int idyear);
    public void checkInPercentStatusOfAbsent(int idSem,int code,int idStudent,int idYear);
    
	public List<Percent> search(int idSem,int code,int idYear);
	
	public List<Attendance> find(int idSem,int idStudent,int code);
	public List<Month> findAll();
	public Month findMonthName(int idMonth);

	public List<Attendance> find(int idSem,int idStudent,int code,int idMonth);
	public Month find(Month month);
	public List<Attendance> checkAttendanceTaken(int idSem,int code,String aDate);
	public List<Attendance> checkAttendanceTakenAbsent(int idSem,int code,String aDate);
	public List<Attendance> takeOlderAttendance(int idSem,int code,int idMonth);
	public void delete(int idSem,int code,String date);
public String checkStatus(int idSem, int code, String date);
public int find(int year);
public Year find(Year year);

public List<Attendance> dailyStudentAttendance(int idStudent, int idSem , int code,int idYear); 
public List<Attendance> monthlyStudentAttendance(int idStudent, int idSem, int code, int idMonth, int idYear);

public List<Attendance> dateWiseAttendance(int idSem, int code, String date,int idMonth); 

}

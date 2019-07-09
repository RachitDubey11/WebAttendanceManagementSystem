package com.projectspring.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectspring.dao.AttendanceDao;
import com.projectspring.model.Attendance;
import com.projectspring.model.Month;
import com.projectspring.model.Percent;
import com.projectspring.model.Year;
import com.projectspring.service.AttendanceService;

@Service("attendanceService")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceDao attendanceDao;
	
	@Override
	public void create(Attendance attendance,int idStudent) {
	attendanceDao.create(attendance,idStudent);
	}

	@Override
	public void createAbsent(Attendance attendance,int idStudent) {
		attendanceDao.createAbsent(attendance,idStudent);
		
	}

	@Override
	public void checkInPercentStatusOfPresent(int idSem, int code, int idStudent,int idYear) {
		// TODO Auto-generated method stub
		attendanceDao.checkInPercentStatusOfPresent(idSem,code,idStudent,idYear);
	}

	@Override
	public void checkInPercentStatusOfAbsent(int idSem, int code, int idStudent,int idYear) {
		attendanceDao.checkInPercentStatusOfAbsent(idSem,code,idStudent,idYear);
		
	}

	@Override
	public List<Percent> search(int idSem, int code,int idYear) {
		// TODO Auto-generated method stub
		return attendanceDao.search(idSem, code,idYear);
	}

	@Override
	public List<Attendance> find(int idSem, int idStudent, int code) {
		// TODO Auto-generated method stub
		return attendanceDao.find(idSem, idStudent, code);
	}

	@Override
	public List<Month> findAll() {
		// TODO Auto-generated method stub
		return attendanceDao.findAll();
	}

	@Override
	public List<Attendance> find(int idSem, int idStudent, int code, int idMonth) {
		// TODO Auto-generated method stub
		return attendanceDao.find(idSem, idStudent, code, idMonth);
	}

	@Override
	public Month find(Month month) {
		// TODO Auto-generated method stub
		return attendanceDao.find(month);
	}

	@Override
	public List<Attendance> checkAttendanceTaken(int idSem, int code, String aDate) {
		// TODO Auto-generated method stub
		return attendanceDao.checkAttendanceTaken(idSem,code,aDate);
	}

	@Override
	public List<Attendance> checkAttendanceTakenAbsent(int idSem, int code, String aDate) {
		// TODO Auto-generated method stub
		return attendanceDao.checkAttendanceTakenAbsent(idSem,code,aDate);
	}

	@Override
	public List<Attendance> takeOlderAttendance(int idSem, int code, int idMonth) {
		// TODO Auto-generated method stub
		return attendanceDao.takeOlderAttendance(idSem, code, idMonth);
	}

	@Override
	public void create(int idSem, int code, int month, String date, int idStudent) {
		// TODO Auto-generated method stub
		attendanceDao.create(idSem, code, month, date, idStudent);
	}

	@Override
	public void createAbsent(int idSem, int code, int month, String date, int idStudent) {
		// TODO Auto-generated method stub
		attendanceDao.createAbsent(idSem, code, month, date, idStudent);
	}

	@Override
	public void delete(int idSem, int code, String date) {
		// TODO Auto-generated method stub
		attendanceDao.delete(idSem, code, date);
	}

	@Override
	public String checkStatus(int idSem, int code, String date) {
		// TODO Auto-generated method stub
		return attendanceDao.checkStatus(idSem, code, date);
	}

	@Override
	public int find(int year) {
		// TODO Auto-generated method stub
		return attendanceDao.find(year);
	}

	@Override
	public Year find(Year year) {
		// TODO Auto-generated method stub
		return attendanceDao.find(year);
	}

	@Override
	public List<Attendance> dailyStudentAttendance(int idStudent, int idSem, int code, int idYear) {
		// TODO Auto-generated method stub
		return attendanceDao.dailyStudentAttendance(idStudent, idSem, code, idYear);
	}

	@Override
	public List<Attendance> monthlyStudentAttendance(int idStudent, int idSem, int code, int idMonth, int idYear) {
		// TODO Auto-generated method stub
		return attendanceDao.monthlyStudentAttendance(idStudent, idSem, code, idMonth, idYear);
	}

	@Override
	public List<Attendance> dateWiseAttendance(int idSem, int code, String date, int idMonth) {
		// TODO Auto-generated method stub
		return attendanceDao.dateWiseAttendance(idSem, code, date, idMonth);
	}

	@Override
	public Month findMonthName(int idMonth) {
		// TODO Auto-generated method stub
		return attendanceDao.findMonthName(idMonth);
	}

}

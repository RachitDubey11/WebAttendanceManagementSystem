package com.projectspring.dao.impl;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectspring.dao.AttendanceDao;
import com.projectspring.model.Attendance;
import com.projectspring.model.Month;
import com.projectspring.model.Percent;
import com.projectspring.model.Semdept;
import com.projectspring.model.TeacherSemdeptSubject;
import com.projectspring.model.Year;
import com.projectspring.service.AttendanceService;

@Repository("attendanceDao")
public class AttendanceDaoImpl implements AttendanceDao{
	 @Autowired
		SessionFactory sessionFactory;
	    protected Session currentSession() {
	    	return sessionFactory.getCurrentSession();
	    }
		@Autowired
		private AttendanceService attendanceService;   
	    
	    
	@Override
	public void create(Attendance attendance,int idStudent) {	
		Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		final BigInteger bigResult2;
		SQLQuery query=currentSession().createSQLQuery("select count(*) from attendance where idSem=? and code=? and aDate=? and student_idStudent=? ");
		query.setParameter(0, attendance.getSemdept().getIdSem());
		query.setParameter(1, attendance.getSubject().getCode());	
		query.setParameter(2, attendance.getaDate());		
		query.setParameter(3, idStudent);		
	  
			bigResult2 = (BigInteger)query.uniqueResult();
		  int  a = bigResult2.intValue();
		if (a!=0)
		{
			SQLQuery q = currentSession().createSQLQuery("update attendance set status=? where idSem=? and code=? and aDate=? and student_idStudent=?");		
			q.setParameter(0, "P");
			q.setParameter(1, attendance.getSemdept().getIdSem());
			q.setParameter(2, attendance.getSubject().getCode());	
			q.setParameter(3, attendance.getaDate());		
			q.setParameter(4, idStudent);
			q.executeUpdate();
		}
		else
		{
			SQLQuery q = currentSession().createSQLQuery("insert into attendance (aDate,status,student_idStudent,idSem,code,idMonth,quarter,year_idYear) values(?,?,?,?,?,?,?,?)");		
			q.setParameter(0, attendance.getaDate());
			q.setParameter(1, "P");
			q.setParameter(2, idStudent);
			q.setParameter(3, attendance.getSemdept().getIdSem());
			q.setParameter(4, attendance.getSubject().getCode());
			q.setParameter(5, attendance.getMonth().getIdMonth());
			q.setParameter(6, quarter);
			q.setParameter(7, idYear);
			q.executeUpdate();
		}		
	}


	@Override
	public void createAbsent(Attendance attendance,int idStudent) {	
		final BigInteger bigResult2;
		Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		SQLQuery query=currentSession().createSQLQuery("select count(*) from attendance where idSem=? and code=? and aDate=? and student_idStudent=? ");
		query.setParameter(0, attendance.getSemdept().getIdSem());
		query.setParameter(1, attendance.getSubject().getCode());	
		query.setParameter(2, attendance.getaDate());		
		query.setParameter(3, idStudent);		
			bigResult2 = (BigInteger)query.uniqueResult();
		  int  a = bigResult2.intValue();
		if (a!=0)
		{
			SQLQuery q = currentSession().createSQLQuery("update attendance set status=? where idSem=? and code=? and aDate=? and student_idStudent=?");		
			q.setParameter(0, "A");
			q.setParameter(1, attendance.getSemdept().getIdSem());
			q.setParameter(2, attendance.getSubject().getCode());	
			q.setParameter(3, attendance.getaDate());		
			q.setParameter(4, idStudent);
			q.executeUpdate();
		}
		else
		{
			SQLQuery q = currentSession().createSQLQuery("insert into attendance (aDate,status,student_idStudent,idSem,code,idMonth,quarter,year_idYear) values(?,?,?,?,?,?,?,?)");		
			q.setParameter(0, attendance.getaDate());
			q.setParameter(1, "A");
			q.setParameter(2, idStudent);
			q.setParameter(3, attendance.getSemdept().getIdSem());
			q.setParameter(4, attendance.getSubject().getCode());
			q.setParameter(5, attendance.getMonth().getIdMonth());
			q.setParameter(6, quarter);
			q.setParameter(7, idYear);

			q.executeUpdate();
		}
		
	}

	
	
	@Override
	public void checkInPercentStatusOfPresent(int idSem, int code, int idStudent,int idYear) {
		Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
			SQLQuery q1 = currentSession().createSQLQuery("SELECT COUNT(distinct aDate) as total FROM attendance WHERE  idSem =? and code=? and year_idYear=? and quarter=?");		
			q1.setParameter(0, idSem);
			q1.setParameter(1, code);
			q1.setParameter(2, idYear);
			q1.setParameter(3, quarter);

			final BigInteger bigResult;
			final BigInteger bigResult1;
			final BigInteger bigResult2;
			final BigInteger bigResult3;
			
			bigResult = (BigInteger)q1.uniqueResult();
			  int  total = bigResult.intValue();
			
			SQLQuery q2 = currentSession().createSQLQuery("SELECT COUNT(*) FROM attendance WHERE  idSem =? and code=? and student_idStudent=? and status=? and year_idYear=? and quarter=?");		
			q2.setParameter(0, idSem);
			q2.setParameter(1, code);
			q2.setParameter(2, idStudent);
			q2.setParameter(3, "P");
			q2.setParameter(4, idYear);
			q2.setParameter(5, quarter);

			bigResult1 = (BigInteger)q2.uniqueResult();
			  int  attend = bigResult1.intValue();
			  
			  float percentage=(attend/total)*100;

			  
			SQLQuery q = currentSession().createSQLQuery("select count(*) from percent where idSem=? and code=? and student_idStudent=? and year_idYear=? and quarter=?");		
			q.setParameter(0, idSem);
			q.setParameter(1, code);
			q.setParameter(2, idStudent);
			q.setParameter(3, idYear);
			q.setParameter(4, quarter);

			bigResult3 = (BigInteger)q.uniqueResult();
			  int  a = bigResult3.intValue();
			  
			  if(a==0) {
			
			SQLQuery q4 = currentSession().createSQLQuery("INSERT INTO percent (attend,total,percentage,student_idStudent,idSem,code,year_idYear,quarter)\r\n" + 
					" VALUES(?, ?, ?,?,?,?,?,?);");		
			q4.setParameter(0, attend);
			q4.setParameter(1, total);
			q4.setParameter(2, percentage);
			q4.setParameter(3, idStudent);
			q4.setParameter(4, idSem);
			q4.setParameter(5, code);
			q4.setParameter(6, idYear);
			q4.setParameter(7, quarter);

            q4.executeUpdate();            
				 }

			 
			else {
			SQLQuery q5 = currentSession().createSQLQuery(" update percent set attend=?,total=?,percentage=(attend/total)*100 where idSem=? and code=? and student_idStudent=? and year_idYear=? and quarter=?;");		
			q5.setParameter(0, attend);
			q5.setParameter(1, total);
			q5.setParameter(2, idSem);
			q5.setParameter(3, code);
			q5.setParameter(4, idStudent);
			q5.setParameter(5, idYear);
			q5.setParameter(6, quarter);
            q5.executeUpdate();
			}
	
	}

	
	
	@Override
	public void checkInPercentStatusOfAbsent(int idSem, int code, int idStudent,int idYear) {
		final BigInteger bigResult;
		final BigInteger bigResult1;
		final BigInteger bigResult2;
		final BigInteger bigResult3;
		 Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		SQLQuery q1 = currentSession().createSQLQuery("SELECT COUNT(distinct aDate) as total FROM attendance WHERE  idSem =? and code=?  and year_idYear=? and quarter=?");		
		q1.setParameter(0, idSem);
		q1.setParameter(1, code);
		q1.setParameter(2, idYear);
		q1.setParameter(3, quarter);

		bigResult1 = (BigInteger)q1.uniqueResult();
		  int  total = bigResult1.intValue();	
		  
		SQLQuery q2 = currentSession().createSQLQuery("SELECT COUNT(*) as Attend FROM attendance WHERE  idSem =? and code=? and student_idStudent=? and status=? and year_idYear=? and quarter=?");		
		q2.setParameter(0, idSem);
		q2.setParameter(1, code);
		q2.setParameter(2, idStudent);
		q2.setParameter(3, "P");
		q2.setParameter(4, idYear);
		q2.setParameter(5, quarter);

		bigResult = (BigInteger)q2.uniqueResult();
		  int  attend = bigResult.intValue();		
		  float percentage=(attend/total)*100;
 
		  
		SQLQuery q = currentSession().createSQLQuery("select count(*) from percent where idSem=? and code=? and student_idStudent=? and year_idYear=? and quarter=? ");		
		q.setParameter(0, idSem);
		q.setParameter(1, code);
		q.setParameter(2, idStudent);
		q.setParameter(3, idYear);
		q.setParameter(4, quarter);

		bigResult2 = (BigInteger)q.uniqueResult();
		  int  a = bigResult2.intValue();
		  if(a==0) {
				
		SQLQuery q4 = currentSession().createSQLQuery("INSERT INTO percent (attend,total,percentage,student_idStudent,idSem,code,year_idYear,quarter)\r\n" + 
				" VALUES(?, ?, ?,?,?,?,?,?);");		
		q4.setParameter(0, attend);
		q4.setParameter(1, total);
		q4.setParameter(2, percentage);
		q4.setParameter(3, idStudent);
		q4.setParameter(4, idSem);
		q4.setParameter(5, code);
		q4.setParameter(6, idYear);
		q4.setParameter(7, quarter);

        q4.executeUpdate();
		}
		else {
		SQLQuery q5 = currentSession().createSQLQuery(" update percent set attend=?,total=?,percentage=(attend/total)*100 where idSem=? and code=? and student_idStudent=? and year_idYear=? and quarter=?;");		
		q5.setParameter(0, attend);
		q5.setParameter(1, total);
		q5.setParameter(2, idSem);
		q5.setParameter(3, code);
		q5.setParameter(4, idStudent);
		q5.setParameter(5, idYear);
		q5.setParameter(6, quarter);

        q5.executeUpdate();
		}
	}
	
	
	
	@Override
	public List<Percent> search(int idSem, int code,int idYear) {
		Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		SQLQuery query=currentSession().createSQLQuery(" SELECT s.idStudent,u.password,s.studentName,p.attend,p.total,p.percentage FROM percent p inner join student s on p.student_idStudent=s.idStudent inner join app_user u on u.id=s.login_idLogin  where p.idSem=? and p.code=? and p.year_idYear=?");
		query.setParameter(0, idSem);
		query.setParameter(1, code);		
		query.setParameter(2, idYear);
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Percent> sd=query.list(); 
		return sd;
	}

	
	
	@Override
	public List<Attendance> find(int idSem, int idStudent, int code) {
		Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		SQLQuery query=currentSession().createSQLQuery(" SELECT aDate,status FROM attendance where idSem=? and student_idStudent=? and code=? and year_idYear=? and quarter=?");
		query.setParameter(0, idSem);
		query.setParameter(1, idStudent);
		query.setParameter(2, code);	
		query.setParameter(3, idYear);		
		query.setParameter(4, quarter);		

	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		return sd;
	}

	
	
	@Override
	public List<Month> findAll() {
		Criteria cr = currentSession().createCriteria(Month.class);		
	    return cr.list();
	}

	@Override
	public Month findMonthName(int idMonth) {
		return (Month)currentSession().get(Month.class, idMonth);
	}
	
	
	@Override
	public List<Attendance> find(int idSem, int idStudent, int code, int idMonth) {
		Calendar cal = Calendar.getInstance();
		 int month=cal.get(cal.MONTH);
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 String quarter;
		 if(month<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		SQLQuery query=currentSession().createSQLQuery(" select aDate,status from attendance where idSem=? and student_idStudent=? and code=? and idMonth=? and year_idYear=? and quarter=?");
		query.setParameter(0, idSem);
		query.setParameter(1, idStudent);
		query.setParameter(2, code);	
		query.setParameter(3, idMonth);
		query.setParameter(4, idYear);		
		query.setParameter(5, quarter);		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		return sd;
	}

	
	
	@Override
	public Month find(Month month) {
		Query query=currentSession().createQuery("from Month where monthName=?");
		query.setParameter(0, month.getMonthName());		
		List<Month> sd=query.list(); 
		return sd.size() > 0 ? sd.get(0) : null;
	}

	
	
	
	@Override
	public List<Attendance> checkAttendanceTaken(int idSem, int code, String aDate) {
		SQLQuery query=currentSession().createSQLQuery("select s.studentName,s.idStudent,u.password from app_user u inner join student s on u.id=s.login_idLogin inner join attendance a on s.idStudent=a.student_idStudent where a.idSem=? and\r\n" + 
				"a.code=? and a.aDate=? and status=?;");
		query.setParameter(0, idSem);
		query.setParameter(1, code);	
		query.setParameter(2, aDate);		
		query.setParameter(3, "P");		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		if (sd.size() > 0)
			return sd;
		else
			return null;	
	}
	
	
	
	@Override
	public List<Attendance> checkAttendanceTakenAbsent(int idSem, int code, String aDate) {
		SQLQuery query=currentSession().createSQLQuery("select s.studentName,s.idStudent,u.password from app_user u inner join student s on u.id=s.login_idLogin inner join attendance a on s.idStudent=a.student_idStudent where a.idSem=? and\r\n" + 
				"a.code=? and a.aDate=? and status=?;");
		query.setParameter(0, idSem);
		query.setParameter(1, code);	
		query.setParameter(2, aDate);		
		query.setParameter(3, "A");		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		if (sd.size() > 0)
			return sd;
		else
			return null;	
		}

	
	
	@Override
	public List<Attendance> takeOlderAttendance(int idSem, int code, int idMonth) {
			SQLQuery query=currentSession().createSQLQuery(" SELECT aDate,status FROM attendance where idSem=? and code=? and idMonth=?");
			query.setParameter(0, idSem);
			query.setParameter(1, code);		
			query.setParameter(2, idMonth);
		     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Attendance> sd=query.list(); 
			return sd;
	}

	
	
	@Override
	public void create(int idSem, int code, int month, String date, int idStudent) {
		Calendar cal = Calendar.getInstance();
		 int monthh=cal.get(cal.MONTH);
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 String quarter;
		 if(monthh<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		final BigInteger bigResult2;
		SQLQuery query=currentSession().createSQLQuery("select count(*) from attendance where idSem=? and code=? and aDate=? and student_idStudent=? ");
		query.setParameter(0, idSem);
		query.setParameter(1, code);	
		query.setParameter(2, date);		
		query.setParameter(3, idStudent);		
	  
			bigResult2 = (BigInteger)query.uniqueResult();
		  int  a = bigResult2.intValue();
		if (a!=0)
		{
			SQLQuery q = currentSession().createSQLQuery("update attendance set status=? where idSem=? and code=? and aDate=? and student_idStudent=?");		
			q.setParameter(0, "P");
			q.setParameter(1, idSem);
			q.setParameter(2, code);	
			q.setParameter(3, date);		
			q.setParameter(4, idStudent);
			q.executeUpdate();
		}
		else
		{
			SQLQuery q = currentSession().createSQLQuery("insert into attendance (aDate,status,student_idStudent,idSem,code,idMonth,year_idYear,quarter) values(?,?,?,?,?,?,?,?)");		
			q.setParameter(0, date);
			q.setParameter(1, "P");
			q.setParameter(2, idStudent);
			q.setParameter(3, idSem);
			q.setParameter(4, code);
			q.setParameter(5, month);
			q.setParameter(6, idYear);
			q.setParameter(7, quarter);
			q.executeUpdate();
		}
		
	}

	
	
	@Override
	public void createAbsent(int idSem, int code, int month, String date, int idStudent) {
		Calendar cal = Calendar.getInstance();
		 int monthh=cal.get(cal.MONTH);
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 String quarter;
		 if(monthh<=5)
		 {quarter="q1";}
		 else
		 {quarter="q2";}
		final BigInteger bigResult2;
		SQLQuery query=currentSession().createSQLQuery("select count(*) from attendance where idSem=? and code=? and aDate=? and student_idStudent=? ");
		query.setParameter(0, idSem);
		query.setParameter(1, code);	
		query.setParameter(2, date);		
		query.setParameter(3, idStudent);		
			bigResult2 = (BigInteger)query.uniqueResult();
		  int  a = bigResult2.intValue();
		if (a!=0)
		{
			SQLQuery q = currentSession().createSQLQuery("update attendance set status=? where idSem=? and code=? and aDate=? and student_idStudent=?");		
			q.setParameter(0, "A");
			q.setParameter(1, idSem);
			q.setParameter(2, code);	
			q.setParameter(3, date);		
			q.setParameter(4, idStudent);
			q.executeUpdate();
		}
		else
		{
			SQLQuery q = currentSession().createSQLQuery("insert into attendance (aDate,status,student_idStudent,idSem,code,idMonth,year_idYear,quarter) values(?,?,?,?,?,?,?,?)");		
			q.setParameter(0, date);
			q.setParameter(1, "A");
			q.setParameter(2, idStudent);
			q.setParameter(3, idSem);
			q.setParameter(4, code);
			q.setParameter(5, month);
			q.setParameter(6, idYear);
			q.setParameter(7, quarter);
			q.executeUpdate();
		}
		
	}

	
	
	
	@Override
	public void delete(int idSem, int code, String date) {
		SQLQuery q = currentSession().createSQLQuery("delete from attendance where idSem=? and code=? and aDate=?");		
		q.setParameter(0, idSem);
		q.setParameter(1, code);
		q.setParameter(2, date);
		q.executeUpdate();

	}

	
	
	
	@Override
	public String checkStatus(int idSem, int code, String date) {
		SQLQuery q = currentSession().createSQLQuery("select count(*) from attendance where idSem=? and code=? and aDate=?");		
		q.setParameter(0, idSem);
q.setParameter(1, code);
q.setParameter(2,  date);
final BigInteger bigResult3;
String status;
bigResult3= (BigInteger)q.uniqueResult();
int a= bigResult3.intValue();
if(a!=0) {
	status="Taken";
	
}
else
{status="Not Taken";
}
		return status;
}
	
	
	
	@Override
	public int find(int year) {
		SQLQuery query=currentSession().createSQLQuery("select idYear from Year where yearName=?");
		query.setParameter(0, year);		
		int idYear= (int) query.uniqueResult();
		return idYear;
	}

	
	
	
	@Override
	public Year find(Year year) {
		Query query=currentSession().createQuery("from Year where yearName=?");
		query.setParameter(0, year.getYearName());		
		List<Year> sd=query.list(); 
		return sd.size() > 0 ? sd.get(0) : null;
	}


	@Override
	public List<Attendance> dailyStudentAttendance(int idStudent, int idSem, int code, int idYear) {
		SQLQuery query=currentSession().createSQLQuery(" SELECT aDate,status FROM attendance where idSem=? and student_idStudent=? and code=? and year_idYear=?");
		query.setParameter(0, idSem);
		query.setParameter(1, idStudent);
		query.setParameter(2, code);	
		query.setParameter(3, idYear);		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		return sd;
	}


	@Override
	public List<Attendance> monthlyStudentAttendance(int idStudent, int idSem, int code, int idMonth, int idYear) {
		SQLQuery query=currentSession().createSQLQuery(" select aDate,status from attendance where idSem=? and student_idStudent=? and code=? and idMonth=? and year_idYear=?");
		query.setParameter(0, idSem);
		query.setParameter(1, idStudent);
		query.setParameter(2, code);	
		query.setParameter(3, idMonth);
		query.setParameter(4, idYear);		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		return sd;
	}
	
	
	@Override
	public List<Attendance> dateWiseAttendance(int idSem, int code, String date,int idMonth) {
		SQLQuery query=currentSession().createSQLQuery("SELECT s.idStudent,u.password,s.studentName,a.status FROM attendance a inner join student s on a.student_idStudent=s.idStudent inner join app_user u on u.id=s.login_idLogin  where a.idSem=? and a.code=? and a.aDate=? and a.idMonth=?");
		query.setParameter(0, idSem);
		query.setParameter(1, code);	
		query.setParameter(2,date);	
		query.setParameter(3, idMonth);
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Attendance> sd=query.list(); 
		return sd;
	}

}

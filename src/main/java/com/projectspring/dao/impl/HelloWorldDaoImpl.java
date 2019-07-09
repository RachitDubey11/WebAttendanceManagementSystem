package com.projectspring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectspring.dao.HelloWorldDao;
import com.projectspring.model.Percent;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.User;
@Repository("helloWorldDao")
public class HelloWorldDaoImpl implements HelloWorldDao {

	  @Autowired
		SessionFactory sessionFactory;
	    protected Session currentSession() {
	    	return sessionFactory.getCurrentSession();
	    }
	
	
	@Override
	public int find(String user) {
		SQLQuery q = currentSession().createSQLQuery("SELECT t.idTeacher FROM teacher t	inner JOIN app_user a ON t.login_idLogin = a.id where a.userName=?");		
		q.setParameter(0, user);
		int a=(int) q.uniqueResult();
		return a;
	}


	@Override
	public Student find1(String user) {
		//SQLQuery q = currentSession().createSQLQuery("SELECT s.studentName,s.idSem FROM student s inner JOIN app_user a ON s.login_idLogin = a.id where a.userName=?");		
		//q.setParameter(0, user);		
		//Student sd=(Student) q.uniqueResult();
		//return sd;
		return (Student)currentSession().get(Student.class, user);

	}


	@Override
	public int findStudent(String user) {
		SQLQuery q = currentSession().createSQLQuery("SELECT s.idStudent FROM student s inner JOIN app_user a ON s.login_idLogin = a.id where a.userName=?");		
		q.setParameter(0, user);
		int a=(int) q.uniqueResult();	
	return a;
}


	@Override
	public boolean checkAttendanceTaken(int idSem, int code, String date) {
		SQLQuery q = currentSession().createSQLQuery("SELECT COUNT(*) from attendance WHERE aDate=? AND idSem =? and code=?");	
		q.setParameter(0, date);
		q.setParameter(1, idSem);
		q.setParameter(2, code);
		int a= (int) q.uniqueResult();
		if(a!=0) {
			return true;
		}
		return false;
	}


	@Override
	public List<Percent> find(int idSem, int idStudent) {
		SQLQuery query=currentSession().createSQLQuery(" SELECT s.code,s.subjectName,p.attend,p.total,p.percentage FROM percent p inner join subject s on p.code=s.code where p.idSem=? and p.student_idStudent=?");
		query.setParameter(0, idSem);
		query.setParameter(1, idStudent);		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Percent> sd=query.list(); 
		return sd;
	}


	@Override
	public User findUser(int id) {
		return (User)currentSession().get(User.class, id);

	}


	@Override
	public int findUser1(String user) {
		SQLQuery q = currentSession().createSQLQuery("SELECT id FROM app_user where userName=?");		
		q.setParameter(0, user);
		int a= (int) q.uniqueResult();
		return a;
	}


	@Override
	public void update(User user) {
		SQLQuery q = currentSession().createSQLQuery("UPDATE app_user SET userName=?,password=? WHERE id=?");			
		q.setParameter(0, user.getUserName());
		q.setParameter(1, user.getPassword());
		q.setParameter(2, user.getId());
		q.executeUpdate();
				
	}}

package com.projectspring.dao.impl;

import java.util.Iterator;
import java.util.List;


import javax.persistence.TypedQuery;

import com.projectspring.dao.StudentDao;
import com.projectspring.dao.TeacherDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


@Repository("studentDao")

public class StudentDaoImpl implements StudentDao {
@Autowired
Student student;
	  @Autowired
		SessionFactory sessionFactory;
	    protected Session currentSession() {
	    	return sessionFactory.getCurrentSession();
	    }
	
		@Override
		public List<Student> findAll() {
			Criteria cr = currentSession().createCriteria(Student.class);		
	    return cr.list();	
	}
		/*@Override
		public List<Student> find(Semdept semdept) {	
		Criteria cr = currentSession().createCriteria(Student.class);
		cr.add(Restrictions.eq("semName", student.getSemdept().getSemName()));
		cr.add(Restrictions.eq("dept", student.getSemdept().getDept()));
		List results = cr.list();
		return results;
				}
		*/
		@Override
		public void create(Student student) {	
			SQLQuery q = currentSession().createSQLQuery("insert into app_user_user_profile values(?,2)");		
			currentSession().save(student);
			q.setParameter(0, student.getUser().getId());
			q.executeUpdate();
			SQLQuery q1 = currentSession().createSQLQuery("insert into  values(?,2)");		

		}
		
		
		@Override
		public Semdept find(Semdept semdept) { 
			Query query=currentSession().createQuery("from Semdept as sd where sd.dept=? and sd.semName=?");
			query.setParameter(0, semdept.getDept());
			query.setParameter(1, semdept.getSemName());		
			List<Semdept> sd=query.list(); 
			return sd.size() > 0 ? sd.get(0) : null;
		}

		
		@Override
		public List<Student> find1(int idSem) {
			Query query=currentSession().createQuery("from Student where idSem=? ");
			query.setParameter(0, idSem);
			List<Student> sd=query.list(); 
			return sd;  
		}
/*
 * 
		@Override
		public List<Student> find(Semdept semdept) { 
			Query query=currentSession().createQuery("from Student as s where s.dept=" +student.getSemdept().getDept()+"and s.semname="+ student.getSemdept().getDept());
		//	query.setParameter(0, semdept.getDept());
		//	query.setParameter(1, semdept.getSemName());	
			List<Student> student=query.list(); 
			return student.size() > 0 ? student.get(0) : null;
		}*/

		@Override
		public void delete(int id) {
			//SQLQuery q = currentSession().createSQLQuery("delete s,l FROM student s inner join app_user l on s.login_idLogin = l.id where s.idStudent="+idStudent+"");			
			SQLQuery q = currentSession().createSQLQuery("delete FROM app_user_user_profile where USER_ID=?");
			q.setParameter(0, id);
				q.executeUpdate();
				  SQLQuery q1 = currentSession().createSQLQuery("delete FROM student where login_idLogin=?");	
					q1.setParameter(0, id);
					q1.executeUpdate();
					  SQLQuery q2 = currentSession().createSQLQuery("delete FROM app_user where id=?");	
						q2.setParameter(0, id);
						q2.executeUpdate();
	
		}
		

		@Override
		public void update(Student student) {
			SQLQuery q = currentSession().createSQLQuery("UPDATE student s INNER JOIN app_user l ON s.login_idLogin = l.id SET s.email=?,s.phoneNumber=?,s.studentName = ?,l.userName=?,l.password=? WHERE s.idStudent=?");			
			q.setParameter(0, student.getEmail());
			q.setParameter(1, student.getPhoneNumber());
			q.setParameter(2, student.getStudentName());
			q.setParameter(3, student.getUser().getUserName());
			q.setParameter(4, student.getUser().getPassword());
			q.setParameter(5, student.getIdStudent());
			q.executeUpdate();
			}

		
		@Override
		public Student edit(Integer idStudent) {
			return find(idStudent);
		}

		
		@Override
		public Student find(Integer idStudent) {
			return (Student)currentSession().get(Student.class, idStudent);
		}

		@Override
		public void updateIdSemPerSixMonth(int idStudent) {
			// TODO Auto-generated method stub
			SQLQuery q = currentSession().createSQLQuery("UPDATE student SET idSem=idSem+1 WHERE idStudent=?");			
			q.setParameter(0, idStudent);
			q.executeUpdate();

		}
}

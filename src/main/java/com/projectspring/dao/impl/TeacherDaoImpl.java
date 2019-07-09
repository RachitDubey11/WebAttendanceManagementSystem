package com.projectspring.dao.impl;

import java.util.Iterator;
import java.util.List;


import javax.persistence.TypedQuery;

import com.projectspring.dao.TeacherDao;
import com.projectspring.model.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


@Repository("teacherDao")

public class TeacherDaoImpl implements TeacherDao {

	  @Autowired
		SessionFactory sessionFactory;
	    protected Session currentSession() {
	    	return sessionFactory.getCurrentSession();
	    }
	
		@Override
		public List<Teacher> findAll() {
			Criteria cr = currentSession().createCriteria(Teacher.class);			// To get records having salary more than 2000
	//		cr.add(Restrictions.eq("type","t"));			
	    return cr.list();	

	}
		@Override
		public void create(Teacher teacher) {	
			SQLQuery q = currentSession().createSQLQuery("insert into app_user_user_profile values(?,3)");			
			currentSession().save(teacher);

			q.setParameter(0, teacher.getUser().getId());
			q.executeUpdate();
		}
		
		@Override
		public void update(Teacher teacher) {
			SQLQuery q = currentSession().createSQLQuery("UPDATE teacher t INNER JOIN app_user l ON t.login_idLogin = l.id SET t.email=?,t.phoneNumber=?,t.teacherName = ?,l.userName=?,l.password=? WHERE idTeacher=?");			
			q.setParameter(0, teacher.getEmail());
			q.setParameter(1, teacher.getPhoneNumber());
			q.setParameter(2, teacher.getTeacherName());
			q.setParameter(3, teacher.getUser().getUserName());
			q.setParameter(4, teacher.getUser().getPassword());
			q.setParameter(5, teacher.getIdTeacher());

			q.executeUpdate();
			}

		@Override
		public Teacher edit(Integer idTeacher) {
			return find(idTeacher);
		}

		@Override
		public void delete(int id) {
			//	SQLQuery q = currentSession().createSQLQuery("delete t,l FROM teacher t inner join app_user l on t.login_idLogin = l.id where t.idTeacher="+idTeacher+"");			
	  SQLQuery q = currentSession().createSQLQuery("delete FROM app_user_user_profile where USER_ID=?");
		q.setParameter(0, id);
			q.executeUpdate();
			  SQLQuery q1 = currentSession().createSQLQuery("delete FROM teacher where login_idLogin=?");	
				q1.setParameter(0, id);
				q1.executeUpdate();
				  SQLQuery q2 = currentSession().createSQLQuery("delete FROM app_user where id=?");	
					q2.setParameter(0, id);
					q2.executeUpdate();

		}

		@Override
		public Teacher find(Integer idTeacher) {
			return (Teacher)currentSession().get(Teacher.class, idTeacher);
		}
}

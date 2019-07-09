package com.projectspring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectspring.dao.TeacherSemdeptSubjectDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Subject;
import com.projectspring.model.Teacher;
import com.projectspring.model.TeacherSemdeptSubject;

@Repository("teachersemdeptsubjectDao")
public class TeacherSemdeptSubjectDaoImpl implements TeacherSemdeptSubjectDao{

	@Autowired
	SessionFactory sessionFactory;
    protected Session currentSession() {
    	return sessionFactory.getCurrentSession();
    }
	
	
	@Override
	public void create(TeacherSemdeptSubject teachersemdeptsubject) {
		currentSession().save(teachersemdeptsubject);
		
	}


	@Override
	public List<TeacherSemdeptSubject> find(Integer idTeacher) {
		SQLQuery query=currentSession().createSQLQuery("SELECT * FROM teacher t\r\n" + 
				"JOIN teachersemdeptsubject tss ON t.idTeacher = tss.teacher_idTeacher\r\n" + 
				"JOIN subject s ON s.code = tss.subject_code\r\n" + 
				"JOIN semdept sd ON sd.idSem = tss.semdept_idSem where idTeacher=?;");
		query.setParameter(0, idTeacher);		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<TeacherSemdeptSubject> sd=query.list(); 
		return sd;
	}


	@Override
	public Subject find(String subjectName) {
		//SQLQuery query=currentSession().createSQLQuery("select code from subject where subjectName=?");
	    return (Subject)currentSession().get(Subject.class, subjectName);
	}


	@Override
	public void create(int idSem, Integer idTeacher, int code,int idYear) {
		SQLQuery query=currentSession().createSQLQuery("insert into teachersemdeptsubject (semdept_idSem,teacher_idTeacher,subject_code,year_idYear) values (?,?,?,?)");
		query.setParameter(0, idSem);
		query.setParameter(1, idTeacher);		
		query.setParameter(2, code);
		query.setParameter(3, idYear);

		query.executeUpdate();
	}

	
	@Override
	public void delete(int id) {
		SQLQuery q = currentSession().createSQLQuery("delete FROM teachersemdeptsubject where id="+id+"");			
		q.executeUpdate();
	}

	

}

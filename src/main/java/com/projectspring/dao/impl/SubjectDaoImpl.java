package com.projectspring.dao.impl;

import java.util.List;import java.math.BigInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectspring.dao.SubjectDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	SessionFactory sessionFactory;
    protected Session currentSession() {
    	return sessionFactory.getCurrentSession();
    }
	
    @Override
	public void create(String subjectName,int idSem) {	
		SQLQuery query=currentSession().createSQLQuery("INSERT INTO subject (subjectName) VALUES (?);\r\n");
		query.setParameter(0, subjectName);		
		query.executeUpdate();
		int lastId = ((BigInteger) currentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
		SQLQuery query1=currentSession().createSQLQuery("INSERT INTO semdept_subject (idSem,code) VALUES(?,?);\r\n");
		query1.setParameter(0, idSem);
		query1.setParameter(1,lastId );
		query1.executeUpdate();
    }
	
    
	@Override
	public List<Subject> findAll() {
		Criteria cr = currentSession().createCriteria(Subject.class);
		return cr.list();
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
	public List<Subject> find1(int idSem) {
		SQLQuery query=currentSession().createSQLQuery("SELECT s.code,sd.semName,sd.dept, s.subjectName FROM subject as s INNER JOIN semdept_subject as smd ON s.code = smd.code INNER JOIN semdept as sd ON smd.idSem= sd.idSem WHERE sd.idSem =? ");
		query.setParameter(0, idSem);
		
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Subject> sd=query.list();
		return sd;
     
	}

	@Override
	public Subject find(Subject subject) {
		Query query=currentSession().createQuery("from Subject as s where s.subjectName=?");
		query.setParameter(0, subject.getSubjectName());	
		List<Subject> sd=query.list(); 
		return sd.size() > 0 ? sd.get(0) : null;
	}

	@Override
	public void delete(int code) {
		SQLQuery q = currentSession().createSQLQuery("delete FROM semdept_subject where code="+code+"");			
		q.executeUpdate();			
		SQLQuery q1 = currentSession().createSQLQuery("delete FROM subject where code="+code+"");			
		q1.executeUpdate();			

	}

	@Override
	public void update(Subject subject) {
		SQLQuery q = currentSession().createSQLQuery("UPDATE subject s SET s.subjectName = ? WHERE s.code=?");			
		q.setParameter(0, subject.getSubjectName());
		q.setParameter(1, subject.getCode());
		q.executeUpdate();// TODO Auto-generated method stub
		
	}

	@Override
	public Subject edit(int code) {
		// TODO Auto-generated method stub
		return find2(code);
	}

	@Override
	public Subject find2(int code) {
		// TODO Auto-generated method stub
		return (Subject)currentSession().get(Subject.class, code);
	}

	@Override
	public List<Subject> find3(int idSem) {
		SQLQuery query=currentSession().createSQLQuery("SELECT s.subjectName,s.code FROM subject as s INNER JOIN semdept_subject as smd ON s.code = smd.code INNER JOIN semdept as sd ON smd.idSem= sd.idSem WHERE sd.idSem =? ");
		query.setParameter(0, idSem);
	     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Subject> sd=query.list();
		return sd;
	}

	@Override
	public String fetchSubjectNameFromCode(int code) {
		SQLQuery query=currentSession().createSQLQuery("SELECT subjectName from subject where code=? ");
		query.setParameter(0, code);
		String subjectName=(String) query.uniqueResult();
		return subjectName;
	}

}

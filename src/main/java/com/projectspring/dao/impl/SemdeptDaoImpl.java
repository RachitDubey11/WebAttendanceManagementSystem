package com.projectspring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectspring.dao.SemdeptDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;

@Repository("semdeptDao")
public class SemdeptDaoImpl implements SemdeptDao {

	
	@Autowired
	SessionFactory sessionFactory;
    protected Session currentSession() {
    	return sessionFactory.getCurrentSession();
    }
    
	@Override
	public List<Semdept> findAll() {
		Criteria cr = currentSession().createCriteria(Semdept.class);		
    return cr.list();	
	}
	
	@Override
	public void create(Semdept semdept) {	
		currentSession().save(semdept);
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

	@Override
	public Semdept findName(int idSem) {
		return (Semdept)currentSession().get(Semdept.class, idSem);
	}

	@Override
	public int find(String semName, String dept) {
		SQLQuery query=currentSession().createSQLQuery("select idSem from Semdept where dept=? and semName=?");
		query.setParameter(0, dept);
		query.setParameter(1, semName);		
		int idSem= (int) query.uniqueResult();
		return idSem;
	}

}

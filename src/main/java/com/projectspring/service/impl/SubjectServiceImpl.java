package com.projectspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectspring.dao.SubjectDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Subject;
import com.projectspring.model.Teacher;
import com.projectspring.service.SubjectService;

@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public List<Subject> findAll() {
		// TODO Auto-generated method stub
		return subjectDao.findAll();
	}
	
	@Override
	public Semdept find(Semdept semdept) {
		// TODO Auto-generated method stub
		return subjectDao.find(semdept);
	}

	@Override
	public List<Subject> find1(int idSem) {
		// TODO Auto-generated method stub
		return subjectDao.find1(idSem); 
	}
	

	@Override
	public void create(String subjectName,int idSem) {
		subjectDao.create(subjectName,idSem);
		
	}

	@Override
	public Subject find(Subject subject) {
		// TODO Auto-generated method stub
		return subjectDao.find(subject);
	}

	@Override
	public void delete(int code) {
		  subjectDao.delete(code);
		
	}

	@Override
	public void update(Subject subject) {
	  subjectDao.update(subject);
		
	}

	@Override
	public Subject edit(int code) {
		// TODO Auto-generated method stub
		return subjectDao.edit(code);
	}

	@Override
	public Subject find2(int code) {
		// TODO Auto-generated method stub
		return subjectDao.find2(code);
	}

	@Override
	public List<Subject> find3(int idSem) {
		// TODO Auto-generated method stub
		return subjectDao.find3(idSem);
	}

	@Override
	public String fetchSubjectNameFromCode(int code) {
		// TODO Auto-generated method stub
		return subjectDao.fetchSubjectNameFromCode(code);
	}
	

}

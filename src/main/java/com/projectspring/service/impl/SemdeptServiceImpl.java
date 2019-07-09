package com.projectspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectspring.dao.SemdeptDao;
import com.projectspring.dao.TeacherDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;
import com.projectspring.service.SemdeptService;

@Service("semdeptService")
@Transactional
public class SemdeptServiceImpl implements SemdeptService {
	@Autowired
	SemdeptDao semdeptDao;
	
	@Override
	public List<Semdept> findAll() {
		// TODO Auto-generated method stub
		return semdeptDao.findAll();
	}

	@Override
	public void create(Semdept semdept) {
		semdeptDao.create(semdept);
		
	}
	@Override
	public Semdept find(Semdept semdept) {
		// TODO Auto-generated method stub
		return semdeptDao.find(semdept);
	}

	@Override
	public int find(String semName, String dept) {
		// TODO Auto-generated method stub
		return semdeptDao.find(semName, dept);
	}

	@Override
	public List<Student> find1(int idSem) {
		// TODO Auto-generated method stub
		return semdeptDao.find1(idSem);
	}

	@Override
	public Semdept findName(int idSem) {
		// TODO Auto-generated method stub
		return semdeptDao.findName(idSem);
	}
}

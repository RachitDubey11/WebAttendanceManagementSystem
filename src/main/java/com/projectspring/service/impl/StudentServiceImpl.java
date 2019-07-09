package com.projectspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectspring.dao.StudentDao;
import com.projectspring.dao.TeacherDao;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;
import com.projectspring.service.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}
	
	
	@Override
	public void create(Student student) {
		studentDao.create(student);
		
	}
	
	@Override
	public List<Student> find1(int idSem) {
		// TODO Auto-generated method stub
		return studentDao.find1(idSem);
	}
	
	
	@Override
	public Semdept find(Semdept semdept) {
		// TODO Auto-generated method stub
		return studentDao.find(semdept);
	}


	@Override
	public void delete(Integer idStudent) {
		studentDao.delete(idStudent);		
	}


	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}


	@Override
	public Student edit(Integer idStudent) {
		// TODO Auto-generated method stub
		return studentDao.edit(idStudent);
	}


	@Override
	public Student find(Integer idStudent) {
		// TODO Auto-generated method stub
		return studentDao.find(idStudent);
	}


	@Override
	public void updateIdSemPerSixMonth(int idStudent) {
		// TODO Auto-generated method stub
		studentDao.updateIdSemPerSixMonth(idStudent);
	
	}
}

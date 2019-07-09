package com.projectspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectspring.dao.TeacherDao;
import com.projectspring.dao.TeacherSemdeptSubjectDao;
import com.projectspring.model.Subject;
import com.projectspring.model.Teacher;
import com.projectspring.model.TeacherSemdeptSubject;
import com.projectspring.service.TeacherSemdeptSubjectService;

@Service("teachersemdeptsubjectService")
@Transactional
public class TeacherSemdeptSubjectServiceImpl implements TeacherSemdeptSubjectService {

	@Autowired
	TeacherSemdeptSubjectDao teachersemdeptsubjectDao;

	
	@Override
	public void create(TeacherSemdeptSubject teachersemdeptsubject) {
		teachersemdeptsubjectDao.create(teachersemdeptsubject);
		
	}

	@Override
	public List<TeacherSemdeptSubject> find(Integer idTeacher) {
		// TODO Auto-generated method stub
		return  teachersemdeptsubjectDao.find(idTeacher);
	}

	@Override
	public Subject find(String subjectName) {
		// TODO Auto-generated method stub
		return teachersemdeptsubjectDao.find(subjectName);
	}

	@Override
	public void create(int idSem, Integer idTeacher, int code,int idYear) {
		// TODO Auto-generated method stub
		teachersemdeptsubjectDao.create(idSem,idTeacher,code,idYear);

		
	}

	@Override
	public void delete(int id) {
		teachersemdeptsubjectDao.delete(id);		
	}
}

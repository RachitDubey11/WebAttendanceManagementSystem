package com.projectspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projectspring.dao.TeacherDao;
import com.projectspring.model.Teacher;
import com.projectspring.service.TeacherService;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherDao teacherDao;
	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherDao.findAll();
	}
	
	@Override
	public void create(Teacher teacher) {
		teacherDao.create(teacher);
		
	}
	

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);
		
	}

	@Override
	public Teacher edit(Integer idTeacher) {
		// TODO Auto-generated method stub
		return teacherDao.edit(idTeacher);
	}

	@Override
	public void delete(int id) {
		teacherDao.delete(id);
		
	}

	@Override
	public Teacher find(int id) {
		// TODO Auto-generated method stub
		return teacherDao.find(id);
	}


}

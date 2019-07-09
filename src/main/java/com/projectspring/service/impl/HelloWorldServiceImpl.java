package com.projectspring.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectspring.dao.HelloWorldDao;
import com.projectspring.dao.StudentDao;
import com.projectspring.model.Percent;
import com.projectspring.model.Student;
import com.projectspring.model.User;
import com.projectspring.service.HelloWorldService;

@Service("helloWorldService")
@Transactional
public class HelloWorldServiceImpl implements HelloWorldService {

	@Autowired
	HelloWorldDao helloWorldDao;
	
	@Override
	public int find(String user) {
		// TODO Auto-generated method stub
		return helloWorldDao.find(user);
	}

	@Override
	public Student find1(String user) {
		// TODO Auto-generated method stub
		return helloWorldDao.find1(user);
	}

	@Override
	public int findStudent(String user) {
		// TODO Auto-generated method stub
		return helloWorldDao.findStudent(user);
	}

	@Override
	public boolean checkAttendanceTaken(int idSem, int code, String date) {
		// TODO Auto-generated method stub
		return helloWorldDao.checkAttendanceTaken(idSem,code,date);
	}

	@Override
	public List<Percent> find(int idSem, int idStudent) {
		// TODO Auto-generated method stub
		return helloWorldDao.find(idSem, idStudent);
	}

	@Override
	public User findUser(int id) {
		// TODO Auto-generated method stub
		return helloWorldDao.findUser(id);
	}

	@Override
	public int findUser1(String user) {
		// TODO Auto-generated method stub
		return helloWorldDao.findUser1(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		helloWorldDao.update(user);
	}

}

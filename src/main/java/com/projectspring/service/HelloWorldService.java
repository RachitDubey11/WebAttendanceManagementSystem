package com.projectspring.service;

import java.util.List;

import com.projectspring.model.Percent;
import com.projectspring.model.Student;
import com.projectspring.model.User;

public interface HelloWorldService {
	public int find(String user);
	public Student find1(String user);
	public int findStudent(String user);
	public boolean checkAttendanceTaken(int idSem,int code,String date);
	public List<Percent> find(int idSem,int idStudent);
    public User findUser(int id);
    public int findUser1(String user);
	public void update(User user);

}

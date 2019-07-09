package com.projectspring.service;

import java.util.List;

import com.projectspring.model.Teacher;

public interface TeacherService {
	public List<Teacher> findAll();
	public void create(Teacher teacher);
	public void update(Teacher teacher);
	public Teacher edit(Integer idTeacher);
	public void delete(int id);
	public Teacher find(int id);

}

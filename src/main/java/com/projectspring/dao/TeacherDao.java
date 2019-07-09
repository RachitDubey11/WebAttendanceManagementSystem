package com.projectspring.dao;

import java.util.List;

import com.projectspring.model.Teacher;

public interface TeacherDao {
	public List<Teacher> findAll();
	public void create(Teacher teacher);
	public void update(Teacher teacher);
	public Teacher edit(Integer idTeacher);
	public void delete(int id);
	public Teacher find(Integer idTeacher);

}

package com.projectspring.dao;

import java.util.List;

import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;

public interface StudentDao {
	public List<Student> findAll();
	public void create(Student student);
	public Semdept find(Semdept semdept);
	public List<Student> find1(int idSem);
	public void delete(int id);
	public void update(Student student);
	public Student edit(Integer idStudent);
	public Student find(Integer idStudent);
	
	public void updateIdSemPerSixMonth(int idStudent);

}

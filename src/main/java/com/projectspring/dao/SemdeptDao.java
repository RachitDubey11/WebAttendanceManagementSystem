package com.projectspring.dao;

import java.util.List;

import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;

public interface SemdeptDao {
public List<Semdept> findAll();
public void create(Semdept semdept);
public Semdept find(Semdept semdept);
public List<Student> find1(int idSem);
public Semdept findName(int idSem);
public int find(String semName,String dept);

}

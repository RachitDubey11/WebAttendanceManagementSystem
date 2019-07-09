package com.projectspring.service;

import java.util.List;

import com.projectspring.model.Semdept;
import com.projectspring.model.Subject;

public interface SubjectService {
	public List<Subject> findAll();
	public Semdept find(Semdept semdept);
	public List<Subject> find1(int idSem);
	public void create(String subjectName,int idSem);
	public Subject find(Subject subject);
	public void delete(int code);
	public void update(Subject subject);
	public List<Subject> find3(int idSem);

	public Subject edit(int code);
	public Subject find2(int code);
	
	public String fetchSubjectNameFromCode(int code);

}

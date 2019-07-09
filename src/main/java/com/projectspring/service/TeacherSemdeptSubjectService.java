package com.projectspring.service;

import java.util.List;

import com.projectspring.model.Subject;
import com.projectspring.model.Teacher;
import com.projectspring.model.TeacherSemdeptSubject;

public interface TeacherSemdeptSubjectService {
	public void create(TeacherSemdeptSubject teachersemdeptsubject);
	public List<TeacherSemdeptSubject> find(Integer idTeacher);
    public Subject find(String subjectName); 
	public void create(int idSem, Integer idTeacher, int code,int idYear);
	public void delete(int id);

}

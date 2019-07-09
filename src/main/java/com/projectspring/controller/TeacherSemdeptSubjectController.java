package com.projectspring.controller;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectspring.model.Semdept;
import com.projectspring.model.Subject;
import com.projectspring.model.Teacher;
import com.projectspring.model.TeacherSemdeptSubject;
import com.projectspring.service.AttendanceService;
import com.projectspring.service.SemdeptService;
import com.projectspring.service.StudentService;
import com.projectspring.service.SubjectService;
import com.projectspring.service.TeacherSemdeptSubjectService;
import com.projectspring.service.TeacherService;

@Controller
@RequestMapping(value="/teachersemdeptsubject")
public class TeacherSemdeptSubjectController {

	@Autowired
	TeacherSemdeptSubjectService teachersemdeptsubjectService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	SemdeptService semdeptService;
	@Autowired
	AttendanceService attendanceService;
	
	
	@RequestMapping(value="/register/{idTeacher}", method=RequestMethod.GET)
	public String register(@ModelAttribute("semdept") Semdept semdept,@PathVariable("idTeacher") Integer idTeacher,Map<String, Object> map){
		map.put("teachersemdeptsubject",new TeacherSemdeptSubject());
		map.put("semdept",new Semdept());	
		map.put("idTeacher",idTeacher);
		return "/semdeptSearch";
		}
		
		
		@RequestMapping(value="/create/{idSem}/{idTeacher}", method=RequestMethod.POST)
		public String create(@Valid @PathVariable("idSem") int idSem,@PathVariable("idTeacher") Integer idTeacher,@ModelAttribute("subject") Subject subject,BindingResult bindingResult){
			if(bindingResult.hasErrors()) {
				return "/failure";
			}
		    Calendar cal = Calendar.getInstance();
			int year=cal.get(cal.YEAR);
			int idYear=attendanceService.find(year);
			String ss=subject.getSubjectName();
			int sss=Integer.parseInt(ss);
		    teachersemdeptsubjectService.create(idSem,idTeacher,sss,idYear);
			return "redirect:/teachersemdeptsubject/teachersemdeptsubjectList/{idTeacher}";
		}
		

		@RequestMapping(value="/teachersemdeptsubjectList/{idTeacher}", method=RequestMethod.GET)
		public String teachersemdeptsubjectList(@PathVariable("idTeacher") Integer idTeacher, Map<String, Object> map){
			map.put("teachersemdeptsubjectList",teachersemdeptsubjectService.find(idTeacher));
			Teacher teacher=teacherService.find(idTeacher);
			map.put("teacher",teacher.getTeacherName());
			return "/viewDetailsTeacher";
	    }

		
		 @ModelAttribute()
		 public void headerMessage(Model model) {
			 TreeSet<String> departmentList=new TreeSet<>();
			 List<Semdept> sd=semdeptService.findAll();
			 for (int i = 0; i < sd.size(); i++) {
				Semdept sm = sd.get(i);				
			departmentList.add(sm.getDept());
			TreeSet<String> semesterList=new TreeSet<>();
			 for (int j = 0; j < sd.size(); j++) {
				 Semdept sk = sd.get(j);	
			semesterList.add(sk.getSemName());
			 }
			model.addAttribute("departmentList",departmentList);
			model.addAttribute("semesterList",semesterList);
		 }}
	
		 
	
		 @RequestMapping(value="/find/{idTeacher}", method=RequestMethod.POST)
	     public ModelAndView find(@Valid @ModelAttribute("semdept") Semdept semdept,@PathVariable("idTeacher") Integer idTeacher,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
					return new ModelAndView("failure");
				}
		 ModelAndView mav = new ModelAndView("addViewDetailsTeacher");
	     Semdept sdd = studentService.find(semdept);	 		
	     mav.addObject("idSem", sdd.getIdSem());
	     int idSem=sdd.getIdSem();
		 List<Subject> subjectList=new ArrayList<>();
	     List<Subject> sd=subjectService.find3(idSem);
		 /*for (int i = 0; i < sd.size(); i++) {
			Subject sm = sd.get(i);				
			subjectList.add(sm);
			}*/
		 mav.addObject("subjectList",sd);
		
	     mav.addObject("idTeacher", idTeacher);
	     mav.addObject("subject", new Subject());
			mav.addObject("teachersemdeptsubject",new TeacherSemdeptSubject());
				    return mav;
		 }
		 
		 
		 @RequestMapping(value="/delete/{id}/{idTeacher}", method=RequestMethod.GET)
			public String delete(@PathVariable("id") int id, Map<String, Object> map){
				teachersemdeptsubjectService.delete(id);
				return "redirect:/teachersemdeptsubject/teachersemdeptsubjectList/{idTeacher}";
			}
		 
		 
	/*	 @ModelAttribute()
		 public void headerMessage1(@RequestParam(value = "semName", required = false)String semName,@RequestParam(value = "dept", required = false)String dept,Model model) {
		//	 Semdept semdept = null;
			 TreeSet<String> subjectList=new TreeSet<>();
			 System.out.println("SemName:"+semdept.getSemName());
			 System.out.println("Dept:"+semdept.getDept());

			 int idSem=semdeptService.find(semName, dept);
			 List<Subject> sd=subjectService.find1(idSem);
			 for (int i = 0; i < sd.size(); i++) {
				Subject sm = sd.get(i);				
				subjectList.add(sm.getSubjectName());}			 
			model.addAttribute("subjectList",subjectList);
		 }
		 */
	}	


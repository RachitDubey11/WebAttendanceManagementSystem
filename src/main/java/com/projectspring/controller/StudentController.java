package com.projectspring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
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
import org.springframework.web.servlet.ModelAndView;

import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;
import com.projectspring.service.AttendanceService;
import com.projectspring.service.SemdeptService;
import com.projectspring.service.StudentService;

@Controller
@RequestMapping(value="/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	SemdeptService semdeptService;
	@Autowired
	AttendanceService attendanceService;
	
	
	@RequestMapping(value="/register/{idSem}", method=RequestMethod.GET)
	public String register(@PathVariable("idSem") int idSem,Map<String, Object> map){
		map.put("student",new Student());
		map.put("st",idSem);
	    Calendar cal = Calendar.getInstance();
		int year=cal.get(cal.YEAR);
		System.out.println(year);
        int idYear=attendanceService.find(year);
		map.put("idYear",idYear);
		map.put("st",idSem);

		return "/addStudent";
	}
	

	@RequestMapping(value="/studentsList", method=RequestMethod.GET)
	public String studentsList( Map<String, Object> map){
		map.put("studentsList",studentService.findAll());
		return "/studentDetails";
	}
	
	
	
	@RequestMapping(value="/create/{idSem}", method=RequestMethod.POST)
	public String create(@Valid @PathVariable("idSem") int idSem, @ModelAttribute("student") Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "/addStudent";
		}
		studentService.create(student);
		return "redirect:/students/redirectStudentsList/"+idSem;
	}
	 

	@ModelAttribute()
	 public void headerMessage(Model model) {
		try {
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
	 }
		 }
		catch(NullPointerException e) {
			
		}
	} 
	 
	 @RequestMapping(value="/find", method=RequestMethod.GET)
		public String find(Map<String, Object> map){
			map.put("semdept",new Semdept());
			return "/studentSearch";
		}
	 
	 
	
	 @RequestMapping(value="/listStudents", method=RequestMethod.POST)
     public ModelAndView find(@Valid @ModelAttribute("semdept") Semdept semdept,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
				return new ModelAndView("addStudent");
			}
	 ModelAndView mav = new ModelAndView("studentDetails");
     Semdept sdd = studentService.find(semdept);
	 if (null != sdd) {		 		
     mav.addObject("idSem", sdd.getIdSem());
     int ab=sdd.getIdSem(); 
     mav.addObject("studentValue", studentService.find1(ab));
      } else {
              mav = new ModelAndView("failure");
			    mav.addObject("message", "No details found");
		}
			    return mav;
  }
	 
	 
	 @RequestMapping(value="/edit/{idStudent}/{idSem}", method=RequestMethod.GET)
		public String edit(@PathVariable("idSem") int idSem,@PathVariable("idStudent") Integer idStudent, Map<String, Object> map){
			Student student=studentService.find(idStudent);
			map.put("idSem",idSem);
			map.put("student",student);
			return "/editStudent";
		}
	 
	 
	 @RequestMapping(value="/update/{idSem}", method=RequestMethod.POST)
		public String update(@Valid @PathVariable("idSem") int idSem,Student student,BindingResult bindingResult){
		 if(bindingResult.hasErrors()) {
				return "/editStudent";
			}
			studentService.update(student);
			return "redirect:/students/redirectStudentsList/"+idSem;
		}
	 
	 
	 @RequestMapping(value="/delete/{id}/{idSem}", method=RequestMethod.GET)
		public String delete(@PathVariable("idSem") int idSem,@PathVariable("id") int id,@ModelAttribute("semdept") Semdept semdept, Map<String, Object> map){
		 studentService.delete(id);
			return "redirect:/students/redirectStudentsList/"+idSem;
		}
	 
	 
	 @RequestMapping(value="/redirectStudentsList/{idSem}", method=RequestMethod.GET)
     public ModelAndView redirectMethod(@PathVariable("idSem") int idSem) {
	 ModelAndView mav = new ModelAndView("studentDetails");
     mav.addObject("studentValue", studentService.find1(idSem));
			    return mav;
  }
	 
	 
	 
	 
		@RequestMapping(value="/upgradeIdSemOfStudent", method=RequestMethod.GET)
		public String upgradeIdSemOfStudent(){
			return "/upgradeIdSemOfStudent";
		}
		
		
		
		@RequestMapping(value="/finallyUpgradeIdSemOfStudent", method=RequestMethod.GET)
		public String finallyUpgradeIdSemOfStudent() {
		  //  Calendar cal = Calendar.getInstance();
			//int month=cal.get(cal.MONTH);
			int i;
		    List<Student> students=studentService.findAll();
		       for(i=0;i<students.size();i++){
				   Student student=students.get(i);
				   int idStudent=student.getIdStudent();
				   studentService.updateIdSemPerSixMonth(idStudent);
			   }
			return "/upgradeIdSemOfStudent";
		}
	 

}

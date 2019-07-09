package com.projectspring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectspring.model.Month;
import com.projectspring.model.Student;
import com.projectspring.service.AttendanceService;
import com.projectspring.service.StudentService;
import com.projectspring.service.SubjectService;

@Controller
@RequestMapping(value="/studentAttendance")
public class StudentAttendanceController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private SubjectService subjectService;
	
	 @RequestMapping(value="/viewAttendanceStudent/{idSem}/{idStudent}/{code}", method=RequestMethod.GET)
		public String viewAttendanceStudent(@PathVariable("idSem") int idSem,@PathVariable("idStudent") int idStudent,@PathVariable("code") int code,Map<String, Object> map){	
			map.put("viewAttendanceStudentList",attendanceService.find(idSem,idStudent,code));
			map.put("idSem",idSem);			
			map.put("idStudent",idStudent);			
			map.put("code",code);
			Student sd=studentService.find(idStudent);
			String rollNo=sd.getUser().getPassword();
			String studentName=sd.getStudentName();
			map.put("rollNo",rollNo);
			map.put("studentName",studentName);
			map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));			
			return "/ViewAttendanceStudentPanel";}
	 
	 
	 @RequestMapping(value="/viewMonthly/{idSem}/{idStudent}/{code}", method=RequestMethod.POST)
	 public String viewMonthly(@ModelAttribute("month") Month month,@PathVariable("idSem") int idSem,@PathVariable("idStudent") int idStudent,@PathVariable("code") int code,Map<String, Object> map){
	 		 Month sdd = attendanceService.find(month);	
	 	     int ab=sdd.getIdMonth(); 
	 		 System.out.println("IdMonth:"+ab);
	 	System.out.println("IdMonth:"+month.getMonthName());
	 			map.put("viewAttendanceStudentList",attendanceService.find(idSem,idStudent,code,ab));
	 			Student sd=studentService.find(idStudent);
				String rollNo=sd.getUser().getPassword();
				String studentName=sd.getStudentName();
				map.put("rollNo",rollNo);
				map.put("studentName",studentName);
				map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));			
	 			return "/ViewAttendanceStudentPanel";
	 		}
	 
	 
	 
	 @ModelAttribute()
	 public void headerMessage(Model model) {
		 List<String> monthList=new ArrayList<>();
		 List<Month> sd=attendanceService.findAll();
		 int a=Calendar.getInstance().get(Calendar.MONTH);
		 if(a<5) {
			 if(a==0)
			 {
					Month sm = sd.get(0);	
					monthList.add(sm.getMonthName());
			 }
			 else
		 {for (int i = 0; i <=a ; i++) {
			Month sm = sd.get(i);				
		monthList.add(sm.getMonthName());
		    }
		}}
		 else if(a>5 && a<12) {
			 int k;
			 if(a==6) {
				k=a;
			}
			 else
			 {}
			 for (int i = 6; i <=a ; i++) {
					Month sm = sd.get(i);
					monthList.add(sm.getMonthName());

			 }
		 }
		 
		model.addAttribute("monthList",monthList);
		model.addAttribute("month",new Month());
	 }
}

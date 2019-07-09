package com.projectspring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.time.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectspring.model.Attendance;
import com.projectspring.model.Month;
import com.projectspring.model.Percent;
import com.projectspring.model.Year;
import com.projectspring.model.Semdept;
import com.projectspring.model.Student;
import com.projectspring.model.Subject;
import com.projectspring.model.TeacherSemdeptSubject;
import com.projectspring.service.AttendanceService;
import com.projectspring.service.SemdeptService;
import com.projectspring.service.StudentService;
import com.projectspring.service.SubjectService;


@Controller
@RequestMapping(value="/attendance")
public class AttendanceController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SemdeptService semdeptService;
	

	 @RequestMapping(value="/find/{semdept_idSem}/{subject_code}", method=RequestMethod.GET)
		public String register(@PathVariable("semdept_idSem") int semdept_idSem,@PathVariable("subject_code") int subject_code,@ModelAttribute("attendance") Attendance attendance,Map<String, Object> map){
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		Calendar cal = Calendar.getInstance();
		map.put("month",new SimpleDateFormat("M").format(cal.getTime()));
		map.put("attendance",new Attendance());
		map.put("date",dateFormat.format(date));
		System.out.println("date:"+dateFormat.format(date));
       TreeSet<String> subjectList=new TreeSet<>();
       List<Attendance> presentStudent=attendanceService.checkAttendanceTaken(semdept_idSem,subject_code,dateFormat.format(date));
       if(presentStudent!=null) {
       List<Attendance> absentStudent=attendanceService.checkAttendanceTakenAbsent(semdept_idSem,subject_code,dateFormat.format(date));
       map.put("presentStudent", presentStudent);
       map.put("absentStudent", absentStudent);}
       else {
		 TreeSet<String> studentsList=new TreeSet<>();
		 List<Student> sd=studentService.find1(semdept_idSem);
		map.put("sd",sd);
		for (int i = 0; i < sd.size(); i++) {
			Student sm = sd.get(i);		
			studentsList.add(sm.getStudentName());
			map.put("students", studentsList);}
}
			map.put("idSem",semdept_idSem);
			map.put("code",subject_code);
			
			return "/takeAttendance";
		}
	 
	 
	 
	 @RequestMapping(value="/create", method=RequestMethod.POST)
		public String create(@Valid @ModelAttribute("attendance") Attendance attendance,BindingResult bindingResult){
			if(bindingResult.hasErrors()) {
				return "/failure";
			}
			return "redirect:/teacher";
		}
	 
	 
	 
	 @RequestMapping(value = "/editCustomer" , method=RequestMethod.POST)
	 public String editCustomer(@ModelAttribute("attendance") Attendance attendance,@RequestParam(value = "idStudent", required = false) int[] idStudent) 
	 {
	    for (int k = 0; k <idStudent.length -1; k++)
        {
            for (int l = k+1; l < idStudent.length; l++)
            {
                if ((idStudent[k] == idStudent[l]) && (k!= l))
                {
                	System.out.println("Present student IdStudent:"+idStudent[l]);
           	     System.out.println("date:"+attendance.getaDate());
           	     System.out.println("IdSem:"+attendance.getSemdept().getIdSem());
           	     System.out.println("Code:"+attendance.getSubject().getCode());
           	     System.out.println("IdMonth:"+attendance.getMonth().getIdMonth());
     			attendanceService.create(attendance,idStudent[l]);
     			 Calendar cal = Calendar.getInstance();
     			int year=cal.get(cal.YEAR);
     	        int idYear=attendanceService.find(year);
     			attendanceService.checkInPercentStatusOfPresent(attendance.getSemdept().getIdSem(),attendance.getSubject().getCode(),idStudent[l],idYear);
                }	
            }   
    }
	 Arrays.sort(idStudent);
	    System.out.println(Arrays.toString(idStudent));
	    for (int j = 0; j < idStudent.length; j++) {
	        if(j==0) {
	            if(idStudent[j]!=idStudent[j+1]) {
	            	System.out.println("Not Present Student IdStudent:"+idStudent[j]);
	   		     System.out.println("Not date:"+attendance.getaDate());
	   		     System.out.println("Not IdSem:"+attendance.getSemdept().getIdSem());
	   		     System.out.println("Not Code:"+attendance.getSubject().getCode());	
           	     System.out.println("Not IdMonth:"+attendance.getMonth().getIdMonth());
     			attendanceService.createAbsent(attendance,idStudent[j]);
     			 Calendar cal = Calendar.getInstance();
     			int year=cal.get(cal.YEAR);
     	        int idYear=attendanceService.find(year);
     			attendanceService.checkInPercentStatusOfAbsent(attendance.getSemdept().getIdSem(),attendance.getSubject().getCode(),idStudent[j],idYear);
}
	        }else
	        if(j==idStudent.length-1) {
	            if(idStudent[j]!=idStudent[j-1]) {
	            	System.out.println("Not Present Student IdStudent:"+idStudent[j]);
	   		     System.out.println("Not date:"+attendance.getaDate());
	   		     System.out.println("Not IdSem:"+attendance.getSemdept().getIdSem());
	   		     System.out.println("Not Code:"+attendance.getSubject().getCode());	 
           	     System.out.println("Not IdMonth:"+attendance.getMonth().getIdMonth());
     			attendanceService.createAbsent(attendance,idStudent[j]);
     			 Calendar cal = Calendar.getInstance();
     			int year=cal.get(cal.YEAR);
     	        int idYear=attendanceService.find(year);
     			attendanceService.checkInPercentStatusOfAbsent(attendance.getSemdept().getIdSem(),attendance.getSubject().getCode(),idStudent[j],idYear);
}
	        }else
	        if(idStudent[j]!=idStudent[j+1] && idStudent[j]!=idStudent[j-1]) {
	        	System.out.println("Not Present Student IdStudent:"+idStudent[j]);
			     System.out.println("Not date:"+attendance.getaDate());
			     System.out.println("Not IdSem:"+attendance.getSemdept().getIdSem());
			     System.out.println("Not Code:"+attendance.getSubject().getCode());	   
           	     System.out.println("Not IdMonth:"+attendance.getMonth().getIdMonth());
     			 attendanceService.createAbsent(attendance,idStudent[j]);
     			 Calendar cal = Calendar.getInstance();
     			int year=cal.get(cal.YEAR);
     	        int idYear=attendanceService.find(year);
      			attendanceService.checkInPercentStatusOfAbsent(attendance.getSemdept().getIdSem(),attendance.getSubject().getCode(),idStudent[j],idYear);
}
	    }
		return "redirect:/attendance/viewAttendance/"+attendance.getSemdept().getIdSem()+ "/" +attendance.getSubject().getCode();
	 }
	 
	 
	 
	 
	 @RequestMapping(value="/viewAttendance/{semdept_idSem}/{subject_code}", method=RequestMethod.GET)
		public String viewAttendance(@PathVariable("semdept_idSem") int semdept_idSem,@PathVariable("subject_code") int subject_code,@ModelAttribute("attendance") Attendance attendance,Map<String, Object> map){	
			
		 Calendar cal = Calendar.getInstance();
			int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 map.put("viewAttendanceList",attendanceService.search(semdept_idSem,subject_code,idYear));
			 Subject s=subjectService.find2(subject_code);
				String subName=s.getSubjectName(); 
			map.put("subjectName",subName);
			 Semdept sd=semdeptService.findName(semdept_idSem);
			 map.put("semName",sd.getSemName());
			 map.put("dept",sd.getDept());
			 map.put("semdept_idSem",semdept_idSem);
			 map.put("subject_code",subject_code);

			
			return "/viewAttendanceTeacherPanel";
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
		 {for (int i = a-1; i <=a ; i++) {
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
			 {k=a-1;}
			 for (int i = k; i <=a ; i++) {
					Month sm = sd.get(i);
					monthList.add(sm.getMonthName());

			 }
		 }
		 
		model.addAttribute("monthList",monthList);
		model.addAttribute("month",new Month());
	 }
	 
	 
	 
	 
	 @RequestMapping(value="/takeOlderAttendance/{semdept_idSem}/{subject_code}", method=RequestMethod.GET)
		public String takeOlderAttendance(@PathVariable("semdept_idSem") int semdept_idSem,@PathVariable("subject_code") int subject_code,@ModelAttribute("month") Month month,Map<String, Object> map){		   
		 map.put("idSem",semdept_idSem);
		 map.put("code",subject_code);
			return "/takeOlderAttendance";
		}
	 
	 
	 @RequestMapping(value="/takeOlderAttendance/{idSem}/{code}", method=RequestMethod.POST)
	 public String viewMonthly(@ModelAttribute("month") Month month,@PathVariable("idSem") int idSem,@PathVariable("code") int code,Map<String, Object> map){
	 		 Month sdd = attendanceService.find(month);	
	 	    int ab=sdd.getIdMonth(); 
	 	    Calendar cal = Calendar.getInstance();
	 	    cal.set(Calendar.MONTH, ab-1);
	 	    cal.set(Calendar.DAY_OF_MONTH, 1);
	 	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 	    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	 		SimpleDateFormat dd = new SimpleDateFormat("dd");
	 	    Date date = new Date();  	
	 		String s = dd.format(date);
	 		int presentDateNo=Integer.valueOf(s);
	 	   int a=Calendar.getInstance().get(Calendar.MONTH);
	 	   
	 	    List<String> list=new ArrayList();
	 	    List<String> list1=new ArrayList();
 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));
 		    list.add(df.format(cal.getTime()));
	 	   
 		   if(a==ab-1){
 				for (int i = 1; i < presentDateNo; i++) {
 			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
 		 		    list.add(df.format(cal.getTime()));
 		 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));

 			    }
 			}   
 			else{
 			   for (int i = 1; i < maxDay; i++) {
 			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
 		 		    list.add(df.format(cal.getTime()));
 		 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));

 			    }
 			}
 		    
	 	    map.put("dates", list);
	 	    map.put("status", list1);
	 			map.put("idMonth",ab);
	 			map.put("takeOlderAttendanceList",attendanceService.takeOlderAttendance(idSem,code,ab));
	 			return "/viewOlderAttendance";
	 		}
	 
	 
	 
	 @RequestMapping(value="/takeNewOlderAttendance/{idSem}/{code}/{date}/{idMonth}", method=RequestMethod.GET)
		public String takeNewOlderAttendance(@ModelAttribute("attendance")Attendance attendance,@PathVariable("idSem") int idSem,@PathVariable("code") int code,@PathVariable("date") String date,@PathVariable("idMonth") int idMonth,Map<String, Object> map){
		System.out.println("IdMonthhh:"+idMonth);
		 map.put("month",idMonth);
		map.put("attendance",new Attendance());

    TreeSet<String> subjectList=new TreeSet<>();
    List<Attendance> presentStudent=attendanceService.checkAttendanceTaken(idSem,code,date);
    if(presentStudent!=null) {
    List<Attendance> absentStudent=attendanceService.checkAttendanceTakenAbsent(idSem,code,date);
    map.put("presentStudent", presentStudent);
    map.put("absentStudent", absentStudent);}
    else {
		 TreeSet<String> studentsList=new TreeSet<>();
			List<Student> sd=studentService.find1(idSem);
			map.put("sd",sd);
			 for (int i = 0; i < sd.size(); i++) {
					Student sm = sd.get(i);		
					studentsList.add(sm.getStudentName());
					map.put("students", studentsList);}
}
			map.put("idSem",idSem);
			map.put("code",code);
			return "/newTakeAttendance";
		}
	 
	 
	 
	 

	 @RequestMapping(value = "/newEditCustomer/abc/{date}/{idSem}/{code}/{month}" , method = RequestMethod. POST)
	 public String newEditCustomer(@PathVariable("code")int code,@PathVariable("idSem")int idSem,@PathVariable("month")int month,@PathVariable("date")String date,@RequestParam(value = "idStudent", required = false) int[] idStudent) 
	 {int ans=0;
 	System.out.println("Present student IdStudent:"+idSem);
	System.out.println("Present student IdStudent:"+code);
	System.out.println("Present student IdStudent:"+month);
	System.out.println("Present student IdStudent:"+date);
	System.out.println("Present student IdStudent:"+idStudent);

	   for (int k = 0; k <idStudent.length -1; k++)
        {
            for (int l = k+1; l < idStudent.length; l++)
            {
                if ((idStudent[k] == idStudent[l]) && (k!= l))
                {
                	System.out.println("Present student IdStudent:"+idStudent[l]);
           	     System.out.println("date:"+date);
           	     System.out.println("IdSem:"+idSem);
           	     System.out.println("Code:"+code);
           	     System.out.println("IdMonth:"+month);
     			attendanceService.create(idSem,code,month,date,idStudent[l]);
     			 Calendar cal = Calendar.getInstance();
      			int year=cal.get(cal.YEAR);
      	        int idYear=attendanceService.find(year);
     			attendanceService.checkInPercentStatusOfPresent(idSem,code,idStudent[l],idYear);
                }	
            }   
    }
	 Arrays.sort(idStudent);
	    System.out.println(Arrays.toString(idStudent));
	    for (int j = 0; j < idStudent.length; j++) {
	        if(j==0) {
	            if(idStudent[j]!=idStudent[j+1]) {
	            	System.out.println("Not Present Student IdStudent:"+idStudent[j]);
	            	 System.out.println("date:"+date);
	           	     System.out.println("IdSem:"+idSem);
	           	     System.out.println("Code:"+code);
	           	     System.out.println("IdMonth:"+month);

     			attendanceService.createAbsent(idSem,code,month,date,idStudent[j]);
     			 Calendar cal = Calendar.getInstance();
      			int year=cal.get(cal.YEAR);
      	        int idYear=attendanceService.find(year);
     			attendanceService.checkInPercentStatusOfAbsent(idSem,code,idStudent[j],idYear);
}
	        }else
	        if(j==idStudent.length-1) {
	            if(idStudent[j]!=idStudent[j-1]) {
	            	System.out.println("Not Present Student IdStudent:"+idStudent[j]);
	            	 System.out.println("date:"+date);
	           	     System.out.println("IdSem:"+idSem);
	           	     System.out.println("Code:"+code);
	           	     System.out.println("IdMonth:"+month);

     			attendanceService.createAbsent(idSem,code,month,date,idStudent[j]);
     			 Calendar cal = Calendar.getInstance();
      			int year=cal.get(cal.YEAR);
      	        int idYear=attendanceService.find(year);
     			attendanceService.checkInPercentStatusOfAbsent(idSem,code,idStudent[j],idYear);
}
	        }else
	        if(idStudent[j]!=idStudent[j+1] && idStudent[j]!=idStudent[j-1]) {
	        	System.out.println("Not Present Student IdStudent:"+idStudent[j]);
	        	 System.out.println("date:"+date);
           	     System.out.println("IdSem:"+idSem);
           	     System.out.println("Code:"+code);
           	     System.out.println("IdMonth:"+month);

     			 attendanceService.createAbsent(idSem,code,month,date,idStudent[j]);
     			 Calendar cal = Calendar.getInstance();
      			int year=cal.get(cal.YEAR);
      	        int idYear=attendanceService.find(year);
      			attendanceService.checkInPercentStatusOfAbsent(idSem,code,idStudent[j],idYear);
}
	    }
		return "redirect:/attendance/viewAttendance/"+idSem+ "/" +code;
	 }
	 
	 
	 
	 
	 @RequestMapping(value="/delete/{idSem}/{code}/{attendance}", method=RequestMethod.GET)
		public String delete(@PathVariable("idSem") int idSem,@PathVariable("code") int code,@PathVariable("attendance") String attendance,Map<String, Object> map){	
			attendanceService.delete(idSem,code,attendance);
			List<Student> sd=studentService.find1(idSem);
			 for (int i = 0; i < sd.size(); i++) {
					Student sm = sd.get(i);		
					int a=sm.getIdStudent();
					 Calendar cal = Calendar.getInstance();
		      			int year=cal.get(cal.YEAR);
		      	        int idYear=attendanceService.find(year);
	     			attendanceService.checkInPercentStatusOfPresent(idSem,code,a,idYear);
	      			attendanceService.checkInPercentStatusOfAbsent(idSem,code,a,idYear);
	      			a=0;
					}
			
			return "redirect:/attendance/takeOlderAttendance/{idSem}/{code}";
		}
	 
	 
	 
	 
	 
	 @RequestMapping(value="/yearSearch", method=RequestMethod.GET)
		public String year(Map<String, Object> map){
			map.put("year",new Year());
			return "/selectYear";
		}
	 
	 
	 @RequestMapping(value="/semdeptSearch", method=RequestMethod.POST)
		public String register1(@ModelAttribute("year")Year year,Map<String, Object> map,BindingResult bindingResult){
		 if(bindingResult.hasErrors()) {
				return ("failure");
			}
		 Year y=attendanceService.find(year);
			int idYear=y.getIdYear();
		 map.put("semdept",new Semdept());
		 map.put("idYear",idYear);

			return "/attendanceSemdeptSearch";
		}
	 
	 
	 @RequestMapping(value="/subjectSearch/{idYear}", method=RequestMethod.POST)
     public ModelAndView find(@Valid @PathVariable("idYear")int idYear,@ModelAttribute("semdept") Semdept semdept,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
				return new ModelAndView("failure");
			}
	 ModelAndView mav = new ModelAndView("attendanceSubjectSearch");
     Semdept sdd = studentService.find(semdept);	 
     int idSem=sdd.getIdSem();
     List<Subject> sd=subjectService.find3(idSem);
     mav.addObject("subjectList", sd);
     mav.addObject("idSem", sdd.getIdSem());
     mav.addObject("idYear", idYear);
     mav.addObject("subject", new Subject());
		mav.addObject("teachersemdeptsubject",new TeacherSemdeptSubject());
			    return mav;
	 }
	 
	 
	 
	 
	 @RequestMapping(value="/viewAttendanceAdminPanel/{idSem}/{idYear}", method=RequestMethod.POST)
		public String viewAttendanceAdminPanel(@PathVariable("idSem") int idSem,@PathVariable("idYear") int idYear,@ModelAttribute("subject") Subject subject,Map<String, Object> map,BindingResult bindingResult){	
		 if(bindingResult.hasErrors()) {
				return "/failure";
			}
		String ss=subject.getSubjectName();
		int code=Integer.parseInt(ss);
		map.put("viewAttendanceList",attendanceService.search(idSem,code,idYear));
		map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));
		 Semdept sd=semdeptService.findName(idSem);
		 map.put("semName",sd.getSemName());
		 map.put("dept",sd.getDept());
		 map.put("code",code);
		 map.put("idSem",idSem);
		 map.put("idYear",idYear);
			return "/viewAttendance";
		}
	 
	 
	 
	 
	 @ModelAttribute()
	 public void headerMessage2(Model model) {
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
	 
	 
	 

	 
	 @ModelAttribute()
	 public void headerMessage3(Model model) {
		    Calendar cal = Calendar.getInstance();
			int year=cal.get(cal.YEAR);
		 List<Integer> yearList=new ArrayList<>();
		 for (int i = year; i >= 2019; i--) {				
			 yearList.add(i);
			 }
		model.addAttribute("yearList",yearList);
	 }
	 
	 
	 @RequestMapping(value="/viewAttendanceStudent/{idStudent}/{idSem}/{code}/{idYear}", method=RequestMethod.GET)
		public String viewAttendanceStudent(@PathVariable("idSem") int idSem,@PathVariable("idStudent") int idStudent,@PathVariable("code") int code,@PathVariable("idYear") int idYear,Map<String, Object> map){	
			map.put("viewAttendanceStudentList",attendanceService.dailyStudentAttendance(idStudent,idSem,code,idYear));
			map.put("idSem",idSem);			
			map.put("idStudent",idStudent);			
			map.put("code",code);
			map.put("idYear",idYear);
			Student sd=studentService.find(idStudent);
			String rollNo=sd.getUser().getPassword();
			String studentName=sd.getStudentName();
			map.put("rollNo",rollNo);
			map.put("studentName",studentName);
			map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));			
			return "/viewDailyAttendanceOfAdminPanel";}
	 
	 
	 @ModelAttribute()
	 public void headerMessage5(Model model) {
		 List<String> monthList=new ArrayList<>();
		 List<Month> sd=attendanceService.findAll();
		 int i;
		 for(i=0;i<sd.size();i++) {
			 Month sm=sd.get(i);
			monthList.add(sm.getMonthName());
		 }
		 
		model.addAttribute("newMonthList",monthList);
		model.addAttribute("month",new Month());
	 }
	 
	 
	 @RequestMapping(value="/viewMonthly/{idStudent}/{idSem}/{code}/{idYear}", method=RequestMethod.POST)
	 public String viewMonthly(@ModelAttribute("month") Month month,@PathVariable("idSem") int idSem,@PathVariable("idStudent") int idStudent,@PathVariable("code") int code,@PathVariable("idYear") int idYear,Map<String, Object> map){
	 		 Month sdd = attendanceService.find(month);	
	 	     int ab=sdd.getIdMonth(); 
	 		 System.out.println("IdMonth:"+ab);
	 	System.out.println("IdMonth:"+month.getMonthName());
	 			map.put("viewAttendanceStudentList",attendanceService.monthlyStudentAttendance(idStudent,idSem,code,ab,idYear));
	 			Student sd=studentService.find(idStudent);
				String rollNo=sd.getUser().getPassword();
				String studentName=sd.getStudentName();
				map.put("rollNo",rollNo);
				map.put("studentName",studentName);
				map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));			

	 			return "/viewDailyAttendanceOfAdminPanel";
	 		}
	 
	 
	 @RequestMapping(value="/viewMonthlyAdminPanel/{idSem}/{code}/{idYear}", method=RequestMethod.GET)
		public String viewMonthlyAdminPanel(@PathVariable("idSem") int idSem,@PathVariable("code") int code,@PathVariable("idYear") int idYear,@ModelAttribute("month") Month month,Map<String, Object> map){		   
		 map.put("idSem",idSem);
		 map.put("code",code);
		 map.put("idYear",idYear);
		 map.put("month",new Month());
			return "/monthSelectAdminPanel";
		}
	
	 
	 
	 
	 
	 @RequestMapping(value="/viewMonthlyAdminPanel/{idSem}/{code}/{idYear}", method=RequestMethod.POST)
	 public String viewMonthlyAdminPanel(@ModelAttribute("month") Month month,@PathVariable("idSem") int idSem,@PathVariable("idYear") int idYear,@PathVariable("code") int code,Map<String, Object> map){
	 		 Month sdd = attendanceService.find(month);	
	 	    int ab=sdd.getIdMonth(); 
	 	    Calendar cal = Calendar.getInstance();
	 	    cal.set(Calendar.MONTH, ab-1);
	 	    cal.set(Calendar.DAY_OF_MONTH, 1);
	 	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 	   int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	 	    List<String> list=new ArrayList();
	 	    List<String> list1=new ArrayList();
 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));
 		    list.add(df.format(cal.getTime()));
	 	   
 			   for (int i = 1; i < maxDay; i++) {
 			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
 		 		    list.add(df.format(cal.getTime()));
 		 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));
 			    }
	 	    map.put("dates", list);
	 	    map.put("status", list1);
	 			map.put("idMonth",ab);
	 			map.put("idYear",idYear);

	 			map.put("takeOlderAttendanceList",attendanceService.takeOlderAttendance(idSem,code,ab));
	 			return "/viewDatesAdminPanel";
	 		}
	 
	 
	 @RequestMapping(value="/attendanceByDatesAdminPanel/{idSem}/{code}/{date}/{idMonth}/{idYear}", method=RequestMethod.GET)
		public String attendanceByDatesAdminPanel(@ModelAttribute("attendance")Attendance attendance,@PathVariable("idSem") int idSem,@PathVariable("code") int code,@PathVariable("date") String date,@PathVariable("idMonth") int idMonth,@PathVariable("idYear") int idYear,Map<String, Object> map){
		System.out.println("IdMonthhh:"+idMonth);
		 map.put("month",idMonth);
		map.put("attendanceList",attendanceService.dateWiseAttendance(idSem, code, date, idMonth));
 
			map.put("idSem",idSem);
			map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));	
			Semdept sd=semdeptService.findName(idSem);
			map.put("dept",sd.getDept());			
			map.put("semName",sd.getSemName());			
			map.put("date",date);			
			Month m=attendanceService.findMonthName(idMonth);
			map.put("monthName",m.getMonthName());	
			map.put("idYear",idYear);			


			return "/attendanceByDatesAdminPanel";
		}
	 
	 
	 
	 @RequestMapping(value="/viewMonthlyTeacherPanel/{idSem}/{code}", method=RequestMethod.GET)
		public String viewMonthlyTeacherPanel(@PathVariable("idSem") int idSem,@PathVariable("code") int code,@ModelAttribute("month") Month month,Map<String, Object> map){		   
		 map.put("idSem",idSem);
		 map.put("code",code);
		 Calendar cal = Calendar.getInstance();
		 int year=cal.get(cal.YEAR);
	        int idYear=attendanceService.find(year);
		 map.put("idYear",idYear);
		 map.put("month",new Month());
			return "/monthSelectTeacherPanel";
		}
	 
	 
	 @RequestMapping(value="/viewMonthlyTeacherPanel/{idSem}/{code}/{idYear}", method=RequestMethod.POST)
	 public String viewMonthlyTeacherPanel(@ModelAttribute("month") Month month,@PathVariable("idSem") int idSem,@PathVariable("idYear") int idYear,@PathVariable("code") int code,Map<String, Object> map){
	 		 Month sdd = attendanceService.find(month);	
	 	    int ab=sdd.getIdMonth(); 
	 	   Calendar cal = Calendar.getInstance();
	 	    cal.set(Calendar.MONTH, ab-1);
	 	    cal.set(Calendar.DAY_OF_MONTH, 1);
	 	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 	    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	 		SimpleDateFormat dd = new SimpleDateFormat("dd");
	 	    Date date = new Date();  	
	 		String s = dd.format(date);
	 		int presentDateNo=Integer.valueOf(s);
	 	   int a=Calendar.getInstance().get(Calendar.MONTH);
	 	   
	 	    List<String> list=new ArrayList();
	 	    List<String> list1=new ArrayList();
		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));
		    list.add(df.format(cal.getTime()));
	 	   
		   if(a==ab-1){
				for (int i = 1; i < presentDateNo; i++) {
			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
		 		    list.add(df.format(cal.getTime()));
		 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));

			    }
			}   
			else{
			   for (int i = 1; i < maxDay; i++) {
			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
		 		    list.add(df.format(cal.getTime()));
		 		    list1.add(attendanceService.checkStatus(idSem, code,df.format(cal.getTime())));

			    }
			}
		    
	 	    map.put("dates", list);
	 	    map.put("status", list1);
	 			map.put("idMonth",ab);
	 			map.put("takeOlderAttendanceList",attendanceService.takeOlderAttendance(idSem,code,ab));
	 			return "/viewDatesTeacherPanel";
	 		}
	 
	 
	 
	 @RequestMapping(value="/attendanceByDatesTeacherPanel/{idSem}/{code}/{date}/{idMonth}", method=RequestMethod.GET)
		public String attendanceByDatesTeacherPanel(@ModelAttribute("attendance")Attendance attendance,@PathVariable("idSem") int idSem,@PathVariable("code") int code,@PathVariable("date") String date,@PathVariable("idMonth") int idMonth,Map<String, Object> map){
		System.out.println("IdMonthhh:"+idMonth);
		 map.put("month",idMonth);
		map.put("attendanceList",attendanceService.dateWiseAttendance(idSem, code, date, idMonth));

			map.put("idSem",idSem);
			map.put("subjectName",subjectService.fetchSubjectNameFromCode(code));	
			Semdept sd=semdeptService.findName(idSem);
			map.put("dept",sd.getDept());			
			map.put("semName",sd.getSemName());			
			map.put("date",date);			
			Month m=attendanceService.findMonthName(idMonth);
			map.put("monthName",m.getMonthName());			

			return "/attendanceByDatesTeacherPanel";
		}
	 
	 
	 

	 @ModelAttribute()
	 public void headerMessage6(Model model) {
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
			 {k=a-1;}
			 for (int i = 6; i <=a ; i++) {
					Month sm = sd.get(i);
					monthList.add(sm.getMonthName());

			 }
		 }
		 
		model.addAttribute("viewMonthList",monthList);
		model.addAttribute("month",new Month());
	 }
}

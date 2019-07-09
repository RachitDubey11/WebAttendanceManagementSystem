package com.projectspring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectspring.model.Attendance;
import com.projectspring.model.TeacherSemdeptSubject;
import com.projectspring.model.Student;
import com.projectspring.model.Teacher;
import com.projectspring.model.User;
import com.projectspring.service.HelloWorldService;
import com.projectspring.service.SemdeptService;
import com.projectspring.service.StudentService;
import com.projectspring.service.SubjectService;
import com.projectspring.service.TeacherSemdeptSubjectService;
import com.projectspring.service.TeacherService;
import com.projectspring.service.UserService;

@Controller
public class HelloWorldController {


	@Autowired
	TeacherSemdeptSubjectService teachersemdeptsubjectService;
	@Autowired
	HelloWorldService helloWorldService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	private UserService userService;
	@Autowired
	private SemdeptService semdeptService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "Home";
	}
	
	@RequestMapping(value = { "/about"}, method = RequestMethod.GET)
	public String about(ModelMap model) {
		return "about";
	}
	
	@RequestMapping(value = { "/contact"}, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		return "contact";
	}
	
	@RequestMapping(value = { "/help"}, method = RequestMethod.GET)
	public String help(ModelMap model) {
		return "help";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("userName", getPrincipal());
	   int a=helloWorldService.findUser1(getPrincipal());
	   User user=helloWorldService.findUser(a);
		model.addAttribute("password",user.getPassword());
		model.addAttribute("id",a);
		return "adminHomePage";
	}
	
	@RequestMapping(value="/adminEdit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Map<String, Object> map){
		   User user=helloWorldService.findUser(id);
		map.put("user",user);
		return "/editAdmin";
	}
	
	@RequestMapping(value="/adminUpdate", method=RequestMethod.POST)
	public String update(@Valid User user,BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()) {
			return "/editAdmin";
		}
		helloWorldService.update(user);
		int a=user.getId();
		   User user1=helloWorldService.findUser(a);
			model.addAttribute("userName",user1.getUserName());
			model.addAttribute("password",user1.getPassword());
			model.addAttribute("id",a);

		return "adminHomePage";
	}

	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public ModelAndView dbaPage(Map<String, Object> map) {
		 ModelAndView mav = new ModelAndView("teacherHomePage");
		mav.addObject("user", getPrincipal());
		int idTeacher=helloWorldService.find(getPrincipal());
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		List<TeacherSemdeptSubject> sd=teachersemdeptsubjectService.find(idTeacher);
		mav.addObject("teachersemdeptsubjectList",sd);
		 
		Teacher teacher=teacherService.find(idTeacher);
			mav.addObject("attendance",new Attendance());
			mav.addObject("teacherName",teacher.getTeacherName());
			mav.addObject("email",teacher.getEmail());
			mav.addObject("phoneNumber",teacher.getPhoneNumber());
			mav.addObject("date",dateFormat.format(date));
	return mav;
	}
	
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		int ab= helloWorldService.findStudent(getPrincipal());
		Student sd=studentService.find(ab);
		model.addAttribute("semName",sd.getSemdept().getSemName());
		model.addAttribute("password",sd.getUser().getPassword());
		model.addAttribute("dept",sd.getSemdept().getDept());
		model.addAttribute("studentName",sd.getStudentName() );
		int idSem=sd.getSemdept().getIdSem();
		model.addAttribute("subjectValue", subjectService.find1(idSem));
		model.addAttribute("viewAttendanceList", helloWorldService.find(idSem,sd.getIdStudent()));
		model.addAttribute("idSem", idSem);
		model.addAttribute("idStudent", sd.getIdStudent());
		return "studentHomePage";
	}

	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	



	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


}
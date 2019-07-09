package com.projectspring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.projectspring.model.Teacher;
import com.projectspring.model.User;
import com.projectspring.service.SemdeptService;
import com.projectspring.service.StudentService;
import com.projectspring.service.TeacherService;

@Controller
@RequestMapping(value="/teachers")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	@Autowired
	SemdeptService semdeptService;
	@Autowired
	 Semdept semdept;
	
	@RequestMapping(value="/teachersList", method=RequestMethod.GET)
	public String teachersList( Map<String, Object> map){
		map.put("teachersList",teacherService.findAll());
		return "/teachers";
	}
	
	@RequestMapping(value="/teachersubjectList/{idTeacher}", method=RequestMethod.GET)
	public String teachersubjectList(@PathVariable("idTeacher") Integer idTeacher, Map<String, Object> map){
		map.put("teachersubjectList",teacherService.findAll());
		return "/viewDetailsTeacher";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Map<String, Object> map){
		map.put("teacher",new Teacher());
		return "/addTeacher";
	}	
	
	@RequestMapping(value = "/create")
	public ModelAndView newCreate() {
		Teacher teacher = new Teacher();
		User user = new User();
		teacher.setUser(user);
		return new ModelAndView("addTeacher", "teachers", teacher);
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("teacher") Teacher teacher,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "/addTeacher";
		}
		teacherService.create(teacher);
		return "redirect:/teachers/teachersList";
	}
	
	
	@RequestMapping(value="/edit/{idTeacher}", method=RequestMethod.GET)
	public String edit(@PathVariable("idTeacher") Integer idTeacher, Map<String, Object> map){
		Teacher teacher=teacherService.find(idTeacher);
		map.put("teacher",teacher);
		return "/editTeacher";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid Teacher teacher,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "/editTeacher";
		}
		teacherService.update(teacher);
		return "redirect:/teachers/teachersList";
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Map<String, Object> map){
		teacherService.delete(id);
		return "redirect:/teachers/teachersList";
	}
	
	
	@RequestMapping(value="/details/{idTeacher}", method=RequestMethod.GET)
	public String details(@PathVariable("idTeacher") Integer idTeacher,Map<String, Object> map){
		Teacher teacher=teacherService.find(idTeacher);
		map.put("teacher",teacher.getTeacherName());
		return "/viewDetailsTeacher";
	}
	
	
}

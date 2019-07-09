package com.projectspring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
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
import com.projectspring.model.Student;
import com.projectspring.model.Subject;
import com.projectspring.service.SemdeptService;
import com.projectspring.service.SubjectService;
import com.projectspring.service.TeacherService;

@Controller
@RequestMapping(value="/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	@Autowired
	SemdeptService semdeptService;
	
	@RequestMapping(value="/subjectList", method=RequestMethod.GET)
	public String subjectList( Map<String, Object> map){
		map.put("subjectList",subjectService.findAll());
		return "/subject";
    }
	

	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String register(Map<String, Object> map){
		map.put("semdept",new Semdept());
		return "/subjectSearch";
	}
	

	
	 @RequestMapping(value="/find", method=RequestMethod.POST)
     public ModelAndView find(@Valid @ModelAttribute("semdept") Semdept semdept,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
				return new ModelAndView("subjectSearch");	}
	 ModelAndView mav = new ModelAndView("subjectDetails");
     Semdept sdd = subjectService.find(semdept);
	 if (null != sdd) {		 	
    mav.addObject("idSem", sdd.getIdSem());
     int ab=sdd.getIdSem(); 
     mav.addObject("subjectValue", subjectService.find1(ab));
      } else {
              mav = new ModelAndView("failure");
			    mav.addObject("message", "No details found");
			    }
			    return mav;
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
	 
	
	 
	 @RequestMapping(value="/register/{idSem}", method=RequestMethod.GET)
		public String register(@PathVariable("idSem") int idSem,Map<String, Object> map){
			map.put("subject",new Subject());
			map.put("semdept",new Semdept());
			map.put("st",idSem);
			return "/addSubject";
		}
	 
		
		@RequestMapping(value="/create.html", method=RequestMethod.POST)
		public String create(@RequestParam("subjectName")String subjectName,@RequestParam("idSem")int idSem){	
			subjectService.create(subjectName,idSem);
			return "redirect:/subject/redirectSubjectList/"+idSem;
		}
		 

		 @RequestMapping(value="/edit/{code}/{idSem}", method=RequestMethod.GET)
			public String edit(@PathVariable("idSem") int idSem,@PathVariable("code") int code, Map<String, Object> map){
				Subject subject=subjectService.find2(code);
				map.put("subject",subject);
				map.put("idSem",idSem);
				return "/editSubject";
			}
		 
		 
		 @RequestMapping(value="/update/{idSem}", method=RequestMethod.POST)
			public String update(@Valid @PathVariable("idSem") int idSem,Subject subject,BindingResult bindingResult){
			 if(bindingResult.hasErrors()) {
					return "/editSubject";
				}
				subjectService.update(subject);
				return "redirect:/subject/redirectSubjectList/"+idSem;
			}
		 
		 
		 @RequestMapping(value="/delete/{code}/{idSem}", method=RequestMethod.GET)
			public String delete(@PathVariable("idSem") int idSem,@PathVariable("code") int code,@ModelAttribute("semdept") Semdept semdept, Map<String, Object> map){
			 subjectService.delete(code);
				return "redirect:/subject/redirectSubjectList/"+idSem;
			}
		 
		 
		 
		 @RequestMapping(value="/redirectSubjectList/{idSem}", method=RequestMethod.GET)
	     public ModelAndView redirectSubjectList(@PathVariable("idSem") int idSem) {
		 ModelAndView mav = new ModelAndView("subjectDetails");
	     mav.addObject("subjectValue", subjectService.find1(idSem));
				    return mav;
	 }
}
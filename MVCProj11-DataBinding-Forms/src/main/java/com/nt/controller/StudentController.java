package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/register")
	public  String  showForm(@ModelAttribute("stFrm") Student st) {
		System.out.println("StudentController.showForm()"+st);
		st.setSadd("hyd");
		return "student_form";
	}
	
	@PostMapping("/register")
	public  String  processForm(Map<String,Object>map,@ModelAttribute("stFrm") Student st) {
		System.out.println("StudentController.processForm()"+st);
		//b.logic
		return "result";
	}
	
	
	

}

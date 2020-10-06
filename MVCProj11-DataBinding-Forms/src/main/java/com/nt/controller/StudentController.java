package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	/*@GetMapping("/register")
	public  String  showForm(@ModelAttribute("stFrm") Student st) {
		System.out.println("StudentController.showForm()"+st);
		st.setSadd("hyd");
		return "student_form";
	}*/
	
	@GetMapping("/register")
	public  String  showForm(@ModelAttribute Student st) {
		System.out.println("StudentController.showForm()"+st);
		st.setSadd("hyd");
		return "student_form";
	}
	
	/*	@PostMapping("/register")
		public  String  processForm(Map<String,Object>map,@ModelAttribute("stFrm") Student st) {
			System.out.println("StudentController.processForm()"+st);
			//b.logic
			return "result";
		}*/
	
	@PostMapping("/register")
	public  String  processForm(Map<String,Object>map,@ModelAttribute Student st) {
		System.out.println("StudentController.processForm()"+st);
		//b.logic
		return "result";
	}
	
	
	/*@GetMapping("/links")
	public String  getLinksData(Map<String,Object>map,
			                                       @RequestParam("sno") int no,
			                                       @RequestParam("sname") String name) {
		System.out.println("request params:::"+no+"    "+name);
		return "show_params";
	}
	*/
	
	@GetMapping("/links")
	public String  getLinksData(Map<String,Object>map,
			                                       @RequestParam List<String> sadd,
			                                       @RequestParam(required =false) Integer sno,
			                                       @RequestParam(required = false,defaultValue = "anonymous") String sname) {
		System.out.println("request params:::"+sno+"    "+sname+" "+sadd.get(0)+"...  "+sadd.get(1));
		return "show_params";
	}
	
	

}

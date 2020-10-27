package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NareshITNavigationController {
	
	@GetMapping("/home")
	public  String showHomePage() {
		return "homeDef"; //tile definitation as lvn
	}
	
	@GetMapping("/faculty")
	public  String showFacultiesPage() {
		return "facultyDef"; //tile definitation as lvn
	}
	
	@GetMapping("/address")
	public  String showAddressPage(Map<String,Object> map) {
		map.put("phoneNo",9999999L);
		return "addressDef"; //tile definitation as lvn
		
	}
	
	@GetMapping("/course")
	public  String showCoursesPage() {
		return "courseDef"; //tile definitation as lvn
	}
	
	@GetMapping("/logout")
	public  String showExitPage() {
		//return lvn  (not the tile definitation)
		return "exit_page";
	}

}//class

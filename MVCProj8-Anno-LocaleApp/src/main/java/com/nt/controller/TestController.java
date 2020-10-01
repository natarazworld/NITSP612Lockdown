package com.nt.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@Autowired
	  private ServletContext sc;   // 1 per web application
	 @Autowired
	private  ServletConfig cg;  //1 per Servlet DS
   
	//@RequestMapping(value="/first", method= RequestMethod.GET)
	@GetMapping("/first")
	public  String  showHomePage1(HttpServletRequest req , HttpServletResponse res) {
		System.out.println("TestController.showHomePage1()");
		  System.out.println(sc.getClass());
		  System.out.println(cg.getClass());
		  System.out.println(req.getClass());
		  System.out.println(res.getClass());
		return  "home_page";
	}
	
	
	
	
	

	/*@RequestMapping(method=RequestMethod.POST)      //   "/" + POST mode 
	public  String  showHomePage2() {
		System.out.println("TestController.showHomePage2()=POST");
		return "home_page";
	}*/
}

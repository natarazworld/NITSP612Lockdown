package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowBrowserController {

	@GetMapping("/welcome")
	public String  showHomePage() {
		//return lvn
		return "home";
	}
	
	@GetMapping("/browser")
	public String  getBrowserName(Map<String,Object> map,HttpServletRequest req) {
		//get browser s/w name
		String brName=req.getHeader("user-agent");
		//keep browser name as model attribute
		map.put("browser",brName);
		//return lvn
		return "result";
	}
}

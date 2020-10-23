package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishService;

@Controller
public class WishMessageController {
	@Autowired
	private IWishService service;
	
	@GetMapping("/welcome")
	public   String showHome() {
		//retrun lvn
		return "home";
	}
	
	@GetMapping("/wish")
	public  String  showWishMessage(Map<String,Object> map) {
		//use service
		String msg=service.generateWishMessage();
		//keep results in Map object as model attrobute
		map.put("wMsg", msg);
		//return lvn
		return "show_message";
	}

}

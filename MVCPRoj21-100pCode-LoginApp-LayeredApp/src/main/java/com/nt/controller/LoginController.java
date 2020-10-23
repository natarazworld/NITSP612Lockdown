package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.UserDTO;
import com.nt.model.User;
import com.nt.service.ILoginMgmtService;

@Controller
public class LoginController {
	@Autowired
	private ILoginMgmtService service;
	
	@GetMapping("/login")
	public  String  showLoginForm(@ModelAttribute User userDetails) {
		userDetails.setUname("Ghost");
		return "login_form";
	}

	@PostMapping("/login")
	public    String  performLogin(Map<String,Object> map,
			                                           @ModelAttribute User user) {
		UserDTO dto=new UserDTO();
		String result=null;
		//convert model to dTO
		   BeanUtils.copyProperties(user,dto);
		//use service
		   result=service.login(dto);
		   //add reuslt map object
		   map.put("resultMsg",result);
		   //return lvn;
		   return "login_form";
	}//method
}

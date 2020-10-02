package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	private  IEmployeeMgmtService service;
	
	
	@GetMapping("/welcome")
	public  String showHome() {
		return "home";  //lnv for home
	}
	
	@GetMapping("/list_emps")
	public String  showEmployees(Map<String,Object> map) {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllEmployees();
		//keep results in model attriute
		map.put("empsInfo", listDTO);
		return "show_report";
	}
	
	

}

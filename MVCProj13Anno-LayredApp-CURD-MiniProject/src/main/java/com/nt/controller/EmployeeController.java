package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	private  IEmployeeMgmtService service;
	
	
	@GetMapping("/welcome.htm")
	public  String showHome() {
		return "home";  //lnv for home
	}
	
	@GetMapping("/list_emps.htm")
	public String  showEmployees(Map<String,Object> map) {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllEmployees();
		//keep results in model attriute
		map.put("empsInfo", listDTO);
		return "show_report";
	}
	
	@GetMapping("/saveEmp.htm")
	public String  showEmpRegistrationPage(@ModelAttribute("empFrm") Employee emp) {
		System.out.println("EmployeeController.showEmpRegistrationPage()");
		return "employee_register";
	}
	
	@PostMapping("/saveEmp.htm")
	public  String  saveEmployee(Map<String,Object> map, @ModelAttribute("empFrm") Employee emp){
		System.out.println("EmployeeController.saveEmployee()");
		EmployeeDTO dto=null;
		String result=null;
		List<EmployeeDTO> listDTO=null;
		//convert model to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(emp,dto);
		//use Service
		result=service.registerEmployee(dto);
		listDTO=service.fetchAllEmployees();
		//keep in  mode attribute (map obj)
		map.put("resultMsg",result);
		map.put("empsInfo", listDTO);
		//return lvn
		return "show_report";
		
	}
	
	@ModelAttribute("deptsInfo")  //constructing reference data/initial for select box
	public List<Integer>  populateDeptNos(){
		System.out.println("EmployeeController.populateDeptNos()");
		//use service
			return service.fetchAllDeptNos();
	}
	
	

}

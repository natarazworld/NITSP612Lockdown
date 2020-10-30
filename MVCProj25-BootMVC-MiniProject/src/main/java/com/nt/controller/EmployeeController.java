package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private  IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator validator;
	
	
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
		//return lvn
		return "show_report";
	}
	
	@GetMapping("/saveEmp.htm")  //for initial request
	public String  showEmpRegistrationPage(@ModelAttribute("empFrm") Employee emp) {
		System.out.println("EmployeeController.showEmpRegistrationPage()");
		return "employee_register";
	}
	
	@PostMapping("/saveEmp.htm")  //for post back request
	public  String  saveEmployee(RedirectAttributes redirect, 
			                                         @ModelAttribute("empFrm") Employee emp,
			                                         BindingResult errors){
		System.out.println("EmployeeController.saveEmployee()");
		EmployeeDTO dto=null;
		String result=null;
		List<EmployeeDTO> listDTO=null;
	
		System.out.println("vflag ::"+emp.getVflag());
		if(emp.getVflag().equalsIgnoreCase("no")) {  //enable server side form validations only when client form   validations are not done
		   //peform form validations
		   if(validator.supports(emp.getClass()))
			    validator.validate(emp, errors);
		}
		
		
		//b.logic errors or application logic errors
		if(emp.getJob().equalsIgnoreCase("netaji") || emp.getJob().equalsIgnoreCase("actor"))
			errors.rejectValue("job", "blocked.jobs");

		
		 //if form validation errors are there.. launch form page
		if(errors.hasErrors())
			  return "employee_register";
		
		//convert model to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(emp,dto);
		//use Service
		result=service.registerEmployee(dto);
		//keep in results  in flash attribute (special Map object)
		  redirect.addFlashAttribute("resultMsg",result);
		//return lvn
		return "redirect:list_emps.htm";
		
	}
	
	@GetMapping("/deleteEmp.htm")
	public   String   removeEmployee(RedirectAttributes redirect,@RequestParam int eno) {
		String result=null;
		 //use service
		result=service.removeEmpByNo(eno);
		//add result to flash attribute
		 redirect.addFlashAttribute("resultMsg",result);
		return "redirect:list_emps.htm";
	}
	
	@GetMapping("/editEmp.htm")
	public String  showEditFormPage(@ModelAttribute Employee emp,
			                                                 @RequestParam int empNo) {
		EmployeeDTO dto=null;
		//use service
		dto=service.fetchEmpByNo(empNo);
		//convert dto to model
		 BeanUtils.copyProperties(dto, emp);
		//return lvn
		return "employee_edit";
	}
	
	
	@PostMapping("/editEmp.htm")
	public String  updateEmployee(
			                                       RedirectAttributes redirect,
			                                       @ModelAttribute Employee employee,
			                                                 BindingResult errors) {
		System.out.println(employee.toString());
		EmployeeDTO dto=null;
		String result=null;
	System.out.println("vflag ::"+employee.getVflag());
	if(employee.getVflag().equalsIgnoreCase("no")) {  //enable server side form validations only when client form   validations are not done	
		//peform form validations
		if(validator.supports(employee.getClass()))
			validator.validate(employee, errors);
	}//if
		
		//b.logic error or application logic errors
			if(employee.getJob().equalsIgnoreCase("netaji") || employee.getJob().equalsIgnoreCase("actor"))
					errors.rejectValue("job", "blocked.jobs");

		
		 //if form validation errors are there.. launch form page
		if(errors.hasErrors())
			  return "employee_edit";
		
		
		
		//convert mode to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(employee,dto);
		//use service
		result=service.modifyEmployeeByNo(dto);
		//add to flash attrbute
		redirect.addFlashAttribute("resultMsg",result);
		//perform redirection
		return "redirect:list_emps.htm";
	}
	
	
	
	@ModelAttribute("deptsInfo")  //constructing reference data/initial for select box
	public List<Integer>  populateDeptNos(){
		System.out.println("EmployeeController.populateDeptNos()");
		//use service
			return service.fetchAllDeptNos();
	}
	
	

}

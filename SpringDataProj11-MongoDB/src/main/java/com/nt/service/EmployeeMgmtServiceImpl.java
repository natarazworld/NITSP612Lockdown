package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repo.EmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private  EmployeeRepo empRepo;

	@Override
	public String registerEmployee(Employee doc) {
	  
		return "doc saved with id ::"+ empRepo.save(doc).getEid();
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee findEmpById(int id) {
		Optional<Employee> opt=null;
		opt=empRepo.findById(id);
		return opt.get();
	}

	@Override
	public String updateEmployeeSalary(int id, float bonus) {
		Optional<Employee> opt=null;
		Employee doc=null;
		opt=empRepo.findById(id);
		if(opt.isPresent()) {
			 doc=opt.get();
			 doc.setSalary(doc.getSalary()+bonus);
			 return doc.getEid()+" salary is hiked by "+bonus +" new salary is "+empRepo.save(doc).getSalary();
		}
		else
		   return "employee not found";
	}
	
	@Override
	public String removeEmployee(int id) {
		 if(empRepo.findById(id).isPresent()) {
			  empRepo.delete(empRepo.findById(id).get());
			  return  id +" employee deleted";
		 }
		 else {
			 return "employee not found";
		 }
		 
	}

}

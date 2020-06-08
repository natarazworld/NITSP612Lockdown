package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public  class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {

		this.dao = dao;
	}

	public int fetchEmpsCount() {
		int count=0;
	  //use DAO
		count=dao.getEmpsCount();
		return count;
	}

	public String fetchEmpNameByNo(int no) {
		String name=null;
		name=dao.getEmpNameByNo(no);
		
		return name;
	}

	public Map<String, Object> fetchEmpDetailsByNo(int no) {
		Map<String,Object> map=null;
		//use dao
		map=dao.getEmpByNo(no);
		return map;
	}
	
	public List<Map<String, Object>> fetchEmpDetailsByDesgs(String desg1, String desg2) {
	    List<Map<String,Object>> listMap=null;
		//use DAO
	    listMap=dao.getEmpsByDesgs(desg1, desg2);
	  return listMap;
	}
	
	public String registerEmployee(int eno, String ename, String desg, float salary) {
		int count=0;
		//use DAO
		count=dao.insert(eno, ename, desg, salary);
		if (count==0)
			return "Registration failed";
		else
			return "Registration Succeded";
	}
	
	public String hikeEmpSalaryBySalRange(float salaryRange, float percentage) {
		int count=0;
		//use DAO
		count=dao.updateSalary(salaryRange, percentage);
		return count+" no.of Employess salary is hiked";
	}
	
	public String fireEmpsBySalaryRange(float start, float end) {
		int count=0;
	   //use DAOs
		count=dao.deleteEmployeesBySalaryRange(start, end);
		return count+" no.of employess are fired";
	}

}

package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {
	public int fetchEmpsCount();
	public  String fetchEmpNameByNo(int no);
	public  Map<String,Object>  fetchEmpDetailsByNo(int no);
	public  List<Map<String,Object>> fetchEmpDetailsByDesgs(String desg1,String desg2);
	public String registerEmployee(int eno,String ename,String desg,float salary);
    public  String hikeEmpSalaryBySalRange(float salaryRange,float percentage);
    public  String fireEmpsBySalaryRange(float start,float end);
}

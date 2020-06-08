package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
   public   int  getEmpsCount();
   public  String getEmpNameByNo(int empNo);
   public  Map<String,Object> getEmpByNo(int empNo);
   public List<Map<String,Object>> getEmpsByDesgs(String desg1,String desg2);
   public  int  insert(int eno,String ename,String desg, float salary);
   public  int  updateSalary(float salRange,float percentage);
   public  int deleteEmployeesBySalaryRange(float start,float end);
}

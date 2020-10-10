package com.nt.bo;

public class EmployeeBO {
   private  Integer empNo;
   private  String ename;
   private  String job;
   private   float sal;
   private  int deptNo;
public Integer getEmpNo() {
	return empNo;
}
public void setEmpNo(Integer empNo) {
	this.empNo = empNo;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public float getSal() {
	return sal;
}
public void setSal(float sal) {
	this.sal = sal;
}
public int getDeptNo() {
	return deptNo;
}
public void setDeptNo(int deptNo) {
	this.deptNo = deptNo;
}

@Override
public String toString() {
	return "EmployeeBO [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo=" + deptNo
			+ "]";
}



 
}

package com.nt.model;

public class Employee {
	private Integer empNo;
    private String ename;
    private String job;
    private Float sal=10000.0f;
    private Integer deptNo=10;
    private String  vflag="no";
    
    
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



	public Float getSal() {
		return sal;
	}



	public void setSal(Float sal) {
		this.sal = sal;
	}



	public Integer getDeptNo() {
		return deptNo;
	}



	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}



	public String getVflag() {
		return vflag;
	}



	public void setVflag(String vflag) {
		this.vflag = vflag;
	}



	@Override
	public String toString() {
		return "Employee [enme=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo=" + deptNo + "]";
	}
    
}

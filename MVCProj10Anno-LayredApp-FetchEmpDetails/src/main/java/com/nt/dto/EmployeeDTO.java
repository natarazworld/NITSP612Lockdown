package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private int serialNo;
	private int empNo;
	private String ename;
	private String job;
	private float sal;
	private int deptNo;
	private float grossSalary;
	private float netSalary;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
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

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public float getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [serialNo=" + serialNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal="
				+ sal + ", deptNo=" + deptNo + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
	}
	
	

}

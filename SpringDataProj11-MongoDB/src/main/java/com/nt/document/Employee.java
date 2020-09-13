package com.nt.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	@Id
	private  Integer eid;
	private  String ename;
	private  String eadd;
	private  Float  salary;
	private String company;
	private String[] oldCompanies;
	
	
	
	public String[] getOldCompanies() {
		return oldCompanies;
	}

	public void setOldCompanies(String[] oldCompanies) {
		this.oldCompanies = oldCompanies;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEadd() {
		return eadd;
	}

	public void setEadd(String eadd) {
		this.eadd = eadd;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eadd=" + eadd + ", salary=" + salary + ", company="
				+ company + ", oldCompanies=" + Arrays.toString(oldCompanies) + "]";
	}

	
	
	

}

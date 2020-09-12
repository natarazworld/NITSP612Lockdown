package com.nt.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EmployeeInfoDTO implements Serializable{
	private Integer eid;
	private String ename;
	private String eadd;
	private  LocalDateTime dob;
	private  LocalDate doj;
	private  LocalTime batchTime;
	
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
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalTime getBatchTime() {
		return batchTime;
	}
	public void setBatchTime(LocalTime batchTime) {
		this.batchTime = batchTime;
	}
	
	@Override
	public String toString() {
		return "EmployeeInfo [eid=" + eid + ", ename=" + ename + ", eadd=" + eadd + ", dob=" + dob + ", doj=" + doj
				+ ", batchTime=" + batchTime + "]";
	}
	
	
	
	

}

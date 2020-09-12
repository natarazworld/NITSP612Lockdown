package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class EmployeeInfo implements Serializable{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Type(type="int")
	private Integer eid;
	
	@Column(length = 20)
	@Type(type="string")
	private String ename;

	@Column(length = 20)
	@Type(type="string")
	private String eadd;
	
	//@Temporal not required for java8 date time api
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

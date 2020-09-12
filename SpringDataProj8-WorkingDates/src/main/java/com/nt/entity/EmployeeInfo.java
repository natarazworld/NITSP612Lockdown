package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Temporal(value = TemporalType.TIMESTAMP)  //default is TIMESTAMP
	private  Date dob;
	@Temporal(value = TemporalType.DATE)
	private  Date doj;
	@Temporal(value = TemporalType.TIME) // not applicalbe for oracle ,So for mysql
	//@Temporal(value = TemporalType.TIMESTAMP) 
	private  Date batchTime;
	
	
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getBatchTime() {
		return batchTime;
	}
	public void setBatchTime(Date batchTime) {
		this.batchTime = batchTime;
	}
	
	@Override
	public String toString() {
		return "EmployeeInfo [eid=" + eid + ", ename=" + ename + ", eadd=" + eadd + ", dob=" + dob + ", doj=" + doj
				+ ", batchTime=" + batchTime + "]";
	}
	
	
	
	
	

}

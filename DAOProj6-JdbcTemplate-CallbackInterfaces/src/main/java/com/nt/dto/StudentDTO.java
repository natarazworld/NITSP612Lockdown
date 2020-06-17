package com.nt.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable{
	private int srNo;
	private int sno;
	private String sname;
	private String sadd;
	private  int avg;
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [srNo=" + srNo + ", sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avg=" + avg
				+ "]";
	}
	
	
	
	

}

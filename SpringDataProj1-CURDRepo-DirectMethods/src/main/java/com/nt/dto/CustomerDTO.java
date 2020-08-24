package com.nt.dto;

import java.io.Serializable;


public class CustomerDTO  implements Serializable {
	private Integer cno;
	private String cname;
	private String cadd;
	private double billAmt;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDTO(int cno) {
		this.cno=cno;
		System.out.println("Customer::1-param constructor");
	}
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(double billAmt) {
		this.billAmt = billAmt;
	}
	@Override
	public String toString() {
		return "CustomerDTO [cno=" + cno + ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]";
	}
	
	
	

}

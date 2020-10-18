package com.nt.model;

public class Person {
	private String name;
	private String addrs;
	private Long mobileNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", addrs=" + addrs + ", mobileNo=" + mobileNo + "]";
	}
	
	
	

}

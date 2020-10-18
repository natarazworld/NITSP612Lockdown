package com.nt.model;

import java.util.Arrays;
import java.util.Date;


public class Person {
  private String name;
  private String addrs;
  private Long mobileNo;
  private  String gender="female";
  private String[] hobies=new String[] {"reading","roaming"};
  private String qlfy="BE";
  private  String[] colors=new String[] {"red","white"};
  private  Date dob;
  private  Date doj=new Date();
  private  Float salary;
public Float getSalary() {
	return salary;
}
public void setSalary(Float salary) {
	this.salary = salary;
}
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String[] getHobies() {
	return hobies;
}
public void setHobies(String[] hobies) {
	this.hobies = hobies;
}
public String getQlfy() {
	return qlfy;
}
public void setQlfy(String qlfy) {
	this.qlfy = qlfy;
}
public String[] getColors() {
	return colors;
}
public void setColors(String[] colors) {
	this.colors = colors;
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
@Override
public String toString() {
	return "Person [name=" + name + ", addrs=" + addrs + ", mobileNo=" + mobileNo + ", gender=" + gender + ", hobies="
			+ Arrays.toString(hobies) + ", qlfy=" + qlfy + ", colors=" + Arrays.toString(colors) + ", dob=" + dob
			+ ", doj=" + doj + "]";
} 
  
  
  
  
}

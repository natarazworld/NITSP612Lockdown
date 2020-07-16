package com.nt.dto;

import java.io.Serializable;
//@Data ---> if lombok is configured..


public class ProductDTO implements Serializable {
	private int pid;
	private String pname;
	private Float price;
	private Float qty;
	
     
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public Float getQty() {
		return qty;
	}


	public void setQty(Float qty) {
		this.qty = qty;
	}


	@Override
	public String toString() {
		return "ProductDTO [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}

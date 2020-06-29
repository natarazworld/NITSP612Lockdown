package com.nt.dto;

import java.io.Serializable;

public class BankAccountDTO implements Serializable{
	private int acno;
	private String holderName;
	private float balance;
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BankAccountDTO [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + "]";
	}
	
	
	
	
	
	

}

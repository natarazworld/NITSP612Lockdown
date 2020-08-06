package com.nt.dao;

public interface BankDAO {
	
	public int withdraw(long acno,float amt);
	public int deposite(long acno,float amt);
	

}

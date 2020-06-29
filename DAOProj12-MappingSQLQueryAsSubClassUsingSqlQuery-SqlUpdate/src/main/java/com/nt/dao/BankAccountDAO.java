package com.nt.dao;

import java.util.List;

import com.nt.bo.BankAccountBO;

public interface BankAccountDAO {
	public BankAccountBO  getBankAccountByNo(int no);
	public  List<BankAccountBO>  getBankAccountByBalanceRanage(float start,float end);
	public int  updateBalnaceByBalanceRanage(float start,float end,float amount);

}

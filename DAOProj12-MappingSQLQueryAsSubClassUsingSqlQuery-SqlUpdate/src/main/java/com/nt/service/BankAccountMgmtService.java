package com.nt.service;

import java.util.List;

import com.nt.dto.BankAccountDTO;

public interface BankAccountMgmtService {
	
	public  BankAccountDTO  fetchAccountDetailsByNo(int no);
	public  List<BankAccountDTO> fetchAccountDetailsByBalanceRange(float start,float end);
    public  String  addBounsToAccountsByBalanceRange(float start,float end,float amount);
}

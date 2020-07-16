package com.nt.service;

import com.nt.dao.BankDAO;

public class BankMgmtServiceImpl implements BankMgmtService {
	
	private BankDAO dao;

	public BankMgmtServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String withdrawMoney(int acno, float amt) {
		int count=0;
		//use dAO
		count=dao.withdraw(acno, amt);
		if(count==0)
		   return "Money not withdrawn";
		else
			return amt+"Money is  withdrawn from "+acno+"  account";
	}

	@Override
	public String depositeMoney(int acno, float amt) {
		int count=0;
		//use dAO
		count=dao.deposite(acno, amt);
		return (count==0)?"Money not Deposited":"Money is  deposited from "+acno+"  account";
	}

}

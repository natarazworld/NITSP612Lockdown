package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements BankMgmtService {
	@Autowired
	private BankDAO dao;

	

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

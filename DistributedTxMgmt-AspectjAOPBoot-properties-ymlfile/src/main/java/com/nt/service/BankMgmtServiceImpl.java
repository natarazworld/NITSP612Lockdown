package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DepositeDAO;
import com.nt.dao.WithdrawDAO;

@Service("bankService")
public final class BankMgmtServiceImpl implements BankMgmtService {
	@Autowired
	private WithdrawDAO wDAO;
	@Autowired
	private  DepositeDAO dDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "jtaTxMgmr")
	public String transferMoney(long srcAcno, long destAcno, float amt) {
		int count1=0,count2=0;
		count1=wDAO.withdraw(srcAcno, amt);
		count2=dDAO.deposite(destAcno, amt);
		if(count1==0 || count2==0) {
			 throw new IllegalArgumentException("Problem in money transffering ");
		}
		return amt+" amount of money transffered from "+srcAcno+" to  "+destAcno;
	}

}

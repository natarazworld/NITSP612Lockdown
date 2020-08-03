package com.nt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;

@Service("bankService")
public final class BankMgmtServiceImpl implements BankMgmtService {
	  @Autowired
	  private  BankDAO  dao;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED,timeout =10,rollbackFor = IllegalAccessException.class )
	//@Transactional(propagation = Propagation.REQUIRED,timeout =10,rollbackForClassName ="java.lang.IllegalAccessExeception")
	//@Transactional(propagation = Propagation.REQUIRED,timeout =10,noRollbackFor = IllegalArgumentException.class)
	//@Transactional(propagation = Propagation.REQUIRED,transactionManager = "dsTxMgmr")
	//@Transactional(propagation = Propagation.REQUIRED)
	//@Transactional(propagation = Propagation.SUPPORTS)
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	//@Transactional(propagation = Propagation.MANDATORY)
	//@Transactional(propagation = Propagation.NEVER)
	@Transactional
	public String transferMoney(long srcAcno, long destAcno, float amt) throws IllegalAccessException {
		int count1=0,count2=0;
		//use DAO
		count1=dao.withdraw(srcAcno, amt);
		/*	try {
				Thread.sleep(20000);
			}
			catch (Exception e) {
				e.printStackTrace();
			}*/
		count2=dao.deposite(destAcno, amt);
		if(count1==0 || count2==0)
			//throw new IllegalArgumentException("Problem in money trannsffering");
			throw new IllegalArgumentException("Problem in moeney transfering");
		else
		return  amt+" amount of money  transffered  from "+srcAcno+"  to  "+destAcno;
	}

}

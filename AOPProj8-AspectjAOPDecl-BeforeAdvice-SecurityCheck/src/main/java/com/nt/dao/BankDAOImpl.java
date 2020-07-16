package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
    private JdbcTemplate jt;
    
   
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int withdraw(int acno, float amt) {
	  int count=0;
	  count=jt.update(WITHDRAW_QUERY,amt,acno);
		return count;
	}

	@Override
	public int deposite(int acno, float amt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY, amt,acno);
		return count;
	}

}

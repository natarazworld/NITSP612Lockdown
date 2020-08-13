package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dDAO")
public class DepositeDAOImpl implements DepositeDAO {
	private static final String  DEPOSITE_QUERY="UPDATE DTX_ACCOUNT  SET BALANCE=BALANCE+? WHERE ACNO=?";
	@Autowired
	@Qualifier("pgJt")
	private JdbcTemplate jt;

	@Override
	public int deposite(long acno, float amt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY, amt,acno);
		return count;
	}

}

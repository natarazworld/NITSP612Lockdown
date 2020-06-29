package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;
@Repository("bankDAO")
public class BankAccountDAOImpl implements BankAccountDAO {
	private static final String GET_BANK_ACCOUNT_DETAILS_BY_ACNO="SELECT ACNO,HOLDERNAME,BALANCE FROM BANKACCOUNT WHERE ACNO=?";
	private static final String GET_BANK_ACCOUNT_DETAILS_BY_BALNCE_RANGE="SELECT ACNO,HOLDERNAME,BALANCE FROM BANKACCOUNT WHERE BALANCE>=? AND BALANCE<=?";
	private static final String UPDATE_BALANCE_BY_BALNACE_RANGE="UPDATE BANKACCOUNT SET BALANCE=BALANCE+:amt  WHERE BALANCE BETWEEN :start AND :end";
	
	
	private BankAccountSelector1 selector1;
	private BankAccountSelector2  selector2;
	private BankUpdator1  updator1;
	
	@Autowired
	public  BankAccountDAOImpl(DataSource ds) {
		System.out.println("BankAccountDAOImpl:: 1-param constructor");
		selector1=new BankAccountSelector1(ds,GET_BANK_ACCOUNT_DETAILS_BY_ACNO);
		selector2=new BankAccountSelector2(ds,GET_BANK_ACCOUNT_DETAILS_BY_BALNCE_RANGE);
		updator1=new BankUpdator1(ds, UPDATE_BALANCE_BY_BALNACE_RANGE);
	}

	@Override
	public BankAccountBO getBankAccountByNo(int no) {
		BankAccountBO bo=null;
		//use inner cum sub class object
		bo=selector1.findObject(no);
		return bo;
	}
	
	@Override
	public List<BankAccountBO> getBankAccountByBalanceRanage(float start, float end) {
		List<BankAccountBO> listBO=null;
		listBO=selector2.execute(start,end);
		return listBO;
	}
	
	@Override
	public int updateBalnaceByBalanceRanage(float start, float end,float amount) {
		int count=0;
		Map<String,Object > paramMap=null;
		paramMap=new HashMap();
		paramMap.put("amt",amount);
		paramMap.put("start", start);
		paramMap.put("end",end);
		count=updator1.updateByNamedParam(paramMap);
		return count;
	}
	
	//..................inner class1.......................................................
	private static class BankAccountSelector1 extends MappingSqlQuery<BankAccountBO>{

		 public BankAccountSelector1(DataSource ds, String query ) {
			 super(ds,query);
			 System.out.println("BankAccountDAOImpl.BankAccountSelector1.2-param constructor");
                super.declareParameter(new SqlParameter(Types.INTEGER));
                super.compile();
		}
		
		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankAccountDAOImpl.BankAccountSelector1.mapRow(-,-)");
			 BankAccountBO bo=null;
			//copy ResultSet object record to BO class object
			 bo=new BankAccountBO();
			 bo.setAcno(rs.getInt(1));
			 bo.setHolderName(rs.getString(2));
			 bo.setBalance(rs.getFloat(3));
			return bo;
		}//maprow(-,-)
		
	}// inner class1
  // -------------------------------------inner class2 ---------------------
	private static class BankAccountSelector2 extends MappingSqlQuery<BankAccountBO>{
		
		public BankAccountSelector2(DataSource ds,String query) {
			super(ds,query);
			System.out.println("BankAccountDAOImpl.BankAccountSelector2.2-param constructor");
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.compile();
		}

	@Override
	public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("BankAccountDAOImpl.BankAccountSelector2.mapRow(-,-)");
		 BankAccountBO bo=null;
		//copy ResultSet object record to BO class object
		 bo=new BankAccountBO();
		 bo.setAcno(rs.getInt(1));
		 bo.setHolderName(rs.getString(2));
		 bo.setBalance(rs.getFloat(3));
		return bo;
	}
		
	}//inner class
	
	//-------------------inner class3------------------------------------------------------
	private static class BankUpdator1 extends SqlUpdate{
		
		  public BankUpdator1(DataSource ds,String query) {
			  super(ds,query);
			  System.out.println("BankAccountDAOImpl.BankUpdator1: 2-param construtor");
			  super.declareParameter(new SqlParameter(Types.FLOAT));
			  super.declareParameter(new SqlParameter(Types.FLOAT));
			  super.declareParameter(new SqlParameter(Types.FLOAT));
			  super.compile();
		  }
	}
	

}//outer class

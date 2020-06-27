package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDAO")
public class AuthenticationDAOImpl implements AuthenitcationDAO {
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public Map<String, Object> validate(String user, String pwd) {
		
		Map<String,Object> outParams=null;
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//execute PL/SQL procedure
		 outParams=sjc.execute(user,pwd);
		 
		return outParams;
	}

}

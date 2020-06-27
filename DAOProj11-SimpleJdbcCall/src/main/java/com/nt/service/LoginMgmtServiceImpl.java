package com.nt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.AuthenitcationDAO;

@Service("loginService")
public class LoginMgmtServiceImpl implements LoginMgmtService {
	@Autowired
	private AuthenitcationDAO dao;

	@Override
	public String signIn(String username, String password) {
		Map<String,Object> outParams=null;
		String output=null;
		//use dAO
		outParams=dao.validate(username, password);
		output=(String)outParams.get("RESULT");
		return output;
	}

}

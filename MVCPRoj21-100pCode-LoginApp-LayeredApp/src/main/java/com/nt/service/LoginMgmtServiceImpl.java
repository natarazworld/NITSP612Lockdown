package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.UserBO;
import com.nt.dao.ILoginDAO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {
	@Autowired
	private  ILoginDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String login(UserDTO dto) {
		UserBO bo=null;
		String result=null;
	    //convert  dto to bo
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
		//use dAO
		result=dao.authenticate(bo);
		return result;
	}

}

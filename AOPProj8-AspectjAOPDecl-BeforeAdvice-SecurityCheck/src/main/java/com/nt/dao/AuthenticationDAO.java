package com.nt.dao;

import com.nt.bo.UserDetailsBO;

public interface AuthenticationDAO {
		
	public  int validate(UserDetailsBO bo);
	

}

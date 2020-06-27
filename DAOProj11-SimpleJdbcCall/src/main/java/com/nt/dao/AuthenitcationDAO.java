package com.nt.dao;

import java.util.Map;

public interface AuthenitcationDAO {
	
	public Map<String,Object> validate(String user,String pwd);
	

}

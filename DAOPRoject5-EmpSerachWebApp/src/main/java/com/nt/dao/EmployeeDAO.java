package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	
	public  List<Map<String,Object>>  getEmpsByDesgs(String cond);

}

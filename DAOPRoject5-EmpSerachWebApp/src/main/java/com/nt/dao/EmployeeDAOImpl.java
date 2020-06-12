package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jt;

	  // In this example we can not work with dynamic queries... no.of inputs
	// will be decided based on no.of desgs that are selected from list box
	@Override
	public List<Map<String, Object>> getEmpsByDesgs(String cond) {
		List<Map<String,Object>> listMap=null;
		listMap=jt.queryForList("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN "+cond +" ORDER BY JOB",new Object[] {});
		return listMap;
	}

}

package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.DepartmentBO;

@Repository("deptDAO")
public class DepartmentDAOImpl implements DepartmentDAO {
	@Autowired
	private SimpleJdbcInsert sji;

	@Override
	public int insert(DepartmentBO bo) {
		int count=0;
		BeanPropertySqlParameterSource bpsps=null;
		//prepare BeanPropertySqlParameterSource object
		bpsps=new BeanPropertySqlParameterSource(bo);
		//set db table name
		sji.setTableName("DEPT");
		//execute the query
		count=sji.execute(bpsps);
		return count;
	}

}

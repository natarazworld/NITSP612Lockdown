package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  GET_ALL_EMPLOYEES="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO>listBO=null;
		listBO=jt.query(GET_ALL_EMPLOYEES,new EmployeeRowMapper());
		return listBO;
	}
	
	private class EmployeeRowMapper implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			  List<EmployeeBO> listBO=new ArrayList();
			  //copy  RS records to ListBO
			  while(rs.next()) {
				  //copy each record to One BO class obj
				  EmployeeBO bo=new EmployeeBO();
				  bo.setEmpNo(rs.getInt(1));
				  bo.setEname(rs.getString(2));
				  bo.setJob(rs.getString(3));
				  bo.setSal(rs.getFloat(4));
				  bo.setDeptNo(rs.getInt(5));
				  listBO.add(bo);
			  }//while
			return listBO;
		}//extractData(-)
	}//inner class
	
}//DAO class

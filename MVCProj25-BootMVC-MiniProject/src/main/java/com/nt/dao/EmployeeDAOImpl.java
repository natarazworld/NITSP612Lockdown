package com.nt.dao;

import java.math.BigDecimal;

//CREATE SEQUENCE  "SYSTEM"."ENO_SEQ"  MINVALUE 1 MAXVALUE 10000 INCREMENT BY 1 START WITH 46 CACHE 20 NOORDER  NOCYCLE ;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  GET_ALL_EMPLOYEES="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String  INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(ENO_SEQ1.NEXTVAL,?,?,?,?)";
	private static final String  GET_ALL_DEPTNOS="SELECT DISTINCT DEPTNO FROM EMP  WHERE DEPTNO IS NOT NULL";
	private static final String  DELETE_EMP_BY_NO="DELETE  FROM EMP WHERE EMPNO=?";
	private static final String  GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO  FROM EMP WHERE EMPNO=?";
	private static final String  UPDATE_EMP_BY_NO="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=?   WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO>listBO=null;
		listBO=jt.query(GET_ALL_EMPLOYEES,new ListEmployeeRowMapper());
		return listBO;
	}
	
	private class ListEmployeeRowMapper implements ResultSetExtractor<List<EmployeeBO>>{

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

	@Override
	public int insertEmployee(EmployeeBO bo) {
		int count=0;
		count=jt.update(INSERT_EMPLOYEE,
				                      bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo());
		return count;
	}
	
	@Override
	public List<Integer> getAllDeptNos() {
		List<Integer> deptNosList=new ArrayList();
		List<Map<String, Object>> listMap=null;
	    //exdcute query
		listMap=jt.queryForList(GET_ALL_DEPTNOS);
		listMap.forEach(e->{
			deptNosList.add((Integer) ((BigDecimal)e.get("deptNo")).intValue());
		});
		return deptNosList;
	}

	@Override
	public int deleteEmpById(int id) {
	     int count=0;
	     count=jt.update(DELETE_EMP_BY_NO,id);
		return count;
	}

	/*@Override    //  normal class  based RowMapper Implementation
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_NO,new EmployeeRowMapper() ,id);
		return bo;
	}
	
	//inner class 
	private static  class EmployeeRowMapper  implements RowMapper<EmployeeBO>{
	
		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo=null;
			bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setDeptNo(rs.getInt(5));
			return bo;
		} //method
	}//inner class
	*/	
	
	/*@Override   //using  lamda expression based anonyomous inner class for RowMapper Impl
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo1=null;
		bo1=jt.queryForObject(GET_EMP_BY_NO,(rs,rowNum)->{
			EmployeeBO bo=null;
			bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setDeptNo(rs.getInt(5));
			return bo;
		},id);
		return bo1;
	}//method
	*/	
	
	@Override   //using  Readymade impl class of RowMapper that is  BeanPropertyRowMapper 
	                       //(here cols names  BO class property names must match)
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_NO,new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class) ,id);
		return bo;
	}//method
	
	@Override
	public int updateEmployee(EmployeeBO bo) {
		System.out.println(bo);
		int count=0;
		count=jt.update(UPDATE_EMP_BY_NO, bo.getEname(),
				                                                            bo.getJob(),
				                                                            bo.getSal(),
				                                                            bo.getDeptNo(),
				                                                            bo.getEmpNo());
		return count;
	}
	
	
	
}//DAO class

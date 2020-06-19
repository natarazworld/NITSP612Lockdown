package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl1 implements StudentDAO {
	private static final  String GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SNO=?";
	private static final  String GET_STUDENTS_BY_ADDRS="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SADD=?";
	private static final  String GET_STUDENTS_BY_CITY="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SADD=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentById(int no) {
		StudentBO bo=null;
		bo=jt.queryForObject(GET_STUDENT_BY_NO,
				             new RowMapper<StudentBO>() {
								@Override
								public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
									StudentBO bo=null;
									//copy ResultSet object records  BO class obbj
									bo=new StudentBO();
									bo.setSno(rs.getInt(1));
									bo.setSname(rs.getString(2));
									bo.setSadd(rs.getString(3));
									bo.setAvg(rs.getFloat(4));
									return bo;
								}//mapRow(-)
			                   }//anonymous inner class
		                         ,
				             no);
		
		return bo;
	}//method

	@Override
	public List<StudentBO> getStudentsByAddrs(String addrs) {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_STUDENTS_BY_ADDRS,
				        new ResultSetExtractor<List<StudentBO>>() {
							@Override
							public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
							  System.out.println(
									"StudentDAOImpl1.getStudentsByAddrs(...).new ResultSetExtractor() {...}.extractData()");
								List<StudentBO> listBO=null;
							  StudentBO bo=null;
							  listBO=new ArrayList();
							  while(rs.next()) {
								  //copy ResultSet obj records to listBO objects
								  bo=new StudentBO();
								  bo.setSno(rs.getInt(1));
								  bo.setSname(rs.getString(2));
								  bo.setSadd(rs.getString(3));
								  bo.setAvg(rs.getFloat(4));
								  listBO.add(bo);
							  }
								
								return listBO;
							} //extractData(-)
			       },//anonymous inner class
				   addrs);
		
		return listBO;
	}//method

	@Override
	public List<StudentBO> getStudentsByCity(String city) {
		List<StudentBO> listBO=new ArrayList();
	
		jt.query(GET_STUDENTS_BY_CITY,
				 new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
					   System.out.println(
							"StudentDAOImpl1.getStudentsByCity(...).new RowCallbackHandler() {...}.processRow()");
						StudentBO bo=null;
						bo=new StudentBO();
						bo.setSno(rs.getInt(1));
						bo.setSname(rs.getString(2));
						bo.setSadd(rs.getString(3));
						bo.setAvg(rs.getFloat(4));
					    listBO.add(bo);			
					}//processRow
		},
	     city);
				
		return listBO;
	}//method

}//outer class

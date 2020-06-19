package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl3 implements StudentDAO {
	private static final  String GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SNO=?";
	private static final  String GET_STUDENTS_BY_ADDRS="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SADD=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentById(int no) {
		System.out.println("1122");
		StudentBO bo1=null;
		bo1=jt.queryForObject(GET_STUDENT_BY_NO,new BeanPropertyRowMapper<StudentBO>(StudentBO.class),no);
		
		return bo1;
	}//method

	@Override
	public List<StudentBO> getStudentsByAddrs(String addrs) {
		List<StudentBO> listBO=null;
		listBO=  jt.query(GET_STUDENTS_BY_ADDRS,
				        new RowMapperResultSetExtractor<StudentBO>(new BeanPropertyRowMapper<StudentBO>(StudentBO.class))
				        ,
				        addrs);
		return listBO;
	}

	@Override
	public List<StudentBO> getStudentsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}//clas

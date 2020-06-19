package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl2 implements StudentDAO {
	private static final  String GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SNO=?";
	private static final  String GET_STUDENTS_BY_ADDRS="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SADD=?";
	private static final  String GET_STUDENTS_BY_CITY="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SADD=?";
	
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentById(int no) {
		StudentBO bo1=null;
		bo1=jt.queryForObject(GET_STUDENT_BY_NO,
				              (rs,index)->{
									StudentBO bo=null;
									//copy ResultSet object records  BO class obbj
									bo=new StudentBO();
									bo.setSno(rs.getInt(1));
									bo.setSname(rs.getString(2));
									bo.setSadd(rs.getString(3));
									bo.setAvg(rs.getFloat(4));
									return bo;
								}//mapRow(-)
			                     ,
				             no);
		
		return bo1;
	}//method

	@Override
	public List<StudentBO> getStudentsByAddrs(String addrs) {
		List<StudentBO> listBO1=null;
		listBO1=jt.query(GET_STUDENTS_BY_ADDRS,
				        rs->{
				        	 System.out.println("StudentDAOImpl2.getStudentsByAddrs()-->LAMDA --extractData(-)");
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
				        }, //LAMBDA based anonymous inner class
				        addrs);
		return listBO1;
	}//method

	@Override
	public List<StudentBO> getStudentsByCity(String city) {
		List<StudentBO> listBO=new ArrayList();
		jt.query(GET_STUDENTS_BY_CITY,
				rs->{
					System.out.println("StudentDAOImpl2.getStudentsByCity()--LAMDA --processRow(-)");
					StudentBO bo=null;
					bo=new StudentBO();
					bo.setSno(rs.getInt(1));
					bo.setSname(rs.getString(2));
					bo.setSadd(rs.getString(3));
					bo.setAvg(rs.getFloat(4));
					listBO.add(bo);
				},
				city);
		return listBO;
	}//method
	
	

}//class

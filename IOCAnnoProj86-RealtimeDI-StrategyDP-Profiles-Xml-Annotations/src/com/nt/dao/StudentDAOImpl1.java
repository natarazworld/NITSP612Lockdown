package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("studDAO")
@Profile({"uat","prod"})
public final class StudentDAOImpl1 implements StudentDAO {
	private static final String 
	INSERT_STUDENT_QUERY="INSERT INTO SPRING_LAYERED_STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?,?,?)";
	@Autowired		
	private DataSource ds;
	
	

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		System.out.println("ds class ::"+ds.getClass());
		//get Pooled JDBC con object  using the injected DataSource object
		con=ds.getConnection();
		//create JDBC PreparedStatement object having preCompiled SQL Query
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		//set values to query param by gathering  BO class object
		ps.setString(1,bo.getSname());
		ps.setString(2,bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		//execute the pre-compiled SQL Query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}

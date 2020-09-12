package com.nt.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("custService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
    private EntityManager manager;
	
	@Override
	public void getEmpDetails(int no) {
		   //get Session
		  Session ses=manager.unwrap(Session.class);
		  
		 float sal=ses.doReturningWork(new ReturningWork<Float>() {
				public Float execute(Connection con) throws SQLException {
					//create CallableStatement obj
					CallableStatement cs=con.prepareCall("{?= call FX_GET_EMP_DETAILS_BY_DESG(?,?,?,?)}");
					//register Return, OUT params with JDBC types
					cs.registerOutParameter(1,java.sql.Types.FLOAT );
					cs.registerOutParameter(3,java.sql.Types.VARCHAR );
					cs.registerOutParameter(4,java.sql.Types.VARCHAR );
					cs.registerOutParameter(5,java.sql.Types.INTEGER );
					//set value to IN param
					cs.setInt(2,no);
					//call PL/SQL function
					cs.execute();
					//gather results from OUT PARAMS and RETURN PARAM
					System.out.println("emp desg::"+cs.getString(3));
					System.out.println("emp name::"+cs.getString(4));
					System.out.println("deptNo::"+cs.getInt(5));
					return cs.getFloat(1);
				}//execute(-)

			}//anonyomous inner class
			 ); //method call
				System.out.println("emp salary ::"+sal); 
	}
}

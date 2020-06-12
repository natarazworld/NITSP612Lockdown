package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
public class DaoProj4JdbcTemplateDirectMethodsSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//get Application Context
		ctx=SpringApplication.run(DaoProj4JdbcTemplateDirectMethodsSpringBootApplication.class, args);
	    //get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		
		//invoke b.methods
		try {
			System.out.println("Emps count ::"+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("........................");
		try {
			System.out.println("Emp name ::"+service.fetchEmpNameByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class

package com.nt;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
import com.nt.service.CustomerService;


@SpringBootApplication
public class SpringDataProj7CallingFunctions2 {
	
	
	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerService service=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj7CallingFunctions2.class, args);
		//get Service class object
		service=ctx.getBean("custService",CustomerService.class);
		service.getEmpDetails(7900);
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

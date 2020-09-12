package com.nt;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj7CallingProcedures {
	
	
	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerRepo custRepo=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj7CallingProcedures.class, args);
		//get Bean class object
		custRepo=ctx.getBean(CustomerRepo.class);
		//invoke methods
		/*int count=custRepo.fetchCustomersCountByAddrs("hyd");
		System.out.println("hyd coustomer count::"+count);
		*/
		/*int count=custRepo.GET_CUSTOMERS_COUNT_BY_ADDRS("hyd");
		System.out.println("hyd coustomer count::"+count);*/
		
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

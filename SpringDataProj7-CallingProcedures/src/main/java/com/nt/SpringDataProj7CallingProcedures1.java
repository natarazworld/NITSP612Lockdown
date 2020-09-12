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
public class SpringDataProj7CallingProcedures1 {
	
	
	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerRepo custRepo=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj7CallingProcedures1.class, args);
		/*//get EntityManager object  for Mysql PL/SQL procedure
		EntityManager manager=ctx.getBean(EntityManager.class);
		//create StoredProcedureQuery object
		StoredProcedureQuery procedure=manager.createStoredProcedureQuery("GET_CUSTOMERS_COUNT_BY_ADDRS");
		//register params
		procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
		//set value to in Params
		procedure.setParameter(1,"hyd");
		//get results from out param
		   int count=(int)procedure.getOutputParameterValue(2);
		   System.out.println("hyd customers count::"+count);*/
		
		/*//get EntityManager object  for Oracle PL/SQL procedure (Entity Query)
		EntityManager manager=ctx.getBean(EntityManager.class);
		// Create StoredProcedure Query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("GET_CUSTOMERS_BY_ADDRS",Customer.class);
		//register IN param out params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
		//set value to in Params
		query.setParameter(1,"hyd");
		//get results from out param
		List<Customer> list=query.getResultList();
		list.forEach(System.out::println);*/
		
		/*//get EntityManager object  for Oracle PL/SQL procedure (SCALAR Query)
				EntityManager manager=ctx.getBean(EntityManager.class);
		// Create StoredProcedure Query object
			StoredProcedureQuery query=manager.createStoredProcedureQuery("FETCH_CUSTOMERDETAILS_BY_ADDRS");
		//register IN, OUT params	
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
			//set value IN param
			query.setParameter(1,"hyd");
		//gather results by calling PL/SQL procedure
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					 System.out.print(val+"  ");
				}
				System.out.println();
			});*/
		
		//get EntityManager object  for Oracle PL/SQL procedure (SCALAR Query)
		EntityManager manager=ctx.getBean(EntityManager.class);
		// Create StoredProcedure Query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_AUTHENTICATION1");
		//register IN, OUT params	
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//set IN param values
		 query.setParameter(1,"raja");
		 query.setParameter(2,"rani1");
		 //get reuslt from OUT param by calling PL/SQL procedure
		 String result=(String)query.getOutputParameterValue(3);
		System.out.println("result::"+result);
		
		  //close entity manager
		   manager.close();
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

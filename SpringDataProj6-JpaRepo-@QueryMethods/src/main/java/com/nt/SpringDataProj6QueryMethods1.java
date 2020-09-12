package com.nt;


import java.util.Arrays;
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
public class SpringDataProj6QueryMethods1 {
	
	
	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerRepo custRepo=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj6QueryMethods.class, args);
		//get Bean class object
		//custRepo=ctx.getBean(CustomerRepo.class);
		//invoke methods
		 //custRepo.getAllCustomers().forEach(System.out::println);
		//custRepo.getCustomersByCity("hyd").forEach(System.out::println);
		//custRepo.getCustomersByBillAmtRange(8000,4000).forEach(System.out::println);
		//custRepo.getCustomersByCityNames("hyd","delhi", "vizag").forEach(System.out::println);
		// custRepo.getCustomerByName("raja").forEach(System.out::println);
		//custRepo.getCustomersByCnoRange(1, 3).forEach(System.out::println);
		/*custRepo.getDataValuesByCity("hyd").forEach(row->{
			//System.out.println(row[0]+"  "+row[1]);
			for(Object val:row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});*/
		
		//custRepo.getBillAmtByCities("hyd", "delhi").forEach(System.out::println);
		//System.out.println(custRepo.getCustomerByCname("raja"));
		/*Object data=custRepo.getDataValuesByCname("raja");
		 Object data1[]=(Object[])data;
		System.out.println(data1[0]+"  "+data1[1]); */
		
		//System.out.println("max bill Amount::"+custRepo.findMaxBillAmount());
		/*Object results[]=(Object[]) custRepo.findAggregateResults();
		System.out.println("max ::"+results[0]);
		System.out.println("sum ::"+results[1]);
		System.out.println("avg ::"+results[2]);
		System.out.println("count ::"+results[3]);*/
		
		 
	/*	   double bAmt=custRepo.getBillAmtByCname("raja");
				   System.out.println("Bill Amount::"+bAmt);*/
		//--------------------non select operations ----------------------
		// System.out.println("no.of records updated::"+custRepo.modifyCustomerBillAmtByCity("hyd",200));
		 //System.out.println("no.of records deleted::"+custRepo.deleteCustomersIfCaddIsNull());
		  
		// ---------------------native SQL ----------------------------------
		//custRepo.getCustomerByAddrs("hyd").forEach(System.out::println);
		//System.out.println(custRepo.getSysDate());
		/* int count=custRepo.insertCustomer(567.88,"vizag", "suresh");
		 System.out.println( count==0?" not inserted":" inserted");*/
		
		  // call PL/SQL procedure
		// custRepo.fetchCustomerDataByAddrs("hyd").forEach(System.out::println);
		
		EntityManager manager=ctx.getBean(EntityManager.class);
	    //StoredProcedureQuery proc=manager.createStoredProcedureQuery("GET_CUSTOMERS_BY_ADDRS",Customer.class).
		StoredProcedureQuery proc=manager.createStoredProcedureQuery("GET_CUSTOMERS_BY_ADDRS");
	    proc.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	    proc.registerStoredProcedureParameter(2,Class.class,ParameterMode.REF_CURSOR);
	    proc.setParameter(1,"hyd");
	    //List<Customer> list=proc.getResultList();
	   List<Object[]>list=proc.getResultList();
	   list.forEach(row->{
		   System.out.println(Arrays.toString(row));
	   });
	   
	    
	    manager.close();
		
		//System.out.println("no.of customers::"+custRepo.fetchCustomerData1ByAddrs("hyd"));
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

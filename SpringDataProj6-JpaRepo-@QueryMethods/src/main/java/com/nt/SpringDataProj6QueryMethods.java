package com.nt;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj6QueryMethods {

	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerRepo custRepo=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj6QueryMethods.class, args);
		//get Bean class object
		custRepo=ctx.getBean(CustomerRepo.class);
		//invoke methods
		 //custRepo.getAllCustomers().forEach(System.out::println);
		//custRepo.getCustomersByCity("hyd").forEach(System.out::println);
		//custRepo.getCustomersByBillAmtRange(8000,4000).forEach(System.out::println);
		//custRepo.getCustomersByCityNames("hyd","delhi", "vizag").forEach(System.out::println);
		//custRepo.getCustomerByName("raja").forEach(System.out::println);
		//custRepo.getCustomersByCnoRange(1, 3).forEach(System.out::println);
		/*custRepo.getDataValuesByCity("hyd").forEach(row->{
			//System.out.println(row[0]+"  "+row[1]);
			for(Object val:row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});*/
		
		custRepo.getBillAmtByCities("hyd", "delhi").forEach(System.out::println);
		
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

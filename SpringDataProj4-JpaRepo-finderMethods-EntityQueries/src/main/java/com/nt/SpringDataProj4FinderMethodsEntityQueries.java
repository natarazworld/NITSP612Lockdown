package com.nt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
@SpringBootApplication
public class SpringDataProj4FinderMethodsEntityQueries {

	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerRepo custRepo=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj4FinderMethodsEntityQueries.class, args);
		//get Bean class object
		custRepo=ctx.getBean(CustomerRepo.class);
		  //call methods
		//	custRepo.findByCadd1("hyd").forEach(System.out::println);
		//	custRepo.findByCname("raja").forEach(System.out::println);
		//custRepo.findByBillAmtGreaterThan(3000).forEach(System.out::println);
		//custRepo.findByBillAmtLessThan(5000).forEach(System.out::println);
		  //custRepo.findByCnameLike("raje%").forEach(System.out::println);
		  //System.out.println("---------------------------");
		  //custRepo.findByCnameStartingWith("r").forEach(System.out::println);
	        //custRepo.findByCnameEndingWith("h").forEach(System.out::println);
		   //custRepo.findByCnameContaining("j").forEach(System.out::println);
		  //custRepo.findByCaddIsNull().forEach(System.out::println);
		     //custRepo.findByCaddIsNotNull().forEach(System.out::println);
		     custRepo.findByCaddNotNull().forEach(System.out::println);
		   
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

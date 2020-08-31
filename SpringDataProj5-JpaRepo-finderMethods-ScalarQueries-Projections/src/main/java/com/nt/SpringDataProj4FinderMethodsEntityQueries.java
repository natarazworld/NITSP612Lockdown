package com.nt;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
import com.nt.repo.CustomerRepo.ResultsView1;
import com.nt.repo.CustomerRepo.ResultsView2;
@SpringBootApplication
public class SpringDataProj4FinderMethodsEntityQueries {

	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 CustomerRepo custRepo=null;
		 //get IOC container
		ctx=SpringApplication.run(SpringDataProj4FinderMethodsEntityQueries.class, args);
		//get Bean class object
		custRepo=ctx.getBean(CustomerRepo.class);
		System.out.println(custRepo.getClass());
		//invoike method
	/*	List<ResultsView1>  view1List=custRepo.findByCadd("hyd");
		for(ResultsView1 v:view1List) {
			System.out.println(v.getCno()+"   "+v.getCname());
		}
		System.out.println("................................");
		//invoike methods
				List<ResultsView2>  view2List=custRepo.findByCnoBetween(1,4);
			/*	for(ResultsView2 v:view2List) {
					System.out.println(v.getCname()+"   "+v.getBillAmt());
				}*/
		//		view2List.forEach(v-> System.out.println(v.getCname()+"  "+v.getBillAmt()) );  */
		
		/*	List<ResultsView1>  view1List=custRepo.findByCadd("hyd",ResultsView1.class);
			for(ResultsView1 v:view1List) {
				System.out.println(v.getCno()+"   "+v.getCname());
			}
			System.out.println("................................................");
			
			List<ResultsView2>  view2List=custRepo.findByCadd("hyd",ResultsView2.class);
			for(ResultsView2 v:view2List) {
				System.out.println(v.getCname()+"  "+v.getBillAmt());
			}*/
		
		List<ResultsView1>  view1List=custRepo.findByCadd("hyd",ResultsView1.class);
		for(ResultsView1 v:view1List) {
			System.out.println(v.getCno()+"   "+v.getCname());
		}
		System.out.println("................................................");
		
		List<ResultsView2>  view2List=custRepo.findByCadd("hyd",ResultsView2.class);
		for(ResultsView2 v:view2List) {
			System.out.println(v.getCname()+"  "+v.getBillAmt());
		}
		
		
		   //close container
		   ((ConfigurableApplicationContext) ctx).close();
	}

}

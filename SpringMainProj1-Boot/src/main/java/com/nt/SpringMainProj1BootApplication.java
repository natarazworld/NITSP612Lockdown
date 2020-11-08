package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.OrderMgmtService;

@SpringBootApplication
public class SpringMainProj1BootApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringMainProj1BootApplication.class, args);
		//get Service class obejct
		OrderMgmtService service=ctx.getBean("orderService",OrderMgmtService.class);
		try {
			String result=service.purchase(new String[] {"clothes","crackers","sweets","dia"},
					                                  			new float[] {5000,4000,3000,1000},
					                                  			"nataraz@gmail.com",
					                                  			new String[] {"bgyadav0305@gmail.com","draju.raj19@gmail.com"},
					                                  			new String[] {"shubhammukhiya7@gmail.com",	"milinddhowlaghar@gmail.com","satishkushwah8269@gmail.com"});
			System.out.println(result);
    	}//try
		catch(Exception e) {
			e.printStackTrace();
		}
    //close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class

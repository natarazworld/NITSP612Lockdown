package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj1CurdRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerMgmtService service=null;
		CustomerDTO dto=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj1CurdRepoDirectMethodsApplication.class, args);
		//get Service class obj
		service=ctx.getBean("custService",CustomerMgmtService.class);
		//invoke method
		try {
			dto=new CustomerDTO();
			dto.setCname("rajesh"); dto.setCadd("hyd"); dto.setBillAmt(9000);
			System.out.println(service.registerCustomer(dto));
		}//try
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		
		
		//close  container
		((ConfigurableApplicationContext) ctx).close();
	}

}

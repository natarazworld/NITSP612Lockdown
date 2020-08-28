package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj3JpaRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		CustomerDTO dto=null;
		
		// get IOC container
		ctx = SpringApplication.run(SpringDataProj3JpaRepoDirectMethodsApplication.class, args);
				// get Service class obj
				service = ctx.getBean("custService", CustomerMgmtService.class);
				//invoke method
		/*		dto=new CustomerDTO();
				dto.setCadd("hyd");
				//dto.setCno(28);
				//dto.setBillAmt(8000.0f); dto.setCname("raja");
				service.fetchAllRecordsByGivenExampleDTO(dto).forEach(System.out::println);
		*/
		  System.out.println("............................");
		   System.out.println(service.removeAllCustomers());
		// close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

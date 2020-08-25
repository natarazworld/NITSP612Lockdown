package com.nt;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj2PASRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		CustomerDTO dto = null, dto1 = null, dto2 = null;
		List<CustomerDTO> listDTO = null;
		// get IOC container
		ctx = SpringApplication.run(SpringDataProj2PASRepoDirectMethodsApplication.class, args);
		// get Service class obj
		service = ctx.getBean("custService", CustomerMgmtService.class);
		//invoke methods
		 //service.fetchAllRecordsSortByProperty("cname", false).forEach(System.out::println);
		/*	 System.out.println("............................................");
			 service.fetchAllRecordsSortByProperties(false,"cname","cadd","billAmt").forEach(System.out::println);*/
		 System.out.println("............................................");
		 service.fetchRecordsByPageNoAndSize(3, 3).forEach(System.out::println);
	
		// close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

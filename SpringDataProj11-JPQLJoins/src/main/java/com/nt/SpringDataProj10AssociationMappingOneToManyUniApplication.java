package com.nt;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.PhoneNumberDTO;
import com.nt.dto.UserDTO;
import com.nt.service.TelcomManagementService;

@SpringBootApplication
public class SpringDataProj10AssociationMappingOneToManyUniApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TelcomManagementService service=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj10AssociationMappingOneToManyUniApplication.class, args);
		//get Service class obj
		/*service=ctx.getBean("tmService",TelcomManagementService.class);
		service.getDataByJoins().forEach(row->{
			 for(Object val:row)
				 System.out.print(val+"    ");
			 System.out.println();
		});
		*/
		
		service=ctx.getBean("tmService",TelcomManagementService.class);
		service.getDataByJoins1("hyd").forEach(row->{
			 for(Object val:row)
				 System.out.print(val+"    ");
			 System.out.println();
		});
				
		//close container
		  ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class

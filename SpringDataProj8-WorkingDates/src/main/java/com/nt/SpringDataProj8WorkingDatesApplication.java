package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.service.EmployeeProfileMgmtService;

@SpringBootApplication
public class SpringDataProj8WorkingDatesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeProfileMgmtService service=null;
		EmployeeInfoDTO dto=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj8WorkingDatesApplication.class, args);
		//get SErvice class object
		service=ctx.getBean("empService",EmployeeProfileMgmtService.class);
		/*//invoke the method
		try {
			//prepare DTO
			dto=new EmployeeInfoDTO();
			dto.setEname("raja");
			dto.setEadd("hyd");
			dto.setDob(new Date(90,10,25,12,10,22));
			dto.setDoj(new Date(114,10,25));
			dto.setBatchTime(new Date());
			
			System.out.println("registered Emp id::"+service.registerEmployee(dto));
			
		}
		catch(Exception e) {
			System.out.println("Problem in  Employee registration");
			e.printStackTrace();
		}*/
		System.out.println("..........................................");
		//invoke method
		service.getAllEmployees().forEach(System.out::println);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

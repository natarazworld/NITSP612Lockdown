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
		UserDTO userDTO=null;
		PhoneNumberDTO phoneDTO1=null,phoneDTO2=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj10AssociationMappingOneToManyUniApplication.class, args);
		//get Service class obj
		service=ctx.getBean("tmService",TelcomManagementService.class);
		//prepare objects
		//child obejcts
		  phoneDTO1=new PhoneNumberDTO();
		  phoneDTO1.setMobileNo(99999991L);
		  phoneDTO1.setType("residence"); 
		  phoneDTO1.setProvider("airtel");
		  
		  phoneDTO2=new PhoneNumberDTO();
		  phoneDTO2.setMobileNo(88888881L);
		  phoneDTO2.setType("home"); 
		  phoneDTO2.setProvider("idea");
		  //parent object
		  userDTO=new UserDTO();
		  userDTO.setName("raja"); userDTO.setAddrs("hyd");
		  userDTO.setPhones(Set.of(phoneDTO1,phoneDTO2));  //java9 feature
		  System.out.println(userDTO);
		//invoke method
		  try {
			  System.out.println(service.registerCustomer(userDTO));
		  }
		  catch(Exception e) {
			  System.out.println("problem in customer registration");
			  e.printStackTrace();
		  }
		
		//close container
		  ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class

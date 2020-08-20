package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectMgmtService;

@SpringBootApplication
public class OrmProj3SpringWithHbBootApplication {

	
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ProjectMgmtService service=null;
		 ProjectDTO dto=null;
		//get IOC container
		ctx=SpringApplication.run(OrmProj3SpringWithHbBootApplication.class, args);
		//get SErvice class obj and invoke the methods...
		   //get Service class object
		   service = ctx.getBean("projService",ProjectMgmtService.class);
		   //save object
		try {
		   //create DTO
		     dto = new ProjectDTO();
		    dto.setProjName("openFx2"); dto.setTeamSize(13);
		    dto.setCompany("POLARIS1"); dto.setCost(100000000.0);
		    dto.setLocation("hyd1");
		   //use service
		   System.out.println(service.registerProject(dto));
		}
		catch(DataAccessException dae) {
		   dae.printStackTrace();
		}
		
		/* System.out.println("......................................");
		 System.out.println("2 Project details ::"+service.fetchProjectById(1));*/
		/*   System.out.println("................................................");
		   System.out.println("2 Project updation::"+service.modifyProjectById(2,10, 200000));*/
		   
		   /*System.out.println("................................................");
		   System.out.println("2 Project deletion::"+service.removeProjectById(2)); */
		   
		   System.out.println("-------------------------------------------");  //for each
		   List<ProjectDTO> listDTO=service.fetchProjectsByCostRange(100000, 300000);
		   listDTO.forEach(dto1->{
			   System.out.println(dto1);
		   });
		   System.out.println(".....................................");
		   listDTO.forEach(System.out::println);  //method reference
		   System.out.println("...................................");
		   System.out.println(listDTO);   //toString
		   System.out.println(".......................................");
		   listDTO.stream().forEach(System.out::println);  //Streaming api
		   
	//close container
		   ((AbstractApplicationContext) ctx).close();
	}

}

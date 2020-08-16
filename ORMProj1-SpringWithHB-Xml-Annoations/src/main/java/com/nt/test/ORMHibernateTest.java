package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectMgmtService;

public class ORMHibernateTest {

	public static void main(String[] args) {
		   ApplicationContext ctx=null;
		   ProjectMgmtService  service=null;
		   ProjectDTO dto=null;
		   //create IOC container
		   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		   
		   //get Service class object
		   service=ctx.getBean("projService",ProjectMgmtService.class);
		   try {
			   //create DTO
			    dto=new ProjectDTO();
			    dto.setProjName("openFx1"); dto.setTeamSize(13);
			    dto.setCompany("POLARIS"); dto.setCost(100000000.0);
			    dto.setLocation("hyd");
			   //use service
			   System.out.println(service.registerProject(dto));
		   }
		   catch(DataAccessException dae) {
			   dae.printStackTrace();
		   }
		   
	//close container
		   ((AbstractApplicationContext) ctx).close();

	}//main
}//class

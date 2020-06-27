package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.DepartmentDTO;
import com.nt.service.DepartmentMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DepartmentMgmtService service=null;
		DepartmentDTO dto=null;
		
		//create ApplicationContext container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("deptService",DepartmentMgmtService.class);
		//preare DTO
		dto=new DepartmentDTO();
		//dto.setDeptno(45);
		dto.setDname("IT"); dto.setLoc("HYD");
		try {
			System.out.println(service.registerDepartment(dto));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class

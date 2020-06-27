package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.dto.DepartmentDTO;
import com.nt.service.DepartmentMgmtService;

@SpringBootApplication
public class DaoBootProj10SimpleJdbcInsertApplication {
	@Autowired
	private DataSource ds;
	
	@Bean
	public SimpleJdbcInsert createSJI() {
		return new SimpleJdbcInsert(ds);
	}
	

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DepartmentMgmtService service=null;
		DepartmentDTO dto=null;
		//getContainer
		ctx=SpringApplication.run(DaoBootProj10SimpleJdbcInsertApplication.class, args);
		
		//get Service class object
			service=ctx.getBean("deptService",DepartmentMgmtService.class);
				//preare DTO
				dto=new DepartmentDTO();
				dto.setDeptno(49);
				dto.setDname("IT1"); dto.setLoc("HYD");
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

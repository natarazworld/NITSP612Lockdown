package com.nt.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService  service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service calss object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		try {
			System.out.println("Emps count ::"+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("..............................");
		try {
			System.out.println("7499 emp name::"+service.fetchEmpNameByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println(".........................");
		try {
		 System.out.println("7499 Emp Details are::"+service.fetchEmpDetailsByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println(".........................");
		try {
		 System.out.println("CLERK,MANAGER Desg  Emp Details are::"+service.fetchEmpDetailsByDesgs("CLERK","MANAGER"));
		}
		catch(DataAccessException dae) {
			System.out.println("11111");
			dae.printStackTrace();
		}
		/*System.out.println("...............................");
		try {
			System.out.println(service.registerEmployee(4567, "Rajesh","SALESMAN",90000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}*/
		/*	try {
				System.out.println(service.hikeEmpSalaryBySalRange(1600, 5));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}
		*/
		/*	try {
				System.out.println(service.fireEmpsBySalaryRange(50000, 100000));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}*/
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}

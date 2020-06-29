package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.BankAccountDTO;
import com.nt.service.BankAccountMgmtService;

public class MappingSQLOperatiosnTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankAccountMgmtService service=null;
		BankAccountDTO dto=null;
		List<BankAccountDTO> listDTO=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("bankService",BankAccountMgmtService.class);
		//invoke the method
		try {
		  dto=service.fetchAccountDetailsByNo(1001);	
		  System.out.println(dto);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("...........................................");
		try {
			listDTO=service.fetchAccountDetailsByBalanceRange(10000,30000);
			listDTO.forEach(System.out::println);				
			
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("............................................");
		try {
			System.out.println("no.of employees that added with bonus ::"+service.addBounsToAccountsByBalanceRange(0,5000, 1000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class

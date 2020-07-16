package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.BankMgmtService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankMgmtService proxy=null;
		//create IOC conatiner
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//Get Manager
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		proxy=ctx.getBean("bankService",BankMgmtService.class);
		manager.signIn("raja","rani");
		try {
			//withdraw
			System.out.println(proxy.withdrawMoney(1001,2000));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(".................................");
		try {
			//withdraw
			System.out.println(proxy.depositeMoney(1003,2000));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		manager.singnOut();
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main

}//class

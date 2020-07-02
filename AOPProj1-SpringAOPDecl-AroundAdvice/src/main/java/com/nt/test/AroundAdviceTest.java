package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//call getBean(-) to Proxy class object
		proxy=ctx.getBean("pfb",BankService.class);
		System.out.println("proxy object classname::"+proxy.getClass()+"  super class"+proxy.getClass().getSuperclass());
		try {
		  System.out.println("Simple Intrest Amount::"+proxy.calcSimpleIntrestAmount(100000, 12,2 ));
		  System.out.println("...........................");
		  System.out.println("compound Intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 12,2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class

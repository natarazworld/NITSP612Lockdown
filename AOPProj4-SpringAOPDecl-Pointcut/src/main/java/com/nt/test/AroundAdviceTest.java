package com.nt.test;

import java.util.Arrays;

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
		try {
		  System.out.println("1Simple Intrest Amount::"+proxy.calcSimpleIntrestAmount(100000, 2,12 ));
		  System.out.println(".........................");
		  System.out.println("2Simple Intrest Amount::"+proxy.calcSimpleIntrestAmount(40000, 2,12 ));
		  
		  System.out.println("========================================");
		  System.out.println("1compound Intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 2,12));
		  System.out.println("..........................");
		  System.out.println("2compound Intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 2,12));
		  System.out.println("..........................");
		  System.out.println("3compound Intrest amount::"+proxy.calcCompoundIntrestAmount(150000, 2,12));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class

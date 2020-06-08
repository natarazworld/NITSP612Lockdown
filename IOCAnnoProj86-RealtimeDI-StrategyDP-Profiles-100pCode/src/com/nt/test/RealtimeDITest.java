package com.nt.test;


import java.util.Scanner;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=null;
		MainController controller=null;
		Environment env=null;
		Scanner sc=null;
		String sname=null,sadd=null,m1=null,m2=null,m3=null;
		StudentVO vo=null;
		String result=null;
				//create IOC container
		ctx=new AnnotationConfigApplicationContext();
		 //get access to env object
		env=ctx.getEnvironment();
		 //set active profile
		((ConfigurableEnvironment)env).setActiveProfiles("uat");
		// locate configuration class
		  ctx.register(AppConfig.class);
		  ctx.refresh();
		
		//get Controller class object
		controller=ctx.getBean("controller",MainController.class);
		//read inputs 
		sc=new Scanner(System.in);
		System.out.println("Enter student name::");
		sname=sc.next();
		System.out.println("Enter student address::");
		sadd=sc.next();
		System.out.println("Enter student Marks1::");
		m1=sc.next();
		System.out.println("Enter student Marks2::");
		m2=sc.next();
		System.out.println("Enter student Marks3::");
		m3=sc.next();
		//prepare VO class object
		vo=new StudentVO();
		 vo.setSname(sname); vo.setSadd(sadd);
		vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
		
		//invoke method
		try {
			result=controller.handleStudent(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("STudent Registration failed");
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		

	}//main
}//class

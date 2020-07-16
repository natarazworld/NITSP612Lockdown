package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class TestDriveAdvice {
	
	/*public  void  testDriving(JoinPoint jp)throws Throwable{
		Object args[]=null;
		Writer writer=null;
		
		System.out.println("taget method details"+jp.getSignature()+" "+Arrays.deepToString(jp.getArgs()));
		//get target method arguments
		args=jp.getArgs();
		try {
		  writer=new FileWriter("E:/auditLog.txt",true);
		  writer.write(args[0]+" model car purchase having price"+args[1]+ "with color:"+args[2]+" through excecutive ::"+args[3]+" has come for test driving at ::"+new Date()+"\n");
		  writer.flush();
		  writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
	*/
	
	public  void  testDriving(JoinPoint jp,String model,float rate,String color,String salesman)throws Throwable{
		Object args[]=null;
		Writer writer=null;
		System.out.println(jp.getClass());
		System.out.println(jp.getSignature()+" with args"+Arrays.deepToString(jp.getArgs()));
		//get target method arguments
		color=color+"11";
		try {
		  writer=new FileWriter("E:/auditLog.txt",true);
		  writer.write(model+" model car purchase having price"+rate+ "with color:"+color+" through excecutive ::"+salesman+" has come for test driving at ::"+new Date()+"\n");
		  writer.flush();
		  writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
	
	
}//class

package com.nt.aspect;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;



public class DiscountCuponAdvice {
	
	public  void   cuponGenerator(JoinPoint jp,double billAmt)throws Throwable {
		String cuponMsg=null;
		Writer writer=null;
		System.out.println(jp.getSignature()+" with args"+Arrays.deepToString(jp.getArgs()));
		
		if(billAmt<5000)
			cuponMsg="Avail 5% discount on next purchase";
		else if(billAmt<10000)
			cuponMsg="Avail 10% discount on next purchase";
		else if(billAmt<20000)
			cuponMsg="Avail 20% discount on next purchase";
		else 
			cuponMsg="Avail 30% discount on next purchase";
		
		writer=new FileWriter("E:/cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
		
	}

}

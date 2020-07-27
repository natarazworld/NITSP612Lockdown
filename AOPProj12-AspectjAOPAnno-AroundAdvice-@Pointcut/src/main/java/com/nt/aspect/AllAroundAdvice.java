package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("allAdvice")
public class AllAroundAdvice {
private static Logger logger=Logger.getLogger(AllAroundAdvice.class);
	
	static {
		try {
		PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
		logger.info("Log4j Activated");
		}
		catch(Exception e) {
			logger.fatal("unknown log4j problem");
			e.printStackTrace();
		}
	}
	
	@Pointcut("execution(* com.nt.service.ECommerceStore.*(..))")
	public void myPtc() {
		
	}
	
	@Around(value = "myPtc()")
	@Order(5)
	public Object logging(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=0;
		Object args[]=null;
		logger.debug("Entering into "+pjp.getSignature()+" with "+Arrays.deepToString(pjp.getArgs()));
		args=pjp.getArgs();
		if(pjp.getSignature().getName().equalsIgnoreCase("calcBillAmount")) {
			args[0]=(Float)args[0]+1;
		}
			
		retVal=pjp.proceed(args);
		logger.debug("Exiting from "+pjp.getSignature()+" with "+Arrays.deepToString(pjp.getArgs()));
		return retVal;
		
	}
	
	
	@Around(value = "myPtc()")
	@Order(10)
	public   Object monitor(ProceedingJoinPoint pjp)throws Throwable{
		long start=0,end=0;
		Object retVal=null;
		
		start=System.currentTimeMillis();
		retVal=pjp.proceed();
		end=System.currentTimeMillis();
		
		System.out.println(pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs())+" has taken"+(end-start)+" ms");
		
		return retVal;
	}
	
	
   private Map<String,Object> cacheMap=new HashMap();
	
	@Around("myPtc()")
	@Order(2)
	public  Object caching (ProceedingJoinPoint pjp,Exception ex)throws Throwable{
		String key=null;
		Object retVal=null;
		key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!cacheMap.containsKey(key)) {
			retVal=pjp.proceed();
			cacheMap.put(key, retVal);
			System.out.println("from target");
		}
		else {
			retVal=cacheMap.get(key);
			System.out.println("from cache");
		}
		return retVal;
	}//method


}//class

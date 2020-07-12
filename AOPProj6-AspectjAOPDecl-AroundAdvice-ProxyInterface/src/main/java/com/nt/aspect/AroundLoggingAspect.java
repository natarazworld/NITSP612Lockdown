package com.nt.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;

public class AroundLoggingAspect {
	private static Logger logger=Logger.getLogger(AroundLoggingAspect.class);
	
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

}

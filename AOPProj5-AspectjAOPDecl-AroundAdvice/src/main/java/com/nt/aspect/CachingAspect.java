package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CachingAspect {
	private Map<String,Object> cacheMap=new HashMap();
	
	public  Object caching (ProceedingJoinPoint pjp)throws Throwable{
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

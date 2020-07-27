package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.manager.AuthenticationManager;

@Aspect
@Component("securityAdvice")
public class SecurityCheckAspect {
	@Autowired
	 private AuthenticationManager manager;
	
	

	 // Before advice method
	@Before("execution(java.lang.String com.nt.service.BankMgmtServiceImpl.*(..))")
	public void  check(JoinPoint jp) throws Throwable{
		if(!manager.isAuthenticated())
			throw new IllegalArgumentException("Authetication failed");
		
	}

}

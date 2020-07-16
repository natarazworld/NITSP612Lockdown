package com.nt.aspect;

import org.aspectj.lang.JoinPoint;

import com.nt.manager.AuthenticationManager;

public class SecurityCheckAspect {
	 private AuthenticationManager manager;
	
	public SecurityCheckAspect(AuthenticationManager manager) {
		this.manager = manager;
	}

	 // Before advice method
	public void  check(JoinPoint jp) throws Throwable{
		if(!manager.isAuthenticated())
			throw new IllegalArgumentException("Authetication failed");
		
	}

}

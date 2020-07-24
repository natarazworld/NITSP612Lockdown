package com.nt.aspect;

import org.aspectj.lang.JoinPoint;

import com.nt.errors.InternalProblemException;

public class CommonExceptionGrapherAspect {
	
	public void  exceptionGraphing(JoinPoint jp,IllegalAccessException iae) {
		throw new InternalProblemException(iae.getMessage());
	}

}

package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.BankService;

public class CommonStaticPtc extends StaticMethodMatcherPointcut {
	private String methodName;
	private Class clazz;

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if(method.getName().equalsIgnoreCase(methodName) && targetClass==clazz)
		return true;
		else
		  return false;
	}

}

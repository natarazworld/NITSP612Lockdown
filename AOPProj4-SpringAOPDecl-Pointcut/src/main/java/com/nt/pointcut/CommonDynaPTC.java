package com.nt.pointcut;

import java.lang.reflect.Method;

import javax.swing.text.html.parser.TagElement;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class CommonDynaPTC extends DynamicMethodMatcherPointcut {
	private String methodName;
	private Class clazz;
	private float pAmtRanage;

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public void setPAmtRanage(float pAmtRanage) {
		this.pAmtRanage = pAmtRanage;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(method.getName().equalsIgnoreCase(methodName) && targetClass==clazz && ((Float)args[0])>pAmtRanage)
		return true;
		else
			return false;
	}

}

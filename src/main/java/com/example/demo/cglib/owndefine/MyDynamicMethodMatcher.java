package com.example.demo.cglib.owndefine;

import java.lang.reflect.Method;

import org.springframework.aop.MethodMatcher;

public class MyDynamicMethodMatcher implements MethodMatcher{

	public boolean matches(Method method, Class<?> targetClass) {
		return false;
	}

	public boolean isRuntime() {
		return true;
	}

	//DynamicMethodMatcher��ֻ����������matches����return true, ���������Żᱻ����
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		return true;
	}

}

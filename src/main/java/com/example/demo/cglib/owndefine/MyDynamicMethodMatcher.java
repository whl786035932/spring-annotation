package com.example.demo.cglib.owndefine;

import java.lang.reflect.Method;

import org.springframework.aop.MethodMatcher;

public class MyDynamicMethodMatcher implements MethodMatcher{

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return false;
	}

	@Override
	public boolean isRuntime() {
		return true;
	}

	//DynamicMethodMatcher��ֻ����������matches����return true, ���������Żᱻ����
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		return true;
	}

}

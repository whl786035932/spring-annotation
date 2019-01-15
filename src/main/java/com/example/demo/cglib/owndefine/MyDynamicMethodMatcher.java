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

	//DynamicMethodMatcher中只有两参数的matches方法return true, 三个参数才会被调用
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		return true;
	}

}

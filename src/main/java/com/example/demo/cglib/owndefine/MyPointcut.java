package com.example.demo.cglib.owndefine;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

class MyPointcut implements Pointcut{

	@Override
	public ClassFilter getClassFilter() {
		return new MyClassFilter();
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		// TODO Auto-generated method stub
		return new MyStaticMethodMatcher();
	}
	
}

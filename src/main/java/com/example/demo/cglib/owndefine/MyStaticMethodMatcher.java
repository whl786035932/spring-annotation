package com.example.demo.cglib.owndefine;

import java.lang.reflect.Method;

import org.springframework.aop.MethodMatcher;

import com.example.demo.cglib.RequestTable;

public class MyStaticMethodMatcher implements MethodMatcher{

	public boolean matches(Method method, Class<?> targetClass) {
//		System.out.print("¾²Ì¬µÄMyStaticMethodMatcher");
		if(RequestTable.class.equals(targetClass) && method.getName().equals("request")) {
//			System.out.println("-----"+true);
			return true;
		}
//		System.out.println("-----"+false);
		return false;
	}

	public boolean isRuntime() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		return false;
	}

}

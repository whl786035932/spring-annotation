package com.example.demo.cglib.owndefine;

import org.springframework.aop.ClassFilter;

import com.example.demo.cglib.RequestTable;

public class MyClassFilter implements ClassFilter{

	@Override
	public boolean matches(Class<?> clazz) {
		
		//只给RequestTable做切面逻辑
		boolean equals = RequestTable.class.equals(clazz);
//		System.out.println("自定义的classfitler . equals ="+equals);
		return  equals;
	}

}

package com.example.demo.cglib.owndefine;

import org.springframework.aop.ClassFilter;

import com.example.demo.cglib.RequestTable;

public class MyClassFilter implements ClassFilter{

	@Override
	public boolean matches(Class<?> clazz) {
		
		//ֻ��RequestTable�������߼�
		boolean equals = RequestTable.class.equals(clazz);
//		System.out.println("�Զ����classfitler . equals ="+equals);
		return  equals;
	}

}

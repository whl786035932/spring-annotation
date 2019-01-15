package com.example.demo.cglib;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.cglib.proxy.Enhancer;

/**
 * 测试cglib 动态生成字节码文件
 * cglib
 * @author whl
 *
 */
public class TestCglib {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RequestTable.class);
		enhancer.setCallback(new RequestCallback());
		RequestTable create = (RequestTable) enhancer.create();
		create.request();
		
//		ClassFilter
//		Pointcut
	}

}


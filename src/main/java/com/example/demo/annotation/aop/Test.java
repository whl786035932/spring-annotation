package com.example.demo.annotation.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AOPConfig;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
//		PurchaseService bean = context.getBean(PurchaseService.class);
//		bean.purchaseProduct("·¿×Ó", 1000, "111");
		
	}

}

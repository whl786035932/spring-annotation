package com.example.demo.trantx;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTx {
	//hV+WKTbvl2e9
	@SuppressWarnings("resource")
	@Test
	public void test() {
		System.out.println("3");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TXConfig.class);
		
		EmplService emplService = applicationContext.getBean(EmplService.class);
		emplService.insertEmpl2();
		emplService.insertEmpl();
	}
}

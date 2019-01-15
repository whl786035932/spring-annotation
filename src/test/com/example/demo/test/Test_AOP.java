package com.example.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.aop.AopLuoji;
import com.example.demo.config.AOPConfig;
//https://blog.csdn.net/hello_worldee/article/details/78136616
public class Test_AOP {
	
	@SuppressWarnings("resource")
	@Test
	public void testAop() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		AopLuoji bean = applicationContext.getBean(AopLuoji.class);
		bean.div(1, 1);
		applicationContext.close();
		
	}
	
	@Test
	public void testaop() {
		System.out.println("@@@@@@@@");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		AopLuoji mathCalculator = applicationContext.getBean(AopLuoji.class);
		
		mathCalculator.div(1, 0);
		
		applicationContext.close();
		
	}
}


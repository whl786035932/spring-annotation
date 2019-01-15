package com.example.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.SpringProfileConfig;

public class IOC_TestProfile {
	/**
	 * ͨ��ָ��������Ĳ���,�ֶ��������У�-Dspring.profiles.active=test
	 */
	@SuppressWarnings("resource")
	@Test
	public void testProfile() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringProfileConfig.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}
	/**
	 *ͨ������ָ������������ 
	 */
	@SuppressWarnings("resource")
	@Test
	public void testPorileByCode() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("test");
//		applicationContext.registerBeanDefinition("profile", SpringProfileConfig.class);
		applicationContext.register(SpringProfileConfig.class);
		applicationContext.refresh();
		
		
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}
	
	
	
}

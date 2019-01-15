package com.example.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.SpringProfileConfig;

public class IOC_TestProfile {
	/**
	 * 通过指定虚拟机的参数,手动用命令行，-Dspring.profiles.active=test
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
	 *通过代码指定环境变量的 
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

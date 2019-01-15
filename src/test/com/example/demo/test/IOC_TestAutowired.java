package com.example.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.aware.MyApplicationAware;
import com.example.demo.config.AutowiredResourcePrimaryConfig;
import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;

public class IOC_TestAutowired {

	/**
	 *  MyApplicationAware  constructor---------
		MyApplicationAware   setApplicationContext-------
		UserServiceµÄ[UserDao]=UserDao.label=2
		MyApplicationAware[applicationContextAware]=org.springframework.context.annotation.AnnotationConfigApplicationContext@136a2062: startup date [Thu Nov 08 17:59:14 CST 2018]; root of context hierarchy
		org.springframework.context.annotation.AnnotationConfigApplicationContext@136a2062: startup date [Thu Nov 08 17:59:14 CST 2018]; root of context hierarchy
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowired() {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredResourcePrimaryConfig.class);
		UserService userService = applicationContext.getBean(UserService.class);
		System.out.println(userService.toString());
		
//		UserDao bean = applicationContext.getBean(UserDao.class);
//		System.out.println(bean);
		
		MyApplicationAware bean = applicationContext.getBean(MyApplicationAware.class);
		System.out.println(bean.toString());
		System.out.println(applicationContext);
	}
}

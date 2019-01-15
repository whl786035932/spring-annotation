package com.example.demo.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationAware implements ApplicationContextAware{
	private ApplicationContext ApplicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("MyApplicationAware   setApplicationContext-------");
		this.ApplicationContext = applicationContext;
	}

	public MyApplicationAware() {
		super();
		System.out.println(" MyApplicationAware  constructor---------");
	}
	
	@Override
	public String toString() {
		return "MyApplicationAware[applicationContextAware]="+ApplicationContext;
	}

}

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.Car;
import com.example.demo.ext.MyApplicationListener;
import com.example.demo.ext.MyBeanDefinitionRegistryPostProcessor;
import com.example.demo.ext.MyBeanFactoryPostProcessor;
import com.example.demo.ext.MyDefineEventListener;
import com.example.demo.lifcycle.MyBeanPosProcessor;

@Configuration
public class MyBeanFactoryPostProcessorConfig {

	
	@Bean
	public MyBeanFactoryPostProcessor myBeanFactoryBeanProcessor() {
		return new MyBeanFactoryPostProcessor();
	}
	
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean
	public MyBeanPosProcessor myBeanPosProcessor() {
		return  new MyBeanPosProcessor();
	}
	
	@Bean
	public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {
		return new MyBeanDefinitionRegistryPostProcessor();
	}
	
	@Bean
	public MyApplicationListener myApplicationListener() {
		return new  MyApplicationListener();
	}
	
	@Bean
	public MyDefineEventListener myDefineEventListener() {
		MyDefineEventListener myDefineEventListener = new MyDefineEventListener();
		return myDefineEventListener;
	}
	

}

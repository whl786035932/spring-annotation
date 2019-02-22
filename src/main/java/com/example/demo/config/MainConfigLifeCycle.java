package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.ext.MyBeanFactoryPostProcessor;
import com.example.demo.lifcycle.Boss;
import com.example.demo.lifcycle.Car;
import com.example.demo.lifcycle.House;
import com.example.demo.lifcycle.MyBeanPosProcessor;

@Configuration
public class MainConfigLifeCycle {
	@Bean
	public Car car() {
		return new Car();
	}
	
	
	@Bean(initMethod="init",destroyMethod="destroy")
	public Boss boss() {
		return new Boss();
	}
	
	@Bean
	public House house() {
		House house = new House("天通苑");
		house.setAddress("天通西苑");
		return  house;
		
	}
	
	@Bean
	public MyBeanPosProcessor  myBeanpostProcessor() {
		return new MyBeanPosProcessor();
	}
	
	@Bean
	public MyBeanFactoryPostProcessor myBeanFactoryBeanProcessor() {
		return new MyBeanFactoryPostProcessor();
	}
}

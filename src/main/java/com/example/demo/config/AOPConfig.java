package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.annotation.aop.LogAspect;
import com.example.demo.annotation.aop.PurchaseService;
import com.example.demo.aop.AopAspect;
import com.example.demo.aop.AopLuoji;

@EnableAspectJAutoProxy
@Configuration
public class AOPConfig {

	@Bean
	public AopLuoji aopLuoji() {
		return new AopLuoji();
	}
	
	
	@Bean
	public AopAspect aopAspect() {
		return new AopAspect();
	}
	
//	@Bean
//	public PurchaseService purchaseService() {
//		return new PurchaseService();
//	}
////	
////	
//	@Bean
//	public LogAspect logAspect() {
//		return new LogAspect();
//	}
}

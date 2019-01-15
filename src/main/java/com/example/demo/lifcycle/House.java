package com.example.demo.lifcycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ��������������,@PostConsturct:Bean�����������Ը�ֵ,@PreDestroy :ApplicationContext �رպ�����Bean
 * @author whl
 *
 */
public class House {

	public House() {
		System.out.println("House   constructor----------");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("House   ���Ը�ֵ----------");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("House  destroy-----------");
	}
}

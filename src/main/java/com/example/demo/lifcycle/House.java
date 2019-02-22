package com.example.demo.lifcycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ��������������,@PostConsturct:Bean�����������Ը�ֵ,@PreDestroy :ApplicationContext �رպ�����Bean
 * @author whl
 *
 */
public class House {
	
	private  String address;
	
	public House() {
		System.out.println("House   constructor----------");
	}
	
	public House(String address) {
		System.out.println(" House  �вι��췽��------------------------------");
		this.address = address;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("House   ���Ը�ֵ----------");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("House  destroy-----------");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("����ȷ����ַ��%%%%%%%%%%%%%%%%%%%");
		this.address = address;
	}
	
	
	
	
}

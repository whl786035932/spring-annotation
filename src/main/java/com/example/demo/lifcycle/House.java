package com.example.demo.lifcycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 测试生命周期类,@PostConsturct:Bean被创建后属性赋值,@PreDestroy :ApplicationContext 关闭后销毁Bean
 * @author whl
 *
 */
public class House {
	
	private  String address;
	
	public House() {
		System.out.println("House   constructor----------");
	}
	
	public House(String address) {
		System.out.println(" House  有参构造方法------------------------------");
		this.address = address;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("House   属性赋值----------");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("House  destroy-----------");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("房子确定地址了%%%%%%%%%%%%%%%%%%%");
		this.address = address;
	}
	
	
	
	
}

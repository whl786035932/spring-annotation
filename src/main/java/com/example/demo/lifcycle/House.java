package com.example.demo.lifcycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 测试生命周期类,@PostConsturct:Bean被创建后属性赋值,@PreDestroy :ApplicationContext 关闭后销毁Bean
 * @author whl
 *
 */
public class House {

	public House() {
		System.out.println("House   constructor----------");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("House   属性赋值----------");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("House  destroy-----------");
	}
}

package com.example.demo.lifcycle;
/**
 * 测试生命周期类，在配置类中@Bean(init="初始化的方法",destroy="销毁的方法")
 * @author whl
 *
 */
public class Boss {

	public Boss() {
		System.out.println("Boss  contructor---");
	}
	
	public void init() {
		System.out.println("Boss  init ------");
	}
	
	public void destroy() {
		System.out.println("Bosss destroy");
	}
	
	
}

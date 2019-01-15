package com.example.demo.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 测试生命周期的类
 * @author whl
 *
 */
public class Car implements InitializingBean,DisposableBean{
	

	public Car() {
		super();
		System.out.println("car  无参的构造");
	}
	
	public void init() {
		System.out.println("car   init  method");
	}
	
	public void destroy() {
		System.out.println("car  destroy method");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("car属性被赋值后调用");
	}
	
}

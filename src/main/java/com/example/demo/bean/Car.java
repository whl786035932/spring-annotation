package com.example.demo.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * �����������ڵ���
 * @author whl
 *
 */
public class Car implements InitializingBean,DisposableBean{
	

	public Car() {
		super();
		System.out.println("car  �޲εĹ���");
	}
	
	public void init() {
		System.out.println("car   init  method");
	}
	
	public void destroy() {
		System.out.println("car  destroy method");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("car���Ա���ֵ�����");
	}
	
}

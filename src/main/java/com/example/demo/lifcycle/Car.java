package com.example.demo.lifcycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * �����������ڵ��࣬ʵ��InitializingBean������bean��ɺ�ʼ�������Ը�ֵ
 * @author whl
 *
 */
public class Car implements InitializingBean,DisposableBean{
	

	public Car() {
		super();
		System.out.println("car  �޲εĹ���");
	}
	
	
	
	public void destroy() {
		System.out.println("car  destroy method");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("car���Ա���ֵ�����");
	}
	
}

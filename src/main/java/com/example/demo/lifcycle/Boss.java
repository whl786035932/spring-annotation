package com.example.demo.lifcycle;
/**
 * �������������࣬����������@Bean(init="��ʼ���ķ���",destroy="���ٵķ���")
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

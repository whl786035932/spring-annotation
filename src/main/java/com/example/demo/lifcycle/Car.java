package com.example.demo.lifcycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 测试生命周期的类，实现InitializingBean，创建bean完成后开始进行属性赋值
 * @author whl
 *
 */
public class Car implements InitializingBean,DisposableBean{
	

	public Car() {
		super();
		System.out.println("car  无参的构造");
	}
	
	
	
	public void destroy() {
		System.out.println("car  destroy method");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("car属性被赋值后调用");
	}
	
}

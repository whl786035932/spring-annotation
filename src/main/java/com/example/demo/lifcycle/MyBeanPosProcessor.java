package com.example.demo.lifcycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 后置处理器
 * Bean初始化前后逻辑
 * @author whl
 *
 */
public class MyBeanPosProcessor  implements BeanPostProcessor{
	/**
	 * 在待用构造方法之后，属性赋值之前那执行
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization---"+beanName+"---->"+bean);
		return bean;
	}
	/**
	 * 在属性赋值之后执行
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization ----"+beanName+"---->"+bean);
		return bean;
	}

}

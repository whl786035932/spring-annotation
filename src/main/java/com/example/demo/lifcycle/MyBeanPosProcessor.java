package com.example.demo.lifcycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ���ô�����
 * Bean��ʼ��ǰ���߼�
 * @author whl
 *
 */
public class MyBeanPosProcessor  implements BeanPostProcessor{
	/**
	 * �ڴ��ù��췽��֮�����Ը�ֵ֮ǰ��ִ��
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization---"+beanName+"---->"+bean);
		return bean;
	}
	/**
	 * �����Ը�ֵ֮��ִ��
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization ----"+beanName+"---->"+bean);
		return bean;
	}

}

package com.example.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;

import com.example.demo.bean.Color;
/**
 * 创建一个spring的FactoryBean,返回的Object就会自动注册到IOC容器中
 * @author whl
 *
 */
public class MyColorFactoryBean implements FactoryBean<Color>{

	public Color getObject() throws Exception {
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	public boolean isSingleton() {
		return false;
	}

}

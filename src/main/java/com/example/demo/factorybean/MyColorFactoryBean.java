package com.example.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;

import com.example.demo.bean.Color;
/**
 * ����һ��spring��FactoryBean,���ص�Object�ͻ��Զ�ע�ᵽIOC������
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

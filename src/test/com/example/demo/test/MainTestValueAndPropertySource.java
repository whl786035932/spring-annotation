package com.example.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.example.demo.config.ValueAndPropertySourceConfig;
import com.example.demo.value.PersonValue;

/**
 * ≤‚ ‘@Value ∫Õ@PropertySource
 * @author whl
 *
 */
public class MainTestValueAndPropertySource {
	
	/**
	 * ≤‚ ‘@Value
	 */
	@SuppressWarnings("resource")
	@Test
	public void testValue() {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValueAndPropertySourceConfig.class);
		PersonValue bean = applicationContext.getBean(PersonValue.class);
		System.out.println(bean.toString());
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String nickName = environment.getProperty("nickname");
		System.out.println(nickName);
	}
}

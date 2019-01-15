package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.value.PersonValue;
/**
 * @PropertySource �����ⲿ�����ļ�
 * @author whl
 *
 */
@PropertySource(value= {"classpath:spring-annotation.properties"})
@Configuration

//@ComponentScan("com.example.demo.value")
public class ValueAndPropertySourceConfig {
	
	@Bean
	public PersonValue personValue() {
		return new PersonValue();
	}
}

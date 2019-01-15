package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @Value 可以是Spel表达式，也可以从环境中取属性值，即从配置文件中读取属性值${}
 * @author whl
 *
 */
public class PersonValue {
	@Value("#{20+8}")
	private Integer age;
	@Value("王海丽")
	private String name;
	@Value("${nickname}")
	private String nickname;
	public Integer getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return this.name+"="+this.age+";他的昵称="+nickname;
	}
	
	
	public PersonValue() {
		System.out.println("PersonValue constructor-----------");
	}
}

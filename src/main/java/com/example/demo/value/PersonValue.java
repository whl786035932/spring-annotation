package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @Value ������Spel���ʽ��Ҳ���Դӻ�����ȡ����ֵ�����������ļ��ж�ȡ����ֵ${}
 * @author whl
 *
 */
public class PersonValue {
	@Value("#{20+8}")
	private Integer age;
	@Value("������")
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
		return this.name+"="+this.age+";�����ǳ�="+nickname;
	}
	
	
	public PersonValue() {
		System.out.println("PersonValue constructor-----------");
	}
}

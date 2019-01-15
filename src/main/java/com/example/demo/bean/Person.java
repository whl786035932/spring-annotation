package com.example.demo.bean;

import org.springframework.stereotype.Component;

public class Person {
	private String name;
	private Integer age;
	public Person() {
		System.out.println("Person  constructor.........");
		
	}
	public Person(String name, Integer age) {
		super();
		System.out.println("Person 嗤歌更夛。。。。。。。。。。");
		this.name = name;
		this.age = age;
	}
	public Integer getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}

}

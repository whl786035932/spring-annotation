package com.example.demo.bean;

import org.springframework.stereotype.Component;

//@Component
public class Student {

	private String name;
	
	private Integer age;
	public Student() {
		System.out.println("student constructor.........");
	}

	public Student(String name, Integer age) {
		super();
		System.out.println("student 嗤歌更夛。。。。。。。。。。");
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

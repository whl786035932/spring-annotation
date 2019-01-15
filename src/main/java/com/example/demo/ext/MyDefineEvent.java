package com.example.demo.ext;

import org.springframework.context.ApplicationEvent;

public class MyDefineEvent extends  ApplicationEvent {
	
	public MyDefineEvent(Object source) {
		super(source);
		
	}

}

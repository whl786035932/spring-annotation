package com.example.demo.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener  implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(" MyApplicationListener ----------���������¼���="+event.toString());
	}

}

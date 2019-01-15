package com.example.demo.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener  implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(" MyApplicationListener ----------监听道德事件是="+event.toString());
	}

}

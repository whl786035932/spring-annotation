package com.example.demo.ext;

import org.springframework.context.ApplicationListener;

public class MyDefineEventListener implements ApplicationListener<MyDefineEvent>{

	public void onApplicationEvent(MyDefineEvent event) {
		System.out.println("�յ��Զ�����¼�="+event.getSource());
	}

}

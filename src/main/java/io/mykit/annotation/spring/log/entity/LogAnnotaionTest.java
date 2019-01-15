package io.mykit.annotation.spring.log.entity;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogAnnotaionTest {
	
	@Test
	public void testLogAnnotation(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		
		SystemLogService systemLogService = (SystemLogService) context.getBean("systemLogService");
		systemLogService.selectSystemLog("1");
		
	}

}

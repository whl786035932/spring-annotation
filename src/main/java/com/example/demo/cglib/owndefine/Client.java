package com.example.demo.cglib.owndefine;

import java.lang.reflect.Method;

import org.hibernate.cfg.AnnotatedClassType;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import com.example.demo.cglib.RequestTable;


public class Client {

	
	public static void main(String[] args) {
		MyPointcut myPointcut = new MyPointcut();
		
		//advice定义，这个是横切逻辑的定义，这里是方法执行前的横切逻辑---前置通知
		MethodBeforeAdvice advice = new MethodBeforeAdvice() {
			
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("waitting for you ");
				System.out.println(target.getClass().getSimpleName()+";"+method.getName());
			}
		};
		
		//spring 中对Aspect, pointcut,和advice的封装类
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(myPointcut);
		advisor.setAdvice(advice);
		
		
		//spring的基本编入器， weaving 和weaver
		ProxyFactory weaver = new ProxyFactory();
		weaver.setTarget(new RequestTable());  //指定目标代理对象
		weaver.addAdvisor(advisor);  //指定Aspect
		
		RequestTable proxyObject = (RequestTable) weaver.getProxy(); //生成代理对象，这里没有接口，调用cglib
		
		proxyObject.request();
		
		
		
		
		
		
		
	}
}

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
		
		//advice���壬����Ǻ����߼��Ķ��壬�����Ƿ���ִ��ǰ�ĺ����߼�---ǰ��֪ͨ
		MethodBeforeAdvice advice = new MethodBeforeAdvice() {
			
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("waitting for you ");
				System.out.println(target.getClass().getSimpleName()+";"+method.getName());
			}
		};
		
		//spring �ж�Aspect, pointcut,��advice�ķ�װ��
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(myPointcut);
		advisor.setAdvice(advice);
		
		
		//spring�Ļ����������� weaving ��weaver
		ProxyFactory weaver = new ProxyFactory();
		weaver.setTarget(new RequestTable());  //ָ��Ŀ��������
		weaver.addAdvisor(advisor);  //ָ��Aspect
		
		RequestTable proxyObject = (RequestTable) weaver.getProxy(); //���ɴ����������û�нӿڣ�����cglib
		
		proxyObject.request();
		
		
		
		
		
		
		
	}
}

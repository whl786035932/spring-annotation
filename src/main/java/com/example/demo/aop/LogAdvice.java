package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ����ע���������߼�
 * @author whl
 *
 */
@Aspect
public class LogAdvice {
	
	//����һ��������Ϊ������id
	@Pointcut("execution(* com.example.demo.service.TestAOPService.*(..))")
	private void allMethod() {}
	
	@Before("allMethod()")
	//spring��aop���������᷵��һ�����ӵ㣬 Ȼ����֪ͨ�п���ʹ�����ӵ�ʵ�����ǵ������߼�
	public void myBeforeAdvice(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println(className+"--------ǰ��֪ͨ-------"+methodname);
	}
	
	@After("allMethod")
	public void myAfterAdvice(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println(className+"--------����֪ͨ-------"+methodname);
		
	}
	
	@Around("allMethod")
	public void myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����֪ͨ��ִ�д���ǰ");
		joinPoint.proceed();
		System.out.println("����֪ͨ��ִ�д����");
		
	}
	

}

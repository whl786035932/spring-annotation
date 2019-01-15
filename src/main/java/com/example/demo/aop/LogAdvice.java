package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义注解版的切面逻辑
 * @author whl
 *
 */
@Aspect
public class LogAdvice {
	
	//定义一个方法作为切入点的id
	@Pointcut("execution(* com.example.demo.service.TestAOPService.*(..))")
	private void allMethod() {}
	
	@Before("allMethod()")
	//spring的aop创建代理后会返回一个连接点， 然后在通知中可以使用连接点实现我们的切面逻辑
	public void myBeforeAdvice(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println(className+"--------前置通知-------"+methodname);
	}
	
	@After("allMethod")
	public void myAfterAdvice(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println(className+"--------后置通知-------"+methodname);
		
	}
	
	@Around("allMethod")
	public void myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕通知，执行代码前");
		joinPoint.proceed();
		System.out.println("环绕通知，执行代码后");
		
	}
	

}

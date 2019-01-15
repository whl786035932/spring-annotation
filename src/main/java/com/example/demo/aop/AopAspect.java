package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义AOP的切面类，注册到IOC容器中，告知容器是切面类
 * @author whl
 *
 */
@Aspect
public class AopAspect {
	
	@Pointcut("execution(public int com.example.demo.aop.AopLuoji.*(..))")
	public void pointCut(){};
	
	@Before(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@Before("pointCut()")
	public void methodStart() {
		System.out.println("方法之前");
	}
	@After(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@After("com.example.demo.aop.AopAspect.pointCut()")
	public void  methodAfter() {
		System.out.println("方法之后");
	}
	@AfterReturning(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@AfterReturning("com.example.demo.aop.AopAspect.pointCut()")
	public void methodReturn() {
		System.out.println("方法正常返回");
	}
	@AfterThrowing(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@AfterThrowing("com.example.demo.aop.AopAspect.pointCut()")
	public void methodThrowing() {
		System.out.println("方法抛出异常");
	}
	
//	@Around(value="execution(public int com.example.demo..aop.AopLuoji.*(..))")
//	public void around() {
//		System.out.println("环绕通知");
//		
//	}
}

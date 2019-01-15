package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ����AOP�������࣬ע�ᵽIOC�����У���֪������������
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
		System.out.println("����֮ǰ");
	}
	@After(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@After("com.example.demo.aop.AopAspect.pointCut()")
	public void  methodAfter() {
		System.out.println("����֮��");
	}
	@AfterReturning(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@AfterReturning("com.example.demo.aop.AopAspect.pointCut()")
	public void methodReturn() {
		System.out.println("������������");
	}
	@AfterThrowing(value="execution(public int com.example.demo.aop.AopLuoji.*(..))")
//	@AfterThrowing("com.example.demo.aop.AopAspect.pointCut()")
	public void methodThrowing() {
		System.out.println("�����׳��쳣");
	}
	
//	@Around(value="execution(public int com.example.demo..aop.AopLuoji.*(..))")
//	public void around() {
//		System.out.println("����֪ͨ");
//		
//	}
}

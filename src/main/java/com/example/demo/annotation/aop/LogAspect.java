package com.example.demo.annotation.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 定义日志的切面
 * 
 * @author whl
 *
 */
@Aspect
public class LogAspect {

	/**
	 * JoinPoint jp 连接点
	 * FileLog fl 自定义的aop的注解
	 * @param jp
	 * @param fl
	 */
	@AfterReturning("within(com.example.demo..*) && @annotation(fl)")
	public void addSuccesLog(JoinPoint jp, FileLog fl) {
		Object[] params= jp.getArgs();  //目标方法体参数
		
		//目标的类名
		String className = jp.getTarget().getClass().toString();
		
		//获取目标方法签名
		String signature = jp.getSignature().toString();
		
		signature.substring(signature.lastIndexOf(".")+1, signature.indexOf("("));
		
		//获取注解值
		String desc = fl.value();
	}
	
	/**
	 * 标注该方法是异常通知.当目标方法出现异常时， 执行方法体
	 */
	@AfterThrowing(value="within(com.example.demo..*) && @annotation(fl)",throwing="e")
	public void addExceptionLog(Joinpoint jp, FileLog fl, Exception e) {
		
	}
	
	
	

}

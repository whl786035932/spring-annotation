package com.example.demo.annotation.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ������־������
 * 
 * @author whl
 *
 */
@Aspect
public class LogAspect {

	/**
	 * JoinPoint jp ���ӵ�
	 * FileLog fl �Զ����aop��ע��
	 * @param jp
	 * @param fl
	 */
	@AfterReturning("within(com.example.demo..*) && @annotation(fl)")
	public void addSuccesLog(JoinPoint jp, FileLog fl) {
		Object[] params= jp.getArgs();  //Ŀ�귽�������
		
		//Ŀ�������
		String className = jp.getTarget().getClass().toString();
		
		//��ȡĿ�귽��ǩ��
		String signature = jp.getSignature().toString();
		
		signature.substring(signature.lastIndexOf(".")+1, signature.indexOf("("));
		
		//��ȡע��ֵ
		String desc = fl.value();
	}
	
	/**
	 * ��ע�÷������쳣֪ͨ.��Ŀ�귽�������쳣ʱ�� ִ�з�����
	 */
	@AfterThrowing(value="within(com.example.demo..*) && @annotation(fl)",throwing="e")
	public void addExceptionLog(Joinpoint jp, FileLog fl, Exception e) {
		
	}
	
	
	

}

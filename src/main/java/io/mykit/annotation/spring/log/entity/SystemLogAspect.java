package io.mykit.annotation.spring.log.entity;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * �����������ʵ��
 * @author whl
 *
 */
@Aspect
@Component
public class SystemLogAspect {

	@Resource
	private SystemLogService systemtLogService;
	
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class); 
	
	/**
	 * �����
	 */
//	@Pointcut("execution (* io.mykit.annotation.spring.log.entity..*.*(..))")
//	@Pointcut("execution(public int com.example.demo.aop.AopLuoji.*(..))")
	@Pointcut("execution(public int io.mykit.annotation.spring.log.entity.SystemLogServiceImpl.*(..))")
	public void controllerAspect() {
		
	}
	
	//ǰ��֪ͨ
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("==========ִ��controllerǰ��֪ͨ===============");
		if(logger.isInfoEnabled()) {
			logger.info("before"+joinPoint);
		}
	}
	
	
	@Around("controllerAspect()")
	public void around(JoinPoint joinPoint) {
		System.out.println("==========��ʼִ��controller����֪ͨ===============");
        long start = System.currentTimeMillis();
        try {
			((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
		    if(logger.isInfoEnabled()){
              logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            }
		    System.out.println("==========����ִ��controller����֪ͨ===============");
		} catch (Throwable e) {
			e.printStackTrace();
			 long end = System.currentTimeMillis();
             if(logger.isInfoEnabled()){
                 logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
             }
		}
	}
	
	@After("controllerAspect()")
	public void after(JoinPoint joinPoint) {

		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		
		try {
			Class<?> targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			
			String operationType ="";
			String operationName = "";
			for (Method method : methods) {
				if(method.getName().equals(methodName)) {
					Class<?>[] clazzs = method.getParameterTypes();
					if(clazzs.length == arguments.length) {
						if(method.isAnnotationPresent(Log.class)) {
							 operationType = method.getAnnotation(Log.class).operationType();
							 operationName = method.getAnnotation(Log.class).operationName();
							 break;
						}
					}
					
				}
			}
			
			System.out.println("===controller����֪ͨ��ʼ===");
			
			System.out.println("���󷽷�:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            System.out.println("��������:" + operationName);  
            SystemLog log = new SystemLog();  
            log.setId("iddd");
            log.setDescription(operationName);  
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            log.setLogType((long)0);  
            log.setRequestIp("10.2.16.80");  
            log.setExceptioncode( null);  
            log.setExceptionDetail( null);  
            log.setParams( null);  
            log.setCreateBy("�û���");  
            log.setCreateDate(new Date());  
            //�������ݿ�  
            systemtLogService.insert(log);
            System.out.println("=====controller����֪ͨ����=====");  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("==����֪ͨ�쳣==");  
            logger.error("�쳣��Ϣ:{}", e.getMessage());  
		}
		
		
	}
	
	
	@AfterReturning("controllerAspect")
	public void afterReturn(JoinPoint joinPoint) {
		 System.out.println("=====ִ��controller���÷���֪ͨ=====");  
         if(logger.isInfoEnabled()){
             logger.info("afterReturn " + joinPoint);
         }
	}
	
	
	
	
}
